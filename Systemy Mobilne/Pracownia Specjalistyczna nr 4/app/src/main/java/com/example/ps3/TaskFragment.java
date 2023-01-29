package com.example.ps3;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class TaskFragment extends Fragment {
    private Task task = new Task();
    private static final String ARG_TASK_ID = "UltiTaskId";
    private final Calendar calendar = Calendar.getInstance();

    public TaskFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        assert getArguments() != null;
        UUID id = (UUID) getArguments().getSerializable(ARG_TASK_ID);

        Task task = TaskStorage.getInstance().getTask(id);
        assert task != null;
        this.task = task;
    }

    public static TaskFragment newInstance (UUID id) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_TASK_ID, id);

        TaskFragment fragment = new TaskFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task, container, false);

        EditText name = view.findViewById(R.id.taskName);
        EditText date = view.findViewById(R.id.taskDate);
        CheckBox checkBox = view.findViewById(R.id.taskDone);
        Spinner categorySpinner = view.findViewById(R.id.catSpinner);

        name.setText(task.getName());
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence name, int start, int before, int count) {
                task.setName(name.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        date.setText(task.getDate().toString());
        date.setEnabled(false);

        checkBox.setChecked(task.isDone());
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            task.setDone(isChecked);
        });

        DatePickerDialog.OnDateSetListener date_temp = (view12,year,month,day) -> {
            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,month);
            calendar.set(Calendar.DAY_OF_MONTH,day);
            setupDateFieldValue(calendar.getTime(),date);
            task.setDate(calendar.getTime());
        };

        date.setOnClickListener(view1 -> new DatePickerDialog(getContext(), date_temp, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show());

        setupDateFieldValue(task.getDate(), date);

        categorySpinner.setAdapter(new ArrayAdapter<>(this.getContext(), android.R.layout.simple_spinner_item,Category.values()));
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                task.setCategory(Category.values()[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        categorySpinner.setSelection(task.getCategory().ordinal());

        return view;
    }

    private void setupDateFieldValue(Date date, EditText editText){
        Locale locale = new Locale("pl","PL");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy",locale);
        editText.setText(dateFormat.format(date));
    }
}

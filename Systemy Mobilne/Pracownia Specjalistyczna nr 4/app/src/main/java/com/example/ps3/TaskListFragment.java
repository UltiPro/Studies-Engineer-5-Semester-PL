package com.example.ps3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.w3c.dom.Text;
import java.util.List;

public class TaskListFragment extends Fragment {
    public static final String KEY_EXTRA_TASK_ID = "UltiTestId";
    private RecyclerView recyclerView;
    private boolean subtitleVisible;

    public TaskListFragment() {}

    public void updateSubtitle()
    {
        TaskStorage taskStorage = TaskStorage.getInstance();
        List<Task> tasks = taskStorage.getTasks();
        int todoTasksCount = 0;
        for(Task task: tasks){
            if(!task.isDone()){
                todoTasksCount++;
            }
        }
        String subtitle = getString(R.string.subtitle_format, todoTasksCount);
        if(!subtitleVisible) subtitle = null;
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        appCompatActivity.getSupportActionBar().setSubtitle(subtitle);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_task_menu,menu);
        MenuItem subtitleItem = menu.findItem(R.id.show_subtitle);
        if(subtitleVisible) subtitleItem.setTitle(R.string.hide_subtitle);
        else subtitleItem.setTitle(R.string.show_subtitle);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.new_task:
                Task task = new Task();
                TaskStorage.getInstance().addTask(task);
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra(TaskListFragment.KEY_EXTRA_TASK_ID, task.getId());
                startActivity(intent);
                return true;
            case R.id.show_subtitle:
                subtitleVisible = !subtitleVisible;
                getActivity().invalidateOptionsMenu();
                updateSubtitle();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        recyclerView = view.findViewById(R.id.taskList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateView();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateView();
    }

    private void updateView () {
        TaskStorage storage = TaskStorage.getInstance();
        List<Task> tasks = storage.getTasks();

        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            recyclerView.setAdapter(new TaskAdapter(tasks));
            return;
        }

        adapter.notifyDataSetChanged();

        updateSubtitle();
    }

    private class TaskHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView date;
        private Task task = null;
        private ImageView iconImageView;
        private CheckBox checkBox;

        public TaskHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.task_list_item, parent, false));
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra(KEY_EXTRA_TASK_ID, task.getId());
                startActivity(intent);
            });

            name = itemView.findViewById(R.id.taskName);
            date = itemView.findViewById(R.id.taskDate);
            iconImageView = itemView.findViewById(R.id.task_item_icon);
            checkBox = itemView.findViewById(R.id.task_item_checkbox);
        }

        void bind (Task task) {
            this.task = task;
            name.setText(task.getName());

            if(name.length()>48) name.setText(task.getName().substring(0, 48-5)+" ...");

            date.setText(task.getDate().toString());

            if(task.getCategory().equals(Category.Home)) iconImageView.setImageResource(R.drawable.ic_home);
            else iconImageView.setImageResource(R.drawable.ic_study);

            checkBox.setChecked(task.isDone());
            if(task.isDone()) name.setPaintFlags(name.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            else name.setPaintFlags(name.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));


        }

        public CheckBox getCheckBox() { return checkBox; }

        public TextView getNameTextView() { return name; }
    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {
        private final List<Task> taskList;

        public TaskAdapter (List<Task> tasks) {
            taskList = tasks;
        }

        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new TaskHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
            holder.bind(taskList.get(position));
            CheckBox checkBox = holder.getCheckBox();
            TextView nameTask = holder.getNameTextView();
            checkBox.setChecked(taskList.get(position).isDone());
            checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                taskList.get(position).setDone(isChecked);
                if(taskList.get(position).isDone()) nameTask.setPaintFlags(nameTask.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                else nameTask.setPaintFlags(nameTask.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            });
        }

        @Override
        public int getItemCount() {
            return taskList.size();
        }
    }
}
package ulti.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int currentIndex = 0;
    TextView textView;

    List<Question> listOfQuestion = new ArrayList<Question>() {{
        add(new Question(R.string.q_a, true));
        add(new Question(R.string.q_b, false));
        add(new Question(R.string.q_c, true));
        add(new Question(R.string.q_d, true));
        add(new Question(R.string.q_e, false));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.Title);
        Button buttonTrue = findViewById(R.id.True);
        Button buttonFalse = findViewById(R.id.False);
        Button buttonNext = findViewById(R.id.Next);

        setNextQuestion();

        buttonTrue.setOnClickListener(v -> {
            int resultMessageId = listOfQuestion.get(currentIndex).isTrueAnswer()
                    ? R.string.correct
                    : R.string.wrong;
            Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
        });

        buttonFalse.setOnClickListener(v -> {
            int resultMessageId = !listOfQuestion.get(currentIndex).isTrueAnswer()
                    ? R.string.correct
                    : R.string.wrong;
            Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
        });

        buttonNext.setOnClickListener(v -> {
            currentIndex++;
            currentIndex %= listOfQuestion.size();
            setNextQuestion();
        });


    }

    public void setNextQuestion() {
        textView.setText(listOfQuestion.get(currentIndex).getQuestionId());
    }
}
package ulti.quiz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button buttonTrue;
    private Button buttonFalse;
    private Button buttonNext;
    private Button buttonPrompt;
    private TextView questionTextView;
    private boolean answerWasShown;
    private int currentIndex = 0;
    private TextView textView;
    public static final String KEY_EXTRA_ANSWER = "./quiz.correctAnswer";
    private static final String KEY_CURRENT_INDEX = "currentIndex";
    private static final int REQUEST_CODE_PROMPT = 0;

    private List<Question> listOfQuestion = new ArrayList<Question>() {{
        add(new Question(R.string.q_a, true));
        add(new Question(R.string.q_b, false));
        add(new Question(R.string.q_c, true));
        add(new Question(R.string.q_d, true));
        add(new Question(R.string.q_e, false));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity","Wykonanie funkcji onCreate");
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            currentIndex = savedInstanceState.getInt(KEY_CURRENT_INDEX);
        }

        textView = findViewById(R.id.Title);
        buttonTrue = findViewById(R.id.True);
        buttonFalse = findViewById(R.id.False);
        buttonNext = findViewById(R.id.Next);
        buttonPrompt = findViewById(R.id.Info);
        questionTextView = findViewById(R.id.False);

        buttonTrue.setOnClickListener(v -> {
            checkAnswerCorrectness(true);
        });

        buttonFalse.setOnClickListener(v -> {
            checkAnswerCorrectness(false);
        });

        buttonNext.setOnClickListener(v -> {
            currentIndex++;
            currentIndex %= listOfQuestion.size();
            answerWasShown = false;
            setNextQuestion();
        });

        buttonPrompt.setOnClickListener((v) -> {
            Intent intent = new Intent(MainActivity.this, PromptActivity.class);
            boolean correctAnswer = listOfQuestion.get(currentIndex).isTrueAnswer();
            intent.putExtra(KEY_EXTRA_ANSWER, correctAnswer);
            startActivityForResult(intent, REQUEST_CODE_PROMPT);
        });

        setNextQuestion();
    }

    public void setNextQuestion() {
        textView.setText(listOfQuestion.get(currentIndex).getQuestionId());
    }

    private void checkAnswerCorrectness(boolean userAnswer){
        boolean correctAnswer = listOfQuestion.get(currentIndex).isTrueAnswer();
        int resultMessageId = 0;
        if(answerWasShown){
            resultMessageId = R.string.answear_prompt_b;
        }
        else{
            if( userAnswer == correctAnswer) resultMessageId = R.string.correct;
            else resultMessageId = R.string.wrong;
        }
        Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
    }

    /*@Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Log.d("MainActicity", "Wywołana została metoda: onSaveInstanceState");
        outState.putInt(KEY_CURRENT_INDEX, currentIndex);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart called", Toast.LENGTH_LONG).show();
        Log.d("MainActivity","Wykonanie funkcji onStart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume called", Toast.LENGTH_LONG).show();
        Log.d("MainActivity","Wykonanie funkcji onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause called", Toast.LENGTH_LONG).show();
        Log.d("MainActivity","Wykonanie funkcji onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop called",Toast.LENGTH_LONG).show();
        Log.d("MainActivity","Wykonanie funkcji onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy called",Toast.LENGTH_LONG).show();
        Log.d("MainActivity","Wykonanie funkcji onDestroy");
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) return;
        {
            if (requestCode == REQUEST_CODE_PROMPT) {
                if (data == null) { return; }
                answerWasShown = data.getBooleanExtra(PromptActivity.KEY_EXTRA_ANSWER_SHOWN, false);
            }
        }
    }
}
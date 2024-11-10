package com.svecw.mindquest;

import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity8 extends AppCompatActivity implements View.OnClickListener {
    TextView questionTextView111;
    TextView totalQuestionTextView111;
    Button ansA111, ansB111, ansC111, ansD111;
    Button btn_submit111, btn_back; // Add btn_back here

    int score111 = 0;
    int totalQuestion111 = SQLQuestions.question.length; // Changed to SQLQuestions
    int currentQuestionIndex111 = 0;
    String selectedAnswer111 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5); // Make sure this layout includes the back button

        totalQuestionTextView111 = findViewById(R.id.total_question);
        questionTextView111 = findViewById(R.id.question);
        ansA111 = findViewById(R.id.ans_a);
        ansB111 = findViewById(R.id.ans_b);
        ansC111 = findViewById(R.id.ans_c);
        ansD111 = findViewById(R.id.ans_d);
        btn_submit111 = findViewById(R.id.btn_submit);
        btn_back = findViewById(R.id.btn_back); // Initialize btn_back

        ansA111.setOnClickListener(this);
        ansB111.setOnClickListener(this);
        ansC111.setOnClickListener(this);
        ansD111.setOnClickListener(this);
        btn_submit111.setOnClickListener(this);
        btn_back.setOnClickListener(this); // Set click listener for the back button

        totalQuestionTextView111.setText("Total questions: " + totalQuestion111);
        loadNewQuestion();
    }

    private void loadNewQuestion() {
        if (currentQuestionIndex111 == totalQuestion111) {
            finishQuiz();
            return;
        }

        questionTextView111.setText(SQLQuestions.question[currentQuestionIndex111]);
        ansA111.setText(SQLQuestions.choices[currentQuestionIndex111][0]);
        ansB111.setText(SQLQuestions.choices[currentQuestionIndex111][1]);
        ansC111.setText(SQLQuestions.choices[currentQuestionIndex111][2]);
        ansD111.setText(SQLQuestions.choices[currentQuestionIndex111][3]);

        selectedAnswer111 = ""; // Reset selected answer
    }

    private void finishQuiz() {
        String passStatus = (score111 >= totalQuestion111 * 0.6) ? "Passed" : "Failed";
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Your Score is " + score111 + " Out of " + totalQuestion111)
                .setPositiveButton("Restart", (dialog, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }

    private void restartQuiz() {
        score111 = 0;
        currentQuestionIndex111 = 0;
        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        // Reset button colors
        ansA111.setBackgroundColor(Color.WHITE);
        ansB111.setBackgroundColor(Color.WHITE);
        ansC111.setBackgroundColor(Color.WHITE);
        ansD111.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;

        if (clickedButton.getId() == R.id.btn_submit) {
            if (!selectedAnswer111.isEmpty()) {
                // Assuming correct answers are stored as "A", "B", "C", or "D"
                String correctAnswer = getCorrectAnswer(currentQuestionIndex111);
                if (selectedAnswer111.equals(correctAnswer)) {
                    score111++;
                } else {
                    showCorrectAnswer(correctAnswer);
                }
                currentQuestionIndex111++;
                loadNewQuestion();
            } else {
                // Notify the user to select an answer
                new AlertDialog.Builder(this)
                        .setTitle("Select Answer")
                        .setMessage("Please select an answer before submitting!")
                        .setPositiveButton("OK", null)
                        .show();
            }
        } else if (clickedButton.getId() == R.id.btn_back) {
            // Handle back button click
            finish(); // This will close the current activity and go back to the previous one
        } else {
            selectedAnswer111 = clickedButton.getText().toString(); // Set selected answer based on button text
            clickedButton.setBackgroundColor(Color.YELLOW);
        }
    }

    private void showCorrectAnswer(String correctAnswer) {
        switch (correctAnswer) {
            case "char ch = 'g';":
                ansA111.setBackgroundColor(Color.GREEN);
                break;
            case "Compiled and interpreted":
                ansB111.setBackgroundColor(Color.GREEN);
                break;
            case "try-catch":
                ansC111.setBackgroundColor(Color.GREEN);
                break;
            case "extends":
                ansD111.setBackgroundColor(Color.GREEN);
                break;
            // Add cases for all correct answers if needed
        }
    }

    private String getCorrectAnswer(int index) {
        // Modify to return the identifier (A, B, C, D) for comparison
        if (SQLQuestions.correctAnswers[index].equals(SQLQuestions.choices[index][0])) return "A";
        else if (SQLQuestions.correctAnswers[index].equals(SQLQuestions.choices[index][1])) return "B";
        else if (SQLQuestions.correctAnswers[index].equals(SQLQuestions.choices[index][2])) return "C";
        else if (SQLQuestions.correctAnswers[index].equals(SQLQuestions.choices[index][3])) return "D";
        return "";
    }
}

package com.svecw.mindquest;

import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity7 extends AppCompatActivity implements View.OnClickListener {
    TextView questionTextView11;
    TextView totalQuestionTextView11;
    Button ansA11, ansB11, ansC11, ansD11;
    Button btn_submit11, btn_back; // Add btn_back

    int score11 = 0;
    int totalQuestion11 = DBMSQuestions.question.length; // Ensure DBMSQuestions is your DBMS question class
    int currentQuestionIndex11 = 0;
    String selectedAnswer11 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        totalQuestionTextView11 = findViewById(R.id.total_question);
        questionTextView11 = findViewById(R.id.question);
        ansA11 = findViewById(R.id.ans_a);
        ansB11 = findViewById(R.id.ans_b);
        ansC11 = findViewById(R.id.ans_c);
        ansD11 = findViewById(R.id.ans_d);
        btn_submit11 = findViewById(R.id.btn_submit);
        btn_back = findViewById(R.id.btn_back); // Initialize back button

        ansA11.setOnClickListener(this);
        ansB11.setOnClickListener(this);
        ansC11.setOnClickListener(this);
        ansD11.setOnClickListener(this);
        btn_submit11.setOnClickListener(this);
        btn_back.setOnClickListener(this); // Set click listener for back button

        totalQuestionTextView11.setText("Total questions: " + totalQuestion11);
        loadNewQuestion();
    }

    private void loadNewQuestion() {
        if (currentQuestionIndex11 == totalQuestion11) {
            finishQuiz();
            return;
        }

        questionTextView11.setText(DBMSQuestions.question[currentQuestionIndex11]);
        ansA11.setText(DBMSQuestions.choices[currentQuestionIndex11][0]);
        ansB11.setText(DBMSQuestions.choices[currentQuestionIndex11][1]);
        ansC11.setText(DBMSQuestions.choices[currentQuestionIndex11][2]);
        ansD11.setText(DBMSQuestions.choices[currentQuestionIndex11][3]);

        selectedAnswer11 = ""; // Reset selected answer
    }

    private void finishQuiz() {
        String passStatus = (score11 >= totalQuestion11 * 0.6) ? "Passed" : "Failed";
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Your Score is " + score11 + " Out of " + totalQuestion11)
                .setPositiveButton("Restart", (dialog, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }

    private void restartQuiz() {
        score11 = 0;
        currentQuestionIndex11 = 0;
        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        // Reset button colors
        ansA11.setBackgroundColor(Color.WHITE);
        ansB11.setBackgroundColor(Color.WHITE);
        ansC11.setBackgroundColor(Color.WHITE);
        ansD11.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;

        if (clickedButton.getId() == R.id.btn_submit) {
            if (!selectedAnswer11.isEmpty()) {
                String correctAnswer = getCorrectAnswer(currentQuestionIndex11);
                if (selectedAnswer11.equals(correctAnswer)) {
                    score11++;
                } else {
                    showCorrectAnswer(correctAnswer);
                }
                currentQuestionIndex11++;
                loadNewQuestion();
            } else {
                new AlertDialog.Builder(this)
                        .setTitle("Select Answer")
                        .setMessage("Please select an answer before submitting!")
                        .setPositiveButton("OK", null)
                        .show();
            }
        } else if (clickedButton.getId() == R.id.btn_back) {
            // Handle back button action
            onBackPressed(); // Navigate to the previous activity
        } else {
            selectedAnswer11 = clickedButton.getText().toString(); // Set selected answer based on button text
            clickedButton.setBackgroundColor(Color.YELLOW);
        }
    }

    private void showCorrectAnswer(String correctAnswer) {
        switch (correctAnswer) {
            case "Database Management System":
                ansA11.setBackgroundColor(Color.GREEN);
                break;
            case "All of the above":
                ansB11.setBackgroundColor(Color.GREEN);
                break;
            case "A unique identifier for a record":
                ansC11.setBackgroundColor(Color.GREEN);
                break;
            case "Reducing data redundancy":
                ansD11.setBackgroundColor(Color.GREEN);
                break;
            // Add cases for all correct answers if needed
        }
    }

    private String getCorrectAnswer(int index) {
        if (DBMSQuestions.correctAnswers[index].equals(DBMSQuestions.choices[index][0])) return "A";
        else if (DBMSQuestions.correctAnswers[index].equals(DBMSQuestions.choices[index][1])) return "B";
        else if (DBMSQuestions.correctAnswers[index].equals(DBMSQuestions.choices[index][2])) return "C";
        else if (DBMSQuestions.correctAnswers[index].equals(DBMSQuestions.choices[index][3])) return "D";
        return "";
    }
}

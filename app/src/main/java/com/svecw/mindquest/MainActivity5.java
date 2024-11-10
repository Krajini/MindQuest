package com.svecw.mindquest;

import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity implements View.OnClickListener {
    TextView questionTextView;
    TextView totalQuestionTextView;
    Button ansA, ansB, ansC, ansD;
    Button btn_submit, btn_back; // Add btn_back here

    int score = 0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        totalQuestionTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_a);
        ansB = findViewById(R.id.ans_b);
        ansC = findViewById(R.id.ans_c);
        ansD = findViewById(R.id.ans_d);
        btn_submit = findViewById(R.id.btn_submit);
        btn_back = findViewById(R.id.btn_back); // Initialize btn_back

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        btn_submit.setOnClickListener(this);
        btn_back.setOnClickListener(this); // Set click listener for the back button

        totalQuestionTextView.setText("Total questions: " + totalQuestion);
        loadNewQuestion();
    }

    private void loadNewQuestion() {
        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);

        selectedAnswer = ""; // Reset selected answer
    }

    private void finishQuiz() {
        String passStatus = (score >= totalQuestion * 0.6) ? "Passed" : "Failed";
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Your Score is " + score + " Out of " + totalQuestion)
                .setPositiveButton("Restart", (dialog, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }

    private void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        // Reset button colors
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;

        if (clickedButton.getId() == R.id.btn_submit) {
            if (!selectedAnswer.isEmpty()) {
                // Assuming correct answers are stored as "A", "B", "C", or "D"
                String correctAnswer = getCorrectAnswer(currentQuestionIndex);
                if (selectedAnswer.equals(correctAnswer)) {
                    score++;
                } else {
                    showCorrectAnswer(correctAnswer);
                }
                currentQuestionIndex++;
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
            selectedAnswer = clickedButton.getText().toString(); // Set selected answer based on button text
            clickedButton.setBackgroundColor(Color.YELLOW);
        }
    }

    private void showCorrectAnswer(String correctAnswer) {
        switch (correctAnswer) {
            case "char ch = 'g';":
                ansA.setBackgroundColor(Color.GREEN);
                break;
            case "Compiled and interpreted":
                ansB.setBackgroundColor(Color.GREEN);
                break;
            case "try-catch":
                ansC.setBackgroundColor(Color.GREEN);
                break;
            case "extends":
                ansD.setBackgroundColor(Color.GREEN);
                break;
            // Add cases for all correct answers if needed
        }
    }

    private String getCorrectAnswer(int index) {
        // Modify to return the identifier (A, B, C, D) for comparison
        if (QuestionAnswer.correctAnswers[index].equals(QuestionAnswer.choices[index][0])) return "A";
        else if (QuestionAnswer.correctAnswers[index].equals(QuestionAnswer.choices[index][1])) return "B";
        else if (QuestionAnswer.correctAnswers[index].equals(QuestionAnswer.choices[index][2])) return "C";
        else if (QuestionAnswer.correctAnswers[index].equals(QuestionAnswer.choices[index][3])) return "D";
        return "";
    }
}

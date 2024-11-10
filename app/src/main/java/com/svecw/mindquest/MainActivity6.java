package com.svecw.mindquest;

import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity6 extends AppCompatActivity implements View.OnClickListener {
    TextView questionTextView1;
    TextView totalQuestionTextView1;
    Button ansA1, ansB1, ansC1, ansD1;
    Button btn_submit1, btn_back1; // Update button IDs here

    int score1 = 0;
    int totalQuestion1 = PythonQuestion.question.length;
    int currentQuestionIndex1 = 0;
    String selectedAnswer1 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6); // Make sure this matches your layout file

        // Initialize views using the correct IDs from the XML layout
        totalQuestionTextView1 = findViewById(R.id.total_question1);
        questionTextView1 = findViewById(R.id.question1);
        ansA1 = findViewById(R.id.ans_a1);
        ansB1 = findViewById(R.id.ans_b1);
        ansC1 = findViewById(R.id.ans_c1);
        ansD1 = findViewById(R.id.ans_d1);
        btn_submit1 = findViewById(R.id.btn_submit1);
        btn_back1 = findViewById(R.id.btn_back1); // Initialize back button

        // Set click listeners for buttons
        ansA1.setOnClickListener(this);
        ansB1.setOnClickListener(this);
        ansC1.setOnClickListener(this);
        ansD1.setOnClickListener(this);
        btn_submit1.setOnClickListener(this);
        btn_back1.setOnClickListener(this); // Set click listener for back button

        totalQuestionTextView1.setText("Total questions: " + totalQuestion1);
        loadNewQuestion();
    }

    private void loadNewQuestion() {
        if (currentQuestionIndex1 == totalQuestion1) {
            finishQuiz();
            return;
        }

        questionTextView1.setText(PythonQuestion.question[currentQuestionIndex1]);
        ansA1.setText(PythonQuestion.choices[currentQuestionIndex1][0]);
        ansB1.setText(PythonQuestion.choices[currentQuestionIndex1][1]);
        ansC1.setText(PythonQuestion.choices[currentQuestionIndex1][2]);
        ansD1.setText(PythonQuestion.choices[currentQuestionIndex1][3]);

        selectedAnswer1 = ""; // Reset selected answer
    }

    private void finishQuiz() {
        String passStatus = (score1 >= totalQuestion1 * 0.6) ? "Passed" : "Failed";
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Your Score is " + score1 + " Out of " + totalQuestion1)
                .setPositiveButton("Restart", (dialog, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }

    private void restartQuiz() {
        score1 = 0;
        currentQuestionIndex1 = 0;
        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        // Reset button colors
        ansA1.setBackgroundColor(Color.WHITE);
        ansB1.setBackgroundColor(Color.WHITE);
        ansC1.setBackgroundColor(Color.WHITE);
        ansD1.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;

        if (clickedButton.getId() == R.id.btn_submit1) {
            if (!selectedAnswer1.isEmpty()) {
                // Assuming correct answers are stored as "A", "B", "C", or "D"
                String correctAnswer = getCorrectAnswer(currentQuestionIndex1);
                if (selectedAnswer1.equals(correctAnswer)) {
                    score1++;
                } else {
                    showCorrectAnswer(correctAnswer);
                }
                currentQuestionIndex1++;
                loadNewQuestion();
            } else {
                // Notify the user to select an answer
                new AlertDialog.Builder(this)
                        .setTitle("Select Answer")
                        .setMessage("Please select an answer before submitting!")
                        .setPositiveButton("OK", null)
                        .show();
            }
        } else if (clickedButton.getId() == R.id.btn_back1) {
            // Handle back button click
            finish(); // This will close the current activity and go back to the previous one
        } else {
            selectedAnswer1 = clickedButton.getText().toString(); // Set selected answer based on button text
            clickedButton.setBackgroundColor(Color.YELLOW);
        }
    }

    private void showCorrectAnswer(String correctAnswer) {
        switch (correctAnswer) {
            case "char ch = 'g';":
                ansA1.setBackgroundColor(Color.GREEN);
                break;
            case "Compiled and interpreted":
                ansB1.setBackgroundColor(Color.GREEN);
                break;
            case "try-catch":
                ansC1.setBackgroundColor(Color.GREEN);
                break;
            case "extends":
                ansD1.setBackgroundColor(Color.GREEN);
                break;
            // Add cases for all correct answers if needed
        }
    }

    private String getCorrectAnswer(int index) {
        // Modify to return the identifier (A, B, C, D) for comparison
        if (PythonQuestion.correctAnswers[index].equals(PythonQuestion.choices[index][0])) return "A";
        else if (PythonQuestion.correctAnswers[index].equals(PythonQuestion.choices[index][1])) return "B";
        else if (PythonQuestion.correctAnswers[index].equals(PythonQuestion.choices[index][2])) return "C";
        else if (PythonQuestion.correctAnswers[index].equals(PythonQuestion.choices[index][3])) return "D";
        return "";
    }
}

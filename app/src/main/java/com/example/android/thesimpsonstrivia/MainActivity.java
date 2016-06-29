package com.example.android.thesimpsonstrivia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quizScore = 0;
    /**
     * Buttons
     */
    Button submitButton,resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit_answers:
                submitButton.setEnabled(false);
                resetButton.setEnabled(true); // add this
                break;

            case R.id.reset_quiz:
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                break;

            default:
                break;
        }
    }

    /**
     * This method is called when the check score button is clicked.
     */
    public void submitAnswer(View view) {

        /**
         * This checks the user's question 1 answer and adds a points if correct
         */

        RadioButton question_1_answer = (RadioButton) findViewById(R.id.question_1_answer);
        boolean correctOne = question_1_answer.isChecked();

        if (correctOne) {
            quizScore = quizScore + 1;
        }

        /**
         * This adds the results of question 2
         */

        checkQuestionTwo();

        /**
         * This checks the user's question 3 answer and adds a points if correct
         */

        RadioButton question_3_answer = (RadioButton) findViewById(R.id.question_3_answer);
        boolean correctThree = question_3_answer.isChecked();

        if (correctThree) {
            quizScore = quizScore + 1;
        }

        /**
         * This checks the user's question 4 answer and adds a points if correct
         */

        EditText question_4_answer = (EditText) findViewById(R.id.question_4_answer);
        String correctFour = question_4_answer.getText().toString();

        if (correctFour.equalsIgnoreCase("annoyed grunt")) {
            quizScore = quizScore + 1;
        }

        /**
         * This checks the user's question 5 answer and adds a points if correct
         */

        RadioButton question_5_answer = (RadioButton) findViewById(R.id.question_5_answer);
        boolean correctFive = question_5_answer.isChecked();

        if (correctFive) {
            quizScore = quizScore + 1;
        }

        /**
         * This displays the users score.
         */

        String scoreMessage = "You got " + quizScore + " of 5 correct!\n";
        if (quizScore == 5) {
            Toast.makeText(getApplicationContext(), scoreMessage + getText(R.string.score_message_5), Toast.LENGTH_LONG).show();
        } else if (quizScore == 4) {
            Toast.makeText(getApplicationContext(), scoreMessage + getText(R.string.score_message_4), Toast.LENGTH_LONG).show();
        } else if (quizScore == 3) {
            Toast.makeText(getApplicationContext(), scoreMessage + getText(R.string.score_message_3), Toast.LENGTH_LONG).show();
        } else if (quizScore == 2) {
            Toast.makeText(getApplicationContext(), scoreMessage + getText(R.string.score_message_2), Toast.LENGTH_LONG).show();
        } else if (quizScore == 1) {
            Toast.makeText(getApplicationContext(), scoreMessage + getText(R.string.score_message_1), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), scoreMessage + getText(R.string.score_message_0), Toast.LENGTH_LONG).show();
        }

        quizScore = 0;
    }

    /**
     * This checks the user's question 2 answer and adds a points if correct
     */

    public void checkQuestionTwo() {

        CheckBox question_2_wrong_1 = (CheckBox) findViewById(R.id.question_2_wrong_1);
        boolean wrongTwoOne = question_2_wrong_1.isChecked();

        CheckBox question_2_wrong_2 = (CheckBox) findViewById(R.id.question_2_wrong_2);
        boolean wrongTwoTwo = question_2_wrong_2.isChecked();

        CheckBox question_2_answer_1 = (CheckBox) findViewById(R.id.question_2_answer_1);
        boolean correctTwoOne = question_2_answer_1.isChecked();

        CheckBox question_2_answer_2 = (CheckBox) findViewById(R.id.question_2_answer_2);
        boolean correctTwoTwo = question_2_answer_2.isChecked();

        if (wrongTwoOne) {
            return;
        } else if (wrongTwoTwo) {
            return;
        }

        if (correctTwoOne && correctTwoTwo) {
            quizScore = quizScore + 1;
        }
    }

}





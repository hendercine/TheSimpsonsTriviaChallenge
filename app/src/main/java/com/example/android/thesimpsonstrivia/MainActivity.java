package com.example.android.thesimpsonstrivia;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    int quizScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the check score button is clicked.
     */
    public void submitOrder(View view) {

        /**
         * This checks the users question 1 answer and adds a points if correct
         */

        RadioButton question_1_answer = (RadioButton) findViewById(R.id.question_1_answer);
        boolean correctOne = question_1_answer.isChecked();

        if (correctOne) {
            quizScore = quizScore + 1;
        }

        /**
         * This checks the users question 2 answer and adds a points if correct
         */

        CheckBox question_2_answer_1 = (CheckBox) findViewById(R.id.question_2_answer_1);
        boolean correctTwoOne = question_2_answer_1.isChecked();

        CheckBox question_2_answer_2 = (CheckBox) findViewById(R.id.question_2_answer_2);
        boolean correctTwoTwo = question_2_answer_2.isChecked();

        if (correctTwoOne) while (correctTwoTwo) {
            quizScore = quizScore + 1;
        }

        /**
         * This checks the users question 3 answer
         */

        RadioButton quest3on_1_answer = (RadioButton) findViewById(R.id.quest3on_1_answer);
        boolean corThreetOne = quest3on_1_answer.isChecke

        if (correctThree) {
            quizScore = quizScore + 1;d();

        /**
         * This checks the users question 4 answer
         */

        RadioButton question_1_answer = (RadioButton) findViewById(R.id.question_1_answer);
        boolean correctOne = question_1_answer.isChecke

        d();

        /**
         * This checks the users question 5 answer
         */

        RadioButton question_1_answer = (RadioButton) findViewById(R.id.question_1_answer);
        boolean correctOne = question_1_answer.isChecked.getText();


        int price = calculatePrice(hasWhip, hasChocolate);
        String priceMessage = createOrderSummary(orderName, price, hasWhip, hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject) + orderName);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

}

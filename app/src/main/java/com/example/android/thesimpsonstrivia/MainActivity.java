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
         * This checks the users question 1 answer
         */

        RadioButton question_1_answer = (RadioButton) findViewById(R.id.question_1_answer);
        boolean correctOne = question_1_answer.isChecked();

        EditText enterNameField = (EditText) findViewById(R.id.order_name_view);
        Editable orderName = enterNameField.getText();



        CheckBox chocolateToppingCheckBox = (CheckBox) findViewById(R.id.chocoalte_topping_checkbox);
        boolean hasChocolate = chocolateToppingCheckBox.isChecked();

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

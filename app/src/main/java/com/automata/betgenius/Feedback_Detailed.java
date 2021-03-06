package com.automata.betgenius;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;


public class Feedback_Detailed extends AppCompatActivity {

    TextView txtQuiz, txtAnswer;
    String quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        setContentView(R.layout.activity_feedback__detailed);
        txtQuiz = (TextView) findViewById(R.id.txtQuiz);
        txtAnswer = (TextView) findViewById(R.id.txtAnswer);
        quiz = getIntent().getExtras().getString("quiz");
        txtQuiz.setText(quiz);
        txtAnswer.setTextIsSelectable(true);

        switch (quiz) {
            case "How to join VIP?":
                txtAnswer.setText(
                        "VIP CHANNEL WINS AT LEAST 5 DAYS IN A WEEK" + "\n" +
                                "IT HAS SINGLE ODDS 2+, MULTIBETS OF ODDS 20+, JACKPOTS AND MEGA-JACKPOTS" + "\n" +
                                "*AFTER PAYMENT, YOU GET THE LINK TO VIP CHANNEL INSTANTLY" + "\n" + "\n" +
                                "AMOUNT" + "\n" +
                                "-----------------------------------" + "\n" +
                                " 10 US DOLLARS" + "\n" + "\n" +
                                "DURATION: 4 MONTHS" + "\n" + "\n" +
                                "PAYMENT METHODS" + "\n" +
                                "------------------------------------" + "\n" +

                                "MPESA: 0719275724" + "\n" +
                                "PAYPAL: phelixolonde@gmail.com" + "\n" +
                                "SKRILL: phelixolonde@gmail.com" + "\n" +
                                "BITCOINS: 18yNpK6V8A4A6ZtWHkA95zFV3Bc343b18j");

                break;
            case "App not working":
                txtAnswer.setText("Kindly update your app to the latest version.");
                break;
            case "Tips not loading":
                txtAnswer.setText("Swipe down to refresh. Whenever you see a notification, always check the app." +
                        "If tips are not showing, then swipe down to refresh");
                break;
            case "Tips not arriving in time":
                txtAnswer.setText("Tips are usually posted in the morning," +
                        "If you are getting the tips late then always look out for the notifications." +
                        "If there was a notification but you can't see the tips, then swipe down to refresh.");

                break;

            case "I have another issue":
                startActivity(new Intent(Feedback_Detailed.this, Email_Admin.class));
                break;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

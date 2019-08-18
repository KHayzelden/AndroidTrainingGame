package com.example.krishayzelden.traininggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class game extends AppCompatActivity {

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonDelete, buttonHash;
    int number, symbol, answer, userInput;
    String difficulty, equationString, answerString;
    int numberOfValues, roundCount;

    final int numberOfRounds = 10;

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        difficulty = "guru"; //remove later

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button0);

        buttonDelete = (Button) findViewById(R.id.buttonDelete);
        buttonHash = (Button) findViewById(R.id.buttonHash);

        switch(difficulty) //will set the number of "steps" in the equation
        {
            case "novice":
                numberOfValues = 2;
                break;

            case "easy":
                numberOfValues = random.nextInt(2) + 2; //adds 2 as it's the minimum then will do either +0 or +1
                break;

            case "medium":
                numberOfValues = random.nextInt(3) + 2;
                break;

            case "guru":
                numberOfValues = random.nextInt(3) + 4; //+4 as the minimum is 4
                break;
        }

        roundCount = 0;
        final TextView answerDisplay = (TextView) findViewById(R.id.answerText);

        while (roundCount <= numberOfRounds)
        {

            symbol = random.nextInt(4); // 0 = + , 1 = - , 2 = * , 3 = / ----- is run once for the first instance
            equationString = ""; //clears it for the new equation
            answerString = "?"; //resets it to a ? for the new input
            answerDisplay.setText(answerString);

            for (int i = 0; i < numberOfValues; i++)
            {
                number = random.nextInt(9) + 1; //avoids 0 for devide by 0 errors

                if (i == 0)
                {
                    answer = number; //answer can not be calculated on first run as its only one "step"
                }
                else
                {
                    if (symbol == 0) answer += number;
                    if (symbol == 1) answer -= number;
                    if (symbol == 2) answer *= number;
                    if (symbol == 3) answer /= number;

                    symbol = random.nextInt(4);
                }

                equationString += Integer.toString(number);

                if ((i + 1) < numberOfValues) //therefore is on its last loop
                {
                    if (symbol == 0) equationString += " + ";
                    if (symbol == 1) equationString += " - ";
                    if (symbol == 2) equationString += " * ";
                    if (symbol == 3) equationString += " / ";
                }
                else
                {
                    equationString += " = ";
                }
            }

            TextView equation = (TextView) findViewById(R.id.equationText);
            equation.setText(equationString);

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (answerString.contentEquals("?")) answerString = ""; //clears the ? if there
                    answerString += "1";
                    answerDisplay.setText(answerString);
                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (answerString.contentEquals("?")) answerString = ""; //clears the ? if there
                    answerString += "2";
                    answerDisplay.setText(answerString);
                }
            });

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (answerString.contentEquals("?")) answerString = ""; //clears the ? if there
                    answerString += "3";
                    answerDisplay.setText(answerString);
                }
            });

            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (answerString.contentEquals("?")) answerString = ""; //clears the ? if there
                    answerString += "4";
                    answerDisplay.setText(answerString);
                }
            });

            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (answerString.contentEquals("?")) answerString = ""; //clears the ? if there
                    answerString += "5";
                    answerDisplay.setText(answerString);
                }
            });

            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (answerString.contentEquals("?")) answerString = ""; //clears the ? if there
                    answerString += "6";
                    answerDisplay.setText(answerString);
                }
            });

            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (answerString.contentEquals("?")) answerString = ""; //clears the ? if there
                    answerString += "7";
                    answerDisplay.setText(answerString);
                }
            });

            button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (answerString.contentEquals("?")) answerString = ""; //clears the ? if there
                    answerString += "8";
                    answerDisplay.setText(answerString);
                }
            });

            button9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (answerString.contentEquals("?")) answerString = ""; //clears the ? if there
                    answerString += "9";
                    answerDisplay.setText(answerString);
                }
            });

            button0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (answerString.contentEquals("?")) answerString = ""; //clears the ? if there
                    answerString += "0";
                    answerDisplay.setText(answerString);
                }
            });

            buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (answerString != null && answerString.length() > 0)
                    {
                        if(answerString.length() == 1)
                        {
                            answerString = "" ;
                            answerDisplay.setText(answerString);
                        }
                        else
                        {
                            answerString = answerString.substring(0, answerString.length() - 1); //will remove the last number of the string
                            answerDisplay.setText(answerString);
                        }
                    }
                }
            });

            buttonHash.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int userAnswer = Integer.parseInt(answerString);

                    if (userAnswer == answer)
                    {
                        TextView result = (TextView) findViewById(R.id.resultText);
                        result.setText("Correct!");
                    }
                    else
                    {
                        TextView result = (TextView) findViewById(R.id.resultText);
                        result.setText("Incorrect!");
                    }
                }
            });

            roundCount++;
        } //end while
    }
}
package com.example.kenrickalfred.calculatorapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kenrickalfred.calculatorapp.R;

import static android.R.attr.id;


public class MainActivity extends AppCompatActivity {

    //Add = 1. Subtract = 2, multiply = 3, divide = 4
    int operation = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View add = findViewById(R.id.plus);
        final View subtract = findViewById(R.id.minus);
        final View divide = findViewById(R.id.divide);
        final View multiply = findViewById(R.id.multiply);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //If operation ==1 Add is already selected. Lets undo it
                if (operation == 1) {
                    operation = -1;
                    subtract.setBackgroundColor(0);
                } else {
                    //If operation is anything other than 1 ( it could be -1, 2, 3,4) lets make add as the current op.
                    operation = 1;
                    add.setBackgroundColor(Color.YELLOW);

                    //Unselect other buttons after selection add above
                    multiply.setBackgroundColor(0);
                    subtract.setBackgroundColor(0);
                    divide.setBackgroundColor(0);
                }


            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operation == 2) {
                    operation = -1;
                    subtract.setBackgroundColor(0);
                } else {
                    operation = 2;
                    add.setBackgroundColor(0);
                    multiply.setBackgroundColor(0);
                    subtract.setBackgroundColor(Color.YELLOW);
                    divide.setBackgroundColor(0);
                }


            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operation == 3) {
                    operation = -1;
                    multiply.setBackgroundColor(0);
                } else {
                    operation = 3;
                    add.setBackgroundColor(0);
                    multiply.setBackgroundColor(Color.YELLOW);
                    subtract.setBackgroundColor(0);
                    divide.setBackgroundColor(0);
                }


            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operation == 4) {
                    operation = -1;
                    divide.setBackgroundColor(0);
                } else {
                    operation = 4;
                    add.setBackgroundColor(0);
                    multiply.setBackgroundColor(0);
                    subtract.setBackgroundColor(0);
                    divide.setBackgroundColor(Color.YELLOW);
                }


            }
        });


        TextView value = (TextView) findViewById(R.id.value);
        final EditText left = (EditText) findViewById(R.id.left);
        final EditText right = (EditText) findViewById(R.id.right);
        float result = 0;


        final View calculate = findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (left.getText().length() == 0) {
                    Toast.makeText(getBaseContext(), "Enter a value on the left", Toast.LENGTH_LONG).show();
                    return;
                }
                if (right.getText().length() == 0) {
                    Toast.makeText(getBaseContext(), "Enter a value on the right", Toast.LENGTH_LONG).show();
                    return;
                }
                if (operation == -1) {
                    Toast.makeText(getBaseContext(), "No operation selected", Toast.LENGTH_LONG).show();
                    return;
                }
                calculate();

            }
        });


    }


    public void calculate() {
        TextView value = (TextView) findViewById(R.id.value);
        final EditText left = (EditText) findViewById(R.id.left);
        final EditText right = (EditText) findViewById(R.id.right);
        float leftValue = Float.parseFloat(left.getText().toString());
        float rightValue = Float.parseFloat(right.getText().toString());
        float result = 0;
        if (operation == 1) {
            result = add(leftValue, rightValue);
        }
        if (operation == 2) {
            result = subtract(leftValue, rightValue);
        }
        if (operation == 3) {
            result = multiply(leftValue, rightValue);
        }
        if (operation == 4) {
            result = divide(leftValue, rightValue);
        }


        value.setText(String.valueOf(result));


    }

    public float add(float a, float b) {
        return a + b;
    }

    public float divide(float a, float b) {
        return a / b;
    }

    public float subtract(float a, float b) {
        return a - b;
    }

    public float multiply(float a, float b) {
        return a * b;
    }
}
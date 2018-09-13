package com.charlieliu.itsch.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        //initializing calculator class
        final Calculator calc = new Calculator();


        //creating references to all the buttons
        Button numBtn0 = findViewById(R.id.nb0);
        Button numBtn1 = findViewById(R.id.nb1);
        Button numBtn2 = findViewById(R.id.nb2);
        Button numBtn3 = findViewById(R.id.nb3);
        Button numBtn4 = findViewById(R.id.nb4);
        Button numBtn5 = findViewById(R.id.nb5);
        Button numBtn6 = findViewById(R.id.nb6);
        Button numBtn7 = findViewById(R.id.nb7);
        Button numBtn8 = findViewById(R.id.nb8);
        Button numBtn9 = findViewById(R.id.nb9);

        Button histBtn = findViewById(R.id.hb);
        Button decBtn = findViewById(R.id.deb);
        Button eqBtn = findViewById(R.id.eb);
        Button backBtn = findViewById(R.id.bb);
        Button addBtn = findViewById(R.id.ab);
        Button subBtn = findViewById(R.id.sb);
        Button multBtn = findViewById(R.id.mb);
        Button divBtn = findViewById(R.id.db);

        final TextView tv = findViewById(R.id.textView);

        numBtn0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Calculator.appendNumber(tv, "0");
                Log.d(TAG, "onClick: 0");
            }
        });

        numBtn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calculator.appendNumber(tv, "1");
                Log.d(TAG, "onClick: 1");
            }
        });

        numBtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calculator.appendNumber(tv, "2");

                Log.d(TAG, "onClick: 2");
            }
        });

        numBtn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Calculator.appendNumber(tv, "3");

                Log.d(TAG, "onClick: 3");
            }
        });

        numBtn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calculator.appendNumber(tv, "4");

                Log.d(TAG, "onClick: 4");
            }
        });

        numBtn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calculator.appendNumber(tv, "5");
                Log.d(TAG, "onClick: 5");
            }
        });

        numBtn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calculator.appendNumber(tv, "6");
                Log.d(TAG, "onClick: 6");
            }
        });

        numBtn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calculator.appendNumber(tv, "7");
                Log.d(TAG, "onClick: 7");
            }
        });

        numBtn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calculator.appendNumber(tv, "8");
                Log.d(TAG, "onClick: 8");
            }
        });

        numBtn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calculator.appendNumber(tv, "9");
                Log.d(TAG, "onClick: 9");
            }
        });



        //operators
        histBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!calc.history.empty()) {
                    tv.setText(calc.history.pop());
                }
                else
                {
                    tv.setText((null));
                }

                Log.d(TAG, "onClick");
            }
        });

        decBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calculator.appendNumber(tv, ".");
                Log.d(TAG, "onClick: .");
            }
        });

        eqBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    tv.setText(calc.calculate(Double.parseDouble(tv.getText().toString())));
                }
                catch (NumberFormatException e)
                {
                    tv.setText("Err");
                }
                calc.history.push(tv.getText().toString());
                calc.op = '\0';
                Log.d(TAG, "onClick");
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calculator.deleteNumber(tv);
                Log.d(TAG, "onClick");
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    calc.firstNum = Double.parseDouble(tv.getText().toString());
                    calc.op = '+';
                    tv.setText(null);
                }
                catch (NumberFormatException e)
                {
                    tv.setText("Err");
                }


                Log.d(TAG, "onClick");
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    calc.firstNum = Double.parseDouble(tv.getText().toString());
                    calc.op = '-';
                    tv.setText(null);
                }
                catch (NumberFormatException e)
                {
                    tv.setText("Err");
                }
                Log.d(TAG, "onClick");
            }
        });

        multBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    calc.firstNum = Double.parseDouble(tv.getText().toString());
                    calc.op = '*';
                    tv.setText(null);
                }
                catch (NumberFormatException e)
                {
                    tv.setText("Err");
                }
                Log.d(TAG, "onClick");
            }
        });

        divBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    calc.firstNum = Double.parseDouble(tv.getText().toString());
                    calc.op = '/';
                    tv.setText(null);
                }
                catch (NumberFormatException e)
                {
                    tv.setText("Err");
                }
                Log.d(TAG, "onClick");
            }
        });


    }
}

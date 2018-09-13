package com.charlieliu.itsch.calculator;

import android.widget.TextView;

import java.util.Stack;

public class Calculator
{
    double firstNum;
    char op;
    Stack<String> history;

    Calculator()
    {
        history = new Stack<>();
    }

    static void appendNumber(TextView tv, String s)
    {
        if (tv.getText().toString().length() < 9 && !tv.getText().toString().equals("Err")&& !tv.getText().toString().equals("Infinity")) {
            tv.append(s);
        }
    }

    static void deleteNumber(TextView tv)
    {
        String s = tv.getText().toString();
        if (s.equals("Err") || s.equals("Infinity"))
        {
            tv.setText(null);
        }
        else if (s.length() > 0)
        {
            tv.setText(s.substring(0, s.length() - 1));
        }
    }

    public String calculate(double secondNum)
    {

        switch (op)
        {
            case '+':
                return Double.toString(firstNum + secondNum);
            case '-':
                return Double.toString(firstNum - secondNum);

            case '*':
                return Double.toString(firstNum * secondNum);

            case '/':
                return Double.toString(firstNum / secondNum);
            default:
                return Double.toString(secondNum);




        }
    }



}

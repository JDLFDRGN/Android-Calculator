package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {
    String problem = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbHelper dbHelper = new DbHelper(this);

        findViewById(R.id.calculator_history).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CalcHistory.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problem += "1";
                ((TextView)findViewById(R.id.problem)).setText(problem);
            }
        });

        findViewById(R.id.two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problem += "2";
                ((TextView)findViewById(R.id.problem)).setText(problem);
            }
        });

        findViewById(R.id.three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problem += "3";
                ((TextView)findViewById(R.id.problem)).setText(problem);
            }
        });

        findViewById(R.id.four).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problem += "4";
                ((TextView)findViewById(R.id.problem)).setText(problem);
            }
        });

        findViewById(R.id.five).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problem += "5";
                ((TextView)findViewById(R.id.problem)).setText(problem);
            }
        });

        findViewById(R.id.six).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problem += "6";
                ((TextView)findViewById(R.id.problem)).setText(problem);
            }
        });

        findViewById(R.id.seven).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problem += "7";
                ((TextView)findViewById(R.id.problem)).setText(problem);
            }
        });

        findViewById(R.id.eight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problem += "8";
                ((TextView)findViewById(R.id.problem)).setText(problem);
            }
        });

        findViewById(R.id.nine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problem += "9";
                ((TextView)findViewById(R.id.problem)).setText(problem);
            }
        });

        findViewById(R.id.zero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problem += "0";
                ((TextView)findViewById(R.id.problem)).setText(problem);
            }
        });

        findViewById(R.id.del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(problem.isEmpty()) return;
                problem = problem.substring(0, problem.length()-1);
                ((TextView)findViewById(R.id.problem)).setText(problem);
            }
        });

        findViewById(R.id.point).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problem += ".";
                ((TextView)findViewById(R.id.problem)).setText(problem);
            }
        });

        findViewById(R.id.ac).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problem = "";
                ((TextView)findViewById(R.id.problem)).setText(problem);
            }
        });

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problem += "+";
                ((TextView)findViewById(R.id.problem)).setText(problem);
            }
        });

        findViewById(R.id.subtract).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problem += "-";
                ((TextView)findViewById(R.id.problem)).setText(problem);
            }
        });

        findViewById(R.id.multiply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problem += "*";
                ((TextView)findViewById(R.id.problem)).setText(problem);
            }
        });

        findViewById(R.id.divide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problem += "/";
                ((TextView)findViewById(R.id.problem)).setText(problem);
            }
        });

        findViewById(R.id.equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double results = null;
                ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

                try{
                    results = (double)engine.eval(problem);
                }catch(ScriptException e){
                    Toast.makeText(MainActivity.this, "Invalid Expression!", Toast.LENGTH_SHORT).show();
                }
                if(results != null){
                    dbHelper.insertHistory(problem + " = " + results);
                    problem = results.toString();
                    ((TextView)findViewById(R.id.problem)).setText(problem);
                }
            }
        });
    }
}
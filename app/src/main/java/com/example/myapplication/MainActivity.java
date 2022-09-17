package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button check;
    Button reset;
    EditText input;
    TextView view1;
    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check = findViewById(R.id.Check);
        reset = findViewById(R.id.Reset);
        input = findViewById(R.id.Input);
        view1 = findViewById(R.id.textView);

        reset.setEnabled(false);

        check.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    gown();
                }
            });

            reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   i =0;
                   check.setEnabled(true);
                    reset.setEnabled(false);

                }
            });
        }

    public void gown(){
        String With = input.getText().toString();

        if (i < 2) {
            if (With.length() < 4) {
                Toast.makeText(MainActivity.this, "Please input four letters", Toast.LENGTH_SHORT).show();
            } else {

                view1.setText(checkCorrectness(RandomWord()));

            }
        } else {
            check.setEnabled(false);
            Toast.makeText(MainActivity.this, "The random word is "+RandomWord(), Toast.LENGTH_SHORT).show();
            reset.setEnabled(true);

        }
        i = i + 1;
    }

    public String RandomWord(){
        String list[] = {"hour", "lone", "four", "nice", "mine", "fine", "line", "cute", "time"};
        int size = list.length;
        int random = (int)Math.random() * size;
        String randomWord = list[random];
        return randomWord;
    }

    public String checkCorrectness(String randomChosen){
        String compareWith = input.getText().toString();
        String compareTo = randomChosen;
        String result = "";

        for(int i=0; i<4; i++){
            if(compareWith.charAt(i) == compareTo.charAt(i)){
                result += "O";
            }
            else if(compareWith.charAt(i) == compareTo.charAt(0) || compareWith.charAt(i) == compareTo.charAt(1) || compareWith.charAt(i) == compareTo.charAt(2) || compareWith.charAt(i) == compareTo.charAt(2) ){
                            result += '+';
            }
            else{
            result += "X";
            }
        }
        return result;

    }


}
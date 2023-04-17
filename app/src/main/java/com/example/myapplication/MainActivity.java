package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int random;
    private EditText editNumber;
    private TextView textOtvet;
    private Button startButton, guessButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNumber = findViewById(R.id.editNumber);
        textOtvet  = findViewById(R.id.textOtvet);
        startButton = findViewById(R.id.startButton);
        guessButton = findViewById(R.id.button);

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guessOnClick();
            }
        });
    }
    public void startOnClick(View view){
        random = 1 + (int) (Math.random() * 100);
        startButton.setEnabled(false);
    }

    public void guessOnClick(){
        int userNumber = Integer.parseInt(String.valueOf(editNumber.getText()));
        if (random > userNumber) {
            textOtvet.setText(userNumber + " слишком мало. Попробуйте еще раз!");
        }
        if (random < userNumber) {
            textOtvet.setText(userNumber + " слишком много. Попробуйте еще раз!");
        }
        if (random == userNumber) {
            textOtvet.setText(userNumber + " соответствует загаданному числу! Сыграйте ещё!" );
            startButton.setEnabled(true);
        }
        editNumber.setText("");
    }
}
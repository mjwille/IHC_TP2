package com.example.atividade1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etext1, etext2;
    private Button but1;
    private TextView tview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etext1 = findViewById(R.id.firstNumber);
        etext2 = findViewById(R.id.secondNumber);
        but1   = findViewById(R.id.my_add_button);
        tview1 = findViewById(R.id.result);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1 = Integer.parseInt(etext1.getText().toString());
                int n2 = Integer.parseInt(etext2.getText().toString());
                tview1.setText("Result: " + String.valueOf(n1 + n2));
            }
        });
    }
}
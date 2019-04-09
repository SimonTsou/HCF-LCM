package com.example.demo_faspro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText inputNum1;
    private EditText inputNum2;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button = findViewById(R.id.commit);
        this.inputNum1 = findViewById(R.id.inputNum1);
        this.inputNum2 = findViewById(R.id.inputNum2);
        this.intent = new Intent(MainActivity.this, ShowResultActivity.class);
        this.bundle = new Bundle();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.this.inputNum1.getText().toString().isEmpty() ||
                    MainActivity.this.inputNum2.getText().toString().isEmpty()) {
                    return;
                }
                if(MainActivity.this.inputNum1.getText().toString().equals("0") ||
                    MainActivity.this.inputNum2.getText().toString().equals("0")) {
                    Toast.makeText(MainActivity.this, "輸入不能為0", Toast.LENGTH_SHORT).show();
                    return;
                }
                MainActivity.this.bundle.putInt
                        ("input1", Integer.parseInt(MainActivity.this.inputNum1.getText().toString()));
                MainActivity.this.bundle.putInt
                        ("input2", Integer.parseInt(MainActivity.this.inputNum2.getText().toString()));
                MainActivity.this.intent.putExtra("bundle", MainActivity.this.bundle);
                MainActivity.this.startActivity(MainActivity.this.intent);
            }
        });
    }
}

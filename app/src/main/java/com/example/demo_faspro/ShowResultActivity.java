package com.example.demo_faspro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowResultActivity extends AppCompatActivity {
    private TextView hcf;
    private TextView lcm;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        this.button = findViewById(R.id.backButton);
        this.hcf = findViewById(R.id.hcf);
        this.lcm = findViewById(R.id.lcm);
    }

    @Override
    protected void onResume() {
        super.onResume();
        int input1 = getIntent().getBundleExtra("bundle").getInt("input1");
        int input2 = getIntent().getBundleExtra("bundle").getInt("input2");
        int calculatedHCF = getHCF(input1, input2);
        this.hcf.append(String.valueOf(calculatedHCF));
        this.lcm.append(String.valueOf(input1 * input2 / calculatedHCF));
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowResultActivity.this.onBackPressed();
            }
        });
    }

    private int getHCF(int a, int b) {
        int r = a % b;
        if(r == 0) {
            return b;
        } else {
            return getHCF(b, r);
        }
    }
}

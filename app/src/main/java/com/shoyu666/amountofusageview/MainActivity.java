package com.shoyu666.amountofusageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AmountOfContractUsageView view = (AmountOfContractUsageView)findViewById(R.id.view);
        view.setPercent(0.6f);
    }
}

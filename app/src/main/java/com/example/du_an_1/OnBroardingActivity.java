package com.example.du_an_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.du_an_1.Adapter.SliderAdapter;


public class OnBroardingActivity extends AppCompatActivity {
    Button btnGetStarted;
    public static ViewPager viewPager;
    SliderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_broarding);

        btnGetStarted = findViewById(R.id.btnGetStarted);
        viewPager = findViewById(R.id.viewpager);
        adapter = new SliderAdapter(this);
        viewPager.setAdapter(adapter);

        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OnBroardingActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });


        if (isOpenAlread()) {
            Intent intent = new Intent(OnBroardingActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            SharedPreferences.Editor editor = getSharedPreferences("slide", MODE_PRIVATE).edit();
            editor.putBoolean("slide", true);
            editor.commit();
        }

    }

    private boolean isOpenAlread() {

        SharedPreferences sharedPreferences = getSharedPreferences("slide", MODE_PRIVATE);
        boolean result = sharedPreferences.getBoolean("slide", false);
        return false;

    }
}

package com.twlapps.goscliqueexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.twlapps.gosclique.Gosclique;
import com.twlapps.gosclique.ShowCallBack;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        Gosclique.getInstance().init("43194301809576855617", "8624961916981", MainActivity.this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gosclique.getInstance().showSurveyPanel(new ShowCallBack() {
                    @Override
                    public void success() {
                        Toast.makeText(MainActivity.this, "Opened", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void fail(String err) {
                        Toast.makeText(MainActivity.this, err, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
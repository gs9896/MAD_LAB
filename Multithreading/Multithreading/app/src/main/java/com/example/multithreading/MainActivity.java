package com.example.multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar p = (ProgressBar) findViewById(R.id.ProgressBar1);
        final TextView t = (TextView) findViewById(R.id.TextView1);
        Button b = (Button) findViewById(R.id.Button1);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        for (int i=0; i<= 100; i++)
                        {
                            final int temp = i;
                            try {
                                Thread.sleep(500);
                            }
                            catch(InterruptedException e){
                                e.printStackTrace();
                            }
                            p.post(new Runnable() {
                                @Override
                                public void run() {
                                    p.setProgress(temp);
                                    t.setText(temp + "%");
                                }
                            });
                        }
                    }
                };
                new Thread(r).start();
            }
        });
    }
}
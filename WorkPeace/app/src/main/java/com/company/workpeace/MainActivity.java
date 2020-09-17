package com.company.workpeace;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //aqui ahora lo modifico desde el pc
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                //finish();
            }

        }, 5000);
    }
}

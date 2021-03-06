package org.myself.androidlibraries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotFormValidation(View view) {
        startActivity(new Intent(MainActivity.this, FormValidationActivity.class));
    }

    public void goToNoInternetCheck(View view) {
        startActivity(new Intent(MainActivity.this, NoInternetCheckActivity.class));
    }

    public void goToToasty(View view) {
        startActivity(new Intent(MainActivity.this, ToastyActivity.class));
    }
}

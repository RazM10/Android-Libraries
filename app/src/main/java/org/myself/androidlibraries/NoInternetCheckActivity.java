package org.myself.androidlibraries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import am.appwise.components.ni.NoInternetDialog;

public class NoInternetCheckActivity extends AppCompatActivity {

    NoInternetDialog noInternetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet_check);

        noInternetDialog = new NoInternetDialog.Builder(NoInternetCheckActivity.this).build();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        noInternetDialog.onDestroy();
    }

    public void goToMain(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}

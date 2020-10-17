package org.myself.androidlibraries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

import static android.R.*;
import static android.graphics.Typeface.BOLD_ITALIC;

public class ToastyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toasty);

        findViewById(R.id.button_normal_toast_w_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable icon = getResources().getDrawable(R.drawable.ic_check_circle_black_24dp);
                Toasty.normal(ToastyActivity.this, "Normal toast with icon", icon).show();
            }
        });

        findViewById(R.id.button_info_toast_with_formatting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(ToastyActivity.this, getFormattedMessage()).show();
            }
        });
    }

    public void clickForErrorToast(View view) {
        Toasty.error(this, "This is an error toast.", Toast.LENGTH_SHORT, true).show();
    }

    public void clickForSuccessToast(View view) {
        Toasty.success(this, "This is an success toast.", Toast.LENGTH_SHORT, true).show();
    }

    public void clickForInfoToast(View view) {
        Toasty.info(this, "This is an info toast.", Toast.LENGTH_SHORT, true).show();
    }

    public void clickForWarningToast(View view) {
        Toasty.warning(this, "This is an warning toast.", Toast.LENGTH_SHORT, true).show();
    }

    public void clickForNormalToast(View view) {
        Toasty.normal(this, "Normal toast w/o icon").show();
    }

    public void clickForCustomToast(View view) {
        Toasty.Config.getInstance()
                .setToastTypeface(Typeface.createFromAsset(getAssets(), "PCap Terminal.otf"))
                .allowQueue(false)
                .apply();
        Toasty.custom(ToastyActivity.this, "Custom Toast", getResources().getDrawable(R.drawable.ic_check_circle_black_24dp),
                ContextCompat.getColor(ToastyActivity.this, R.color.colorYellow),
                ContextCompat.getColor(ToastyActivity.this, R.color.colorRed),
                Toasty.LENGTH_SHORT, true, true).show();
        Toasty.Config.reset(); // Use this if you want to use the configuration above only onceet(); // Use this if you want to use the configuration above only once
    }

    private CharSequence getFormattedMessage() {
        final String prefix = "Formatted ";
        final String highlight = "bold italic";
        final String suffix = " text";
        SpannableStringBuilder ssb = new SpannableStringBuilder(prefix).append(highlight).append(suffix);
        int prefixLen = prefix.length();
        ssb.setSpan(new StyleSpan(BOLD_ITALIC),
                prefixLen, prefixLen + highlight.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }
}

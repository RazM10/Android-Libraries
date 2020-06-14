package org.myself.androidlibraries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import de.psdev.formvalidations.EditTextErrorHandler;
import de.psdev.formvalidations.Field;
import de.psdev.formvalidations.Form;
import de.psdev.formvalidations.validations.InRange;
import de.psdev.formvalidations.validations.IsEmail;
import de.psdev.formvalidations.validations.NotEmpty;

public class FormValidationActivity extends AppCompatActivity {

    EditText mName, mEmail, mAge;
    // Form used for validation
    private Form mForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_validation);

        mName = findViewById(R.id.name);
        mEmail = findViewById(R.id.email);
        mAge = findViewById(R.id.age);

        initValidationForm();
    }

    private void initValidationForm() {
        mForm = Form.create();
        mForm.addField(Field.using(mName).validate(NotEmpty.build()));
        mForm.addField(Field.using(mEmail).validate(NotEmpty.build()).validate(IsEmail.build()));
        mForm.addField(Field.using(mAge).validate(InRange.build(0, 120)));
        mForm.errorHandler(new EditTextErrorHandler());
    }

    private void submit() {
        if (mForm.isValid()) {
            Toast.makeText(this, "Form is valid", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Form is not valid", Toast.LENGTH_SHORT).show();
        }
    }

    public void submit(View view) {
        submit();
    }
}

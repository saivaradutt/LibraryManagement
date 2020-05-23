package com.example.myproject;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    EditText username, password, email, dob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void registerOnClick(View view){
        username = (EditText) findViewById(R.id.register_username);
        password = (EditText) findViewById(R.id.register_password);
        email = (EditText) findViewById(R.id.register_email);
        dob = (EditText) findViewById(R.id.register_DOB);
        if ( !TextUtils.isEmpty(username.getText().toString()) && !TextUtils.isEmpty(password.getText().toString()) && !TextUtils.isEmpty(email.getText().toString()) &&!TextUtils.isEmpty(dob.getText().toString()))
        {
            registerMethod();

        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);

            builder.setTitle("Please fill all fields.");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    if (dialog != null) {
                        dialog.dismiss();
                    }
                }
            });
            builder.create().show();
        }
    }


    public void registerMethod(){

        UserDbManager db = new UserDbManager(this);
        String res = db.registerOnClick(username.getText().toString(), password.getText().toString(), email.getText().toString(), dob.getText().toString());
        Toast.makeText(this, "Clicked Register", Toast.LENGTH_SHORT).show();
        Toast.makeText(this,res,Toast.LENGTH_LONG).show();

        username.setText("");
        password.setText("");
        email.setText("");
        dob.setText("");
    }
}

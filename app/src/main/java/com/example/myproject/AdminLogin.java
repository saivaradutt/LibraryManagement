package com.example.myproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AdminLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

    }

    public void adminLoginBtn(View view){

        startActivity(new Intent(this, AdminHomePage.class));

        EditText adminUsername = findViewById(R.id.admin_username);
        EditText adminPwd = findViewById(R.id.admin_password);

        if(!(TextUtils.isEmpty(adminUsername.getText().toString()) && TextUtils.isEmpty((adminPwd.getText().toString())))){

            if (((adminUsername.getText().toString()).equals("admin")) && ((adminPwd.getText().toString()).equals("password"))) {

                startActivity(new Intent(this, AdminHomePage.class));

                Toast.makeText(this, "Welcome " + adminUsername.getText().toString(), Toast.LENGTH_SHORT).show();

            }else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);

                    builder.setTitle("Please fill both fields or enter correct credentials.");

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

    }
}

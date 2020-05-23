package com.example.myproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    UserDbManager obj = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.admin_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Item1:
                startActivity(new Intent(this, AdminLogin.class));
                break;
            case R.id.help:
                //Toast.makeText(this, "Activity B", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Help.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickedRegister(View view){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    public void userLoginBtnClicked(View view) {
        EditText usrName = findViewById(R.id.main_username);
        EditText pwd = findViewById(R.id.main_password);

        if ( !TextUtils.isEmpty(usrName.getText().toString())&& !TextUtils.isEmpty(pwd.getText().toString())) {
            obj = new UserDbManager(this);
            Cursor result = obj.searchData(usrName.getText().toString(), pwd.getText().toString()); // Cursor holds a complete row
            // Toast.makeText(this, "hello ", Toast.LENGTH_LONG).show();

            startActivity(new Intent(this, SplashActivity.class));

            while(result.moveToNext()){
                //textView.setText(result.getString(1)+" "+result.getString(2));
                Toast.makeText(this, "Welcome " +result.getString(1), Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Please fill both fields.");

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

package com.dat.simpleapp.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameInput;
    EditText passwordInput;
    TextView showInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        passwordInput = findViewById(R.id.passwordInput);
        showInfo = findViewById(R.id.showInfo);
    }

    public void addInfo(View view) {
        //Creates the file
        SharedPreferences sharedPreferences = getSharedPreferences("nameOfFile", Context.MODE_PRIVATE);

        //Creates the editor
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //Adds a String to the file
        editor.putString("nameInput", nameInput.getText().toString());
        editor.putString("passwordInput", passwordInput.getText().toString());
        //To apply
        editor.apply();

        Toast.makeText(getApplicationContext(), "Saved!", Toast.LENGTH_LONG).show();
    }

    public void displayInfo(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("nameOfFile", Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("nameInput", "");
        String password = sharedPreferences.getString("passwordInput", "");

        showInfo.setText(name + "\n" + password);
    }

}

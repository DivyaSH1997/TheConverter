package com.example.theconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername,edtPassword,edtNumber;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
    }
    public void initViews()
    {
        edtUsername=findViewById(R.id.edtUsername);
        edtPassword=findViewById(R.id.edtPassword);
        edtNumber=findViewById(R.id.edtNumber);
        btnLogin=findViewById(R.id.btnLogin);
    }
    public void initListeners()
    {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                if(edtUsername.getText().toString().equals("divya") && edtPassword.getText().toString().equals("divya123"))
                {
                    makeToast("Login Succesful!");
                    Intent intent=new Intent(MainActivity.this,ConverterActivity.class);
                    intent.putExtra("username",edtUsername.getText().toString());
                    String num=edtNumber.getText().toString();
                    intent.putExtra("number",Integer.parseInt(num));
                    startActivity(intent);


                }
                else
                {
                    edtUsername.setText("");
                    edtPassword.setText("");
                    edtNumber.setText("");
                    makeToast("Login Failed");
                }

            }

        });

    }
    private void makeToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
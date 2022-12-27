package com.example.theconverter;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ConverterActivity extends AppCompatActivity {
    TextView txtUsername,txtNumber;
    EditText edtAmountEnter;
    String name;
    int number;
    Button btnDate,btnTime;
    TextView txtDate,txtTime;
    Button btnConvert;

    public static float money;
    private final int SETTINGS = 100, LOGOUT = 200;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currency_converter_activity);

       initViews();
       initListeners();
       getDetails();
    }
    public void initViews()
    {
        txtUsername=findViewById(R.id.txtUsername);
        txtNumber=findViewById(R.id.txtNumber);
        txtDate=findViewById(R.id.txtDate);
        txtTime=findViewById(R.id.txtTime);
        btnDate=findViewById(R.id.btnDate);
        btnTime=findViewById(R.id.btnTime);
        edtAmountEnter=findViewById(R.id.edtAmountEnter);
        btnConvert=findViewById(R.id.btnConvert);
    }
    public void initListeners()
    {
        btnConvert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                money= Float.parseFloat(edtAmountEnter.getText().toString());
                ConvertDialog convertDialog = new ConvertDialog(ConverterActivity.this);

                convertDialog.show();

            }
        });


        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        ConverterActivity.this,
                        new MyOnDateSetListener(),
                        2022,
                        11,
                        27
                );
                datePickerDialog.show();
            }

        });



        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        ConverterActivity.this,
                        new MyOnTimeSetListener(),
                        18,
                        00,
                        true
                );
                timePickerDialog.show();

            }
        });
    }
    public void getDetails()
    {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        name=bundle.getString("username");
        number=bundle.getInt("number");

        txtUsername.setText(name);
        txtNumber.setText(String.valueOf(number));
    }


    class MyOnDateSetListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            txtDate.setText(year + "/" + month + "/" + dayOfMonth);
        }
    }
    class MyOnTimeSetListener implements TimePickerDialog.OnTimeSetListener{
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            txtTime.setText(hourOfDay + ":" + minute);
        }
    }
    private void makeToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuItem menuItemSettings= menu.add(1,100,1,"Settings");
        MenuItem menuItemLogout = menu.add(2,200,2,"Logout");

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case SETTINGS:
                Log.e("tag","Settings");
                makeToast("Settings");
                break;
            case LOGOUT:
                Log.e("tag","Logout");
                makeToast("Logout");
                finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}

package com.example.theconverter;

import android.app.Dialog;
import android.content.Context;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;



public class ConvertDialog extends Dialog {
    TextView txtdisplayNumber;
    RadioGroup radioCountry;
    RadioButton radioUSA,radioEurope,radioAustralia,radioJapan;
    Button btnFinish;
    float value,ans;

    public ConvertDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.converter_dialog);
       initViews();
       initListener();
    }
    public void initViews()
    {
        txtdisplayNumber=findViewById(R.id.txtDisplayNumber);
        radioCountry=findViewById(R.id.radioCountry);
        radioUSA=findViewById(R.id.radioUSA);
        radioEurope=findViewById(R.id.radioEurope);
        radioAustralia=findViewById(R.id.radioAustralia);
        radioJapan=findViewById(R.id.radioJapan);
        btnFinish=findViewById(R.id.btnFinish);
    }
    public void initListener()
    {
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeToast("Dismissed");
                dismiss();

            }
        });
        radioCountry.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                value = ConverterActivity.money;
                checkedId = radioCountry.getCheckedRadioButtonId();
                switch (checkedId) {
                    case R.id.radioUSA:
                        ans = value * 0.0121F;
                        txtdisplayNumber.setText(String.valueOf(ans));
                        break;
                    case R.id.radioEurope:
                        ans = value * 0.011F;
                        txtdisplayNumber.setText(String.valueOf(ans));
                        break;
                    case R.id.radioAustralia:
                        ans = value * 0.018F;
                        txtdisplayNumber.setText(String.valueOf(ans));
                        break;
                    case R.id.radioJapan:
                        ans = value * 1.61F;
                        txtdisplayNumber.setText(String.valueOf(ans));
                        break;
                }

            }
        });
    }

    private void makeToast(String text){
        Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();
    }


}

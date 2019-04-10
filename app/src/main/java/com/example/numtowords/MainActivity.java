package com.example.numtowords;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private EditText txt1;
    private TextView txt_output;
    public boolean validate(){
        boolean checkvalidate=true;
        if (TextUtils.isEmpty(txt1.getText().toString())) {
            txt1.setError("Number is required");
            txt1.requestFocus();
            checkvalidate = false;

        }


        return  checkvalidate;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=findViewById(R.id.txt1);

        txt_output=findViewById(R.id.txt_output);
        btn1=findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(validate()) {
                    int num1 = Integer.parseInt(txt1.getText().toString());
                    String return_val_in_english = EnglishNumberToWords.convert(num1);


                    txt_output.setText(num1 + " In Word: " + return_val_in_english);

                }



            }
        });


    }


}

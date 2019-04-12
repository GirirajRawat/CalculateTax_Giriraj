package com.example.calculatetax_giriraj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etSalary;
    private Button btnCalculate;
    private TextView tvTotalSalary, tvTotalTax;
    private Float salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSalary=(EditText)findViewById(R.id.etSalary);
        btnCalculate=(Button)findViewById(R.id.btnCalculate);
        tvTotalSalary=(TextView)findViewById(R.id.tvTotalSalary);
        tvTotalTax=(TextView)findViewById(R.id.tvTotalTax);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Validation() == true) {
                    salary = Float.parseFloat(etSalary.getText().toString());
                    CalculateTax_Giriraj tax = new CalculateTax_Giriraj(salary);
                    tvTotalSalary.setText(Float.toString(tax.getTotalSalary()));
                    tvTotalTax.setText(Float.toString(tax.calculate()));
                }
            }
        });


    }
    public Boolean Validation(){
        if (TextUtils.isEmpty(etSalary.getText())){
            etSalary.requestFocus();
            etSalary.setError("Please enter your salary");
            return false;
        }
        return  true;
    }
}

package edu.quinnipiac.ser210.ls02_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {

    private EditText input1, input2;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = (EditText) findViewById(R.id.num1);
        input2 = (EditText) findViewById(R.id.num2);
        result = (TextView) findViewById(R.id.res);
        Spinner op_spinner = (Spinner) findViewById(R.id.operations_spinner);
        op_spinner.setSelection(0,false);
        op_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (input1.getText() != null && input2.getText() != null){
                    double num1 = Double.valueOf(input1.getText().toString());
                    double num2 = Double.valueOf(input2.getText().toString());
                    String selected = (String) adapterView.getItemAtPosition(i);
                    double num_result;
                    //implementation of each math operation, this code should be moved in one method
                    if (selected.equals("*"))
                        num_result = num1 * num2;
                    else
                        num_result = num1/num2;

                    result.setText(Double.toString(num_result));
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button add = (Button) findViewById(R.id.sum);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input1.getText() != null && input2.getText() != null){
                    double num1 = Double.valueOf(input1.getText().toString());
                    double num2 = Double.valueOf(input2.getText().toString());
                    double num_result = num1 + num2;
                    result.setText(Double.toString(num_result));
                }

            }
        });
        Button sub = (Button) findViewById(R.id.sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input1.getText() != null && input2.getText() != null){
                    double num1 = Double.valueOf(input1.getText().toString());
                    double num2 = Double.valueOf(input2.getText().toString());
                    double num_result = num1 - num2;
                    result.setText(Double.toString(num_result));
                }

            }
        });

    }
    /*public void subtraction(View v){
        //implement subtraction
    }*/

}

package com.example.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainCalculatorActivity extends Activity {

	Button btnAdd;
	Button btnSub;
	Button btnMul;
	Button btnDiv;
	
	Button btnExit;
	TextView result;
	EditText num1;
	EditText num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitycalculator_main);
        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnSub=(Button)findViewById(R.id.btnSub);
        btnMul=(Button)findViewById(R.id.btnMul);
        btnDiv=(Button)findViewById(R.id.btnDiv);
        
        btnExit=(Button)findViewById(R.id.btnExit);
        result=(TextView) findViewById(R.id.textResult);
        
        num1=(EditText)findViewById(R.id.editNum2);
        num2=(EditText)findViewById(R.id.editNum1);
    }

    public void getCalc(View view){
    	
    	double number1=Double.parseDouble(num1.getText().toString());
    	double number2=Double.parseDouble(num2.getText().toString());
    	
    	switch(view.getId()){
    	case R.id.btnAdd: 
    		String add=Double.toString(CalculatorNumbers.add(number1, number2));
    		result.setText(add);
    		break;
    	case R.id.btnSub:
    		String sub=Double.toString(CalculatorNumbers.sub(number1, number2));
    		result.setText(sub);
    		break;
    	case R.id.btnMul:
    		String mul=Double.toString(CalculatorNumbers.mul(number1, number2));
    		result.setText(mul);
    		break;
    	case R.id.btnDiv:
    		String div=Double.toString(CalculatorNumbers.div(number1, number2));
    		result.setText(div);
    		break;
    	case R.id.btnExit:
    		this.finish();
    		break;
    	
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

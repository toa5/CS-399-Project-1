package com.cs399.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class CalculatorActivity extends Activity 
{
	String str1 ="", str2 = "";
	boolean onStr1;
	Operation operation;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        onStr1 = true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calculator, menu);
        return true;
    }
    
    private void setText(String string)
    {	((EditText)findViewById(R.id.textBox)).setText(string);}
    
    public void add1(View view)
    {	
    	if(onStr1) str1 += "1";
    	else str2 += "1";
    	setText(onStr1 ? str1 : str2);
    }
    
    public void add2(View view)
    {	
    	if(onStr1) str1 += "2";
    	else str2 += "2";
    	setText(onStr1 ? str1 : str2);
    }
    
    public void add3(View view)
    {	
    	if(onStr1) str1 += "3";
    	else str2 += "3";
    	setText(onStr1 ? str1 : str2);
    }
    
    public void add4(View view)
    {	
    	if(onStr1) str1 += "4";
    	else str2 += "4";
    	setText(onStr1 ? str1 : str2);
    }
    
    public void add5(View view)
    {	
    	if(onStr1) str1 += "5";
    	else str2 += "5";
    	setText(onStr1 ? str1 : str2);
    }
    
    public void add6(View view)
    {	
    	if(onStr1) str1 += "6";
    	else str2 += "6";
    	setText(onStr1 ? str1 : str2);
    }
    
    public void add7(View view)
    {	
    	if(onStr1) str1 += "7";
    	else str2 += "7";
    	setText(onStr1 ? str1 : str2);
    }
    
    public void add8(View view)
    {	
    	if(onStr1) str1 += "8";
    	else str2 += "8";
    	setText(onStr1 ? str1 : str2);
    }
    
    public void add9(View view)
    {	
    	if(onStr1) str1 += "9";
    	else str2 += "9";
    	setText(onStr1 ? str1 : str2);
    }
    
    public void add0(View view)
    {	
    	if(onStr1) str1 += "0";
    	else str2 += "0";
    	setText(onStr1 ? str1 : str2);
    }
    
    public void addDecimal(View view)
    {
    	if(onStr1) str1 += ".";
    	else str2 += ".";
    	setText(onStr1 ? str1 : str2);
    }
    
    public void setAddition(View view)
    {	
    	operation = Operation.ADDITION;
    	if(onStr1)
    	{
    		onStr1 = false;
    		setText("0");
    	}
    	else
    	{
    		str1 = calculate(view);
    		setText(str1);
    	}
    }
    
    public void setSubtraction(View view)
    {	
    	operation = Operation.SUBTRACTION;
    	if(onStr1)
    	{
    		onStr1 = false;
    		setText("0");
    	}
    	else
    	{
    		str1 = calculate(view);
    		setText(str1);
    	}
    }
    
    public void setMultiplication(View view)
    {	
    	operation = Operation.MULTIPLICATION;
    	if(onStr1)
    	{
    		onStr1 = false;
    		setText("0");
    	}
    	else
    	{
    		str1 = calculate(view);
    		setText(str1);
    	}
    }
    
    public void setDivision(View view)
    {	
    	operation = Operation.DIVISION;
    	if(onStr1)
    	{
    		onStr1 = false;
    		setText("0");
    	}
    	else
    	{
    		str1 = calculate(view);
    		setText(str1);
    	}
    }
    
    public void clear(View view)
    {
    	str1 = ""; str2 = "";
    	onStr1 = true;
    	setText("");
    }
    
    public void back(View view)
    {
    	try
    	{
    		if(onStr1)
    		{
    			str1 = str1.substring(0, str1.length()-1);
    			setText(str1);
    		}
    		else
    		{
    			str2 = str2.substring(0, str2.length()-1);
    			setText(str2);
    		}
    	}
    	catch(IndexOutOfBoundsException i){}
    }
    
    public String calculate(View view)
    {
    	try
    	{
	    	final float num1 = Float.parseFloat(str1),
	    				num2 = Float.parseFloat(str2), value;
			switch(operation)
	    	{
	    		case ADDITION:
	    			value = num1+num2;
	    			break;
	    		case SUBTRACTION:
	    			value = num1-num2;
	    			break;
	    		case MULTIPLICATION:
	    			value = num1*num2;
	    			break;
	    		//case DIVISION:
	    		default:
	    			value = num1/num2;
	    			break;
	    	}
			String rval = Float.toString(value);
			clear(view);
			setText(rval);
	    	return rval;
    	}
    	catch(NumberFormatException e)
    	{	setText(""); return "";}
    }
}

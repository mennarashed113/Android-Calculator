package com.example.androidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.androidcalculator.databinding.ActivityMainBinding;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnOne.setOnClickListener(this);
        binding.btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });
        binding.btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletechar();
            }
        });
        binding.seven.setOnClickListener(this);
        binding.eight.setOnClickListener(this);
        binding.nine.setOnClickListener(this);
        binding.four.setOnClickListener(this);
        binding.five.setOnClickListener(this);
        binding.six.setOnClickListener(this);
        binding.three.setOnClickListener(this);
        binding.two.setOnClickListener(this);
        binding.zero.setOnClickListener(this);
        binding.dot.setOnClickListener(this);


        binding.multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String b = binding.textResult.getText().toString().trim();
                if(!b.isEmpty()){
                    if(b.charAt(b.length()-1)!='-'&&b.charAt(b.length()-1)!='+'&&b.charAt(b.length()-1)!='/'&&b.charAt(b.length()-1)!='%'&&b.charAt(b.length()-1)!='x'){
                        binding.textResult.append(binding.multiply.getText().toString().trim());
                    }
                }
            }
        });
        binding.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String b = binding.textResult.getText().toString().trim();
                if(!b.isEmpty()){
                    if(b.charAt(b.length()-1)!='-'&&b.charAt(b.length()-1)!='+'&&b.charAt(b.length()-1)!='/'&&b.charAt(b.length()-1)!='%'&&b.charAt(b.length()-1)!='x') {
                        binding.textResult.append(binding.minus.getText().toString().trim());
                    }
                }
            }
        });
        binding.btnModuls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String b = binding.textResult.getText().toString().trim();
                if(!b.isEmpty()){
                    if(b.charAt(b.length()-1)!='-'&&b.charAt(b.length()-1)!='+'&&b.charAt(b.length()-1)!='/'&&b.charAt(b.length()-1)!='%'&&b.charAt(b.length()-1)!='x'){
                        binding.textResult.append(binding.btnModuls.getText().toString().trim());
                    }
                }
            }
        });
        binding.btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String b = binding.textResult.getText().toString().trim();
                if(!b.isEmpty()){
                    if(b.charAt(b.length()-1)!='-'&&b.charAt(b.length()-1)!='+'&&b.charAt(b.length()-1)!='/'&&b.charAt(b.length()-1)!='%'&&b.charAt(b.length()-1)!='x'){
                        binding.textResult.append(binding.btnDivide.getText().toString().trim());
                    }
                }
            }
        });
        binding.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String b = binding.textResult.getText().toString().trim();
                if(!b.isEmpty()){
                    if(b.charAt(b.length()-1)!='-'&&b.charAt(b.length()-1)!='+'&&b.charAt(b.length()-1)!='/'&&b.charAt(b.length()-1)!='%'&&b.charAt(b.length()-1)!='x'){
                        binding.textResult.append(binding.plus.getText().toString().trim());
                    }
                }
            }
        });


        binding.equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String calc = binding.textResult.getText().toString().trim();

                 if(calc.contains("-")){
                     String [] oper = calc.split("-");
                     if(oper.length==2){
                         startcal(Double.parseDouble(oper[0]),'-',Double.parseDouble(oper[1]));
                     }
                 }
                 else if (calc.contains("+")) {
                     String [] oper = calc.split("\\+");
                     if(oper.length==2){
                         startcal(Double.parseDouble(oper[0]),'+',Double.parseDouble(oper[1]));
                     }
                 }
                 else if (calc.contains("/")) {
                     String [] oper = calc.split("/");
                     if(oper.length==2){
                         startcal(Double.parseDouble(oper[0]),'/',Double.parseDouble(oper[1]));
                     }
                 }
                 else if (calc.contains("x")) {
                     String [] oper = calc.split("x");
                     if(oper.length==2){
                         startcal(Double.parseDouble(oper[0]),'x',Double.parseDouble(oper[1]));
                     }
                 }
                 else if (calc.contains("%")) {
                     String [] oper = calc.split("%");
                     if(oper.length==2){
                         startcal(Double.parseDouble(oper[0]),'%',Double.parseDouble(oper[1]));
                     }
                 }



                 }
            });
        }





    @Override
    public void onClick(View view) {
        MaterialButton b = (MaterialButton) view;
        binding.textResult.append(b.getText().toString().trim());


    }
    private void startcal(double FN, char op,double SN){
        if(op=='-') binding.textResult.setText(String.format("%s", FN - SN));
        else if (op=='+') binding.textResult.setText(String.format("%s", FN + SN));
        else if (op=='/') binding.textResult.setText(String.format("%s", FN / SN));
        else if (op=='%') binding.textResult.setText(String.format("%s", FN % SN));
        else if (op=='x') binding.textResult.setText(String.format("%s", FN * SN));


    }
    private void clear(){
    binding.textResult.setText("");
    }
    private  void deletechar(){
        String s =binding.textResult.getText().toString().trim();
        binding.textResult.setText( s.substring(0, s.length() - 1));
    }
}
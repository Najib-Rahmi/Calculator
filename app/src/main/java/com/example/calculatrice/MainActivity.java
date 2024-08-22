package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public boolean update = false;
    public double chiffre;
    public String operateur = "";
    public Boolean clicOperateur = false;
    public EditText ecran;
    public Button plus,moin,fois,sur,egale,point,delete;
    public Button zero,one,two,three,four, five, six, seven, eight, nine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one =  findViewById(R.id.one);
        two =  findViewById(R.id.two);
        three =  findViewById(R.id.three);
        plus =  findViewById(R.id.plus);
        four =  findViewById(R.id.four);
        five =  findViewById(R.id.five);
        six =  findViewById(R.id.six);
        seven =  findViewById(R.id.seven);
        eight =  findViewById(R.id.eight);
        nine =  findViewById(R.id.nine);
        moin =  findViewById(R.id.moin);
        sur = findViewById(R.id.sur);
        fois = findViewById(R.id.fois);
        egale =  findViewById(R.id.egale);
        delete = findViewById(R.id.delete);
        zero = findViewById(R.id.zero);
        point =  findViewById(R.id.point);
        ecran = findViewById(R.id.text);

        plus. setOnClickListener (v->plusClick ());
        moin.setOnClickListener(v -> moinsClick());
        sur.setOnClickListener(v -> divClick());
        fois.setOnClickListener(v -> mulClick());
        delete.setOnClickListener(v -> resetClick());
        egale.setOnClickListener(v -> egalClick());
        point.setOnClickListener(v -> chiffreClick("."));
        zero.setOnClickListener(v -> chiffreClick("0"));
        one.setOnClickListener(v -> chiffreClick("1"));
        two.setOnClickListener(v -> chiffreClick("2"));
        three.setOnClickListener(v -> chiffreClick("3"));
        four.setOnClickListener(v -> chiffreClick("4"));
        five.setOnClickListener(v -> chiffreClick("5"));
        six.setOnClickListener(v -> chiffreClick("6"));
        seven.setOnClickListener(v -> chiffreClick("7"));
        eight.setOnClickListener(v -> chiffreClick("8"));
        nine.setOnClickListener(v -> chiffreClick("9"));


    }
    public void chiffreClick (String str) {
        if(update){
            update = false;
        }else{
            if(!ecran.getText().toString().equals ("0"))
                str = ecran.getText() + str;
        }
        ecran.setText (str);
    }
    public void plusClick() {

        if(clicOperateur){
            calcul ();
            ecran.setText (String.valueOf(chiffre));
        }else{
            chiffre = Double.parseDouble(ecran.getText().toString());
            clicOperateur = true;
        }
        operateur = "+";
        update = true;
    }
    public void moinsClick() {
        if(clicOperateur){
            calcul ();
            ecran.setText(String.valueOf (chiffre));
        }else{
            chiffre = Double.parseDouble(ecran.getText().toString());
            clicOperateur = true;
        }
        operateur = "-";
        update = true;
    }
    public void mulClick() {
        if(clicOperateur){
            calcul ();
            ecran.setText(String.valueOf (chiffre));
        }else{
            chiffre = Double.parseDouble(ecran.getText().toString());
            clicOperateur = true;
        }
        operateur = "*";
        update = true;
    }
    public void divClick(){
        if(clicOperateur){
            calcul ();
            ecran.setText(String.valueOf (chiffre));
        }else{
            chiffre = Double.parseDouble(ecran.getText().toString());
            clicOperateur = true;
        }
        operateur = "/";
        update = true;
    }
    public void egalClick() {
        calcul ();
        update = true;
        clicOperateur = false;
    }
    public void resetClick() {
        clicOperateur = false;
        update = true;
        chiffre = 0;
        operateur = "";
        ecran.setText ("");
    }
    private void calcul () {
        if (operateur. equals ("+")) {
            chiffre = chiffre + Double.parseDouble(ecran. getText (). toString ());
            ecran.setText(String.valueOf (chiffre));
        }

        if(operateur. equals ("-")){
            chiffre = chiffre - Double.parseDouble (ecran. getText (). toString ());
            ecran.setText(String.valueOf (chiffre));
        }

        if(operateur. equals ("*")){
            chiffre = chiffre * Double.parseDouble (ecran. getText (). toString ());
            ecran.setText(String.valueOf (chiffre));
        }

        if(operateur.equals("/")){
            try{
                chiffre = chiffre / Double.parseDouble(ecran.getText().toString());
                ecran.setText(String.valueOf(chiffre));
            }catch(ArithmeticException e){
                ecran.setText ("0");
            }
        }
    }
}
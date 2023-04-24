package com.example.postodegasolina;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText valorEtanol;
    private EditText valorGasolina;
    private Button economizar;
    private ImageView imgEtanol;
    private ImageView imgGasolina;
    private TextView textoImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valorEtanol = findViewById(R.id.ValorEtanol);
        valorGasolina = findViewById(R.id.ValorCombustivel);
        economizar = findViewById(R.id.Calcular);
        imgEtanol = findViewById(R.id.ImgEtanol);
        imgGasolina = findViewById(R.id.ImgGasolina);
        textoImg = findViewById(R.id.DescricaoImg);

    }

    public void comparaEconomia(View v){

        if(!valorGasolina.getText().toString().isEmpty() && !valorEtanol.getText().toString().isEmpty()){
            Double valor1 = Double.parseDouble(valorGasolina.getText().toString());
            Double valor2 = Double.parseDouble(valorEtanol.getText().toString());

            Double economia = valor1 * 0.70;


            if(valor2 <= economia){
                imgGasolina.setVisibility(v.INVISIBLE);
                imgEtanol.setVisibility(v.VISIBLE);
                textoImg.setText("ETANOL TA MAIS VANTAJOSO");

            }else {
                imgEtanol.setVisibility(v.INVISIBLE);
                imgGasolina.setVisibility(v.VISIBLE);
                textoImg.setText("GASOLINA VALE MAIS A PENA");
            }
        }else{
            AlertDialog.Builder a = new AlertDialog.Builder(v.getContext());
            a.setTitle("ATENÇÃO");
            a.setMessage("Os campos de valores não podem estar vazios.\nPor favor, Digite algum valor para economizar!!");
            a.setPositiveButton("Ok", null);
            a.create();
            a.show();
            imgGasolina.setVisibility(v.INVISIBLE);
            imgEtanol.setVisibility(v.INVISIBLE);
        }


    }
}
package com.example.pagconta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    float valorConta, valorDinheiro, valorGorjeta, total, troco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_ButtonCalcular=(Button)findViewById(R.id.idButtonCalcular);
        Button btn_ButtonLimparValores=(Button)findViewById(R.id.idButtonLimparValores);


        EditText editTextConta = (EditText) findViewById(R.id.idEditTextConta);
        EditText editTextDinheiro=(EditText)findViewById(R.id.idEditTextDinheiro);
        TextView textTotal=(TextView)findViewById(R.id.textTotal);
        TextView textTroco=(TextView)findViewById(R.id.textTroco);
        TextView textvalorDesconto=(TextView)findViewById(R.id.textValorDesconto);

        btn_ButtonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                valorConta=Float.parseFloat(editTextConta.getText().toString());
                valorDinheiro=Float.parseFloat(editTextDinheiro.getText().toString());
                valorGorjeta=valorConta*15/100;
                total=valorConta+valorGorjeta;
                troco=valorDinheiro-total;

                textvalorDesconto.setText(String.format("R$ %.2f",valorGorjeta));
                textTotal.setText(String.format("R$ %.2f",total));
                textTroco.setText(String.format("R$ %.2f",troco));

            }
        });
        btn_ButtonLimparValores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editTextConta.setText("");
                editTextDinheiro.setText("");
                textTotal.setText("");
                textTroco.setText("");
                textvalorDesconto.setText("");

            }
        });

    }
}
package br.ufpe.cin.residencia.calculadordeidade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        EditText textoEntrada = findViewById(R.id.texto);
        Button botao = findViewById(R.id.button);
        TextView textoSaida = findViewById(R.id.textView);

        botao.setOnClickListener(
                v -> {
                    String dataDigitada = textoEntrada.getText().toString();
                    textoSaida.setText(dataDigitada);

                }
        );
    }
}
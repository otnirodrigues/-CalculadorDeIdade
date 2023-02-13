package br.ufpe.cin.residencia.calculadordeidade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
                    Editable textDigitado = textoEntrada.getText();
                    String dataDigitada = textDigitado.toString();
                    String saida = idadeEmMinutos(dataDigitada);
                    textoSaida.setText(saida);

                }
        );
    }

    private String idadeEmMinutos(String data){
        SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy");
        String resultado = "";
        try {
            Date d = simple.parse(data);
            long dataEmMinutos = d.getTime()/60000;
            Date agora = simple.parse(simple.format(System.currentTimeMillis()));
            long agoraEmMinutos = agora.getTime()/60000;
            long diferenca = agoraEmMinutos-dataEmMinutos;
            resultado = String.valueOf(diferenca);
        }catch (ParseException e){
            //throw new RuntimeException(e);
            Toast.makeText(this, "A data fornecida não está no formato correto (DD/MM/YYYY).",
                    Toast.LENGTH_LONG).show();
        }
        return resultado;
    }
}
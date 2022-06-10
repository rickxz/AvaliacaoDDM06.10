package com.example.avaliacaoddm0610;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Camila Basaglia e Herick Victor
    private EditText txtEscola;
    private Button btnOK;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEscola = findViewById(R.id.txtEscola);
        btnOK = findViewById(R.id.btnOK);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnListener btnListener = new btnListener();
        btnOK.setOnClickListener(btnListener);
        btnCancelar.setOnClickListener(btnListener);
    }

    class btnListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button botao = (Button) view;
            switch (botao.getId()) {
                case R.id.btnOK:
                    if (txtEscola.getText().toString().trim().length() == 0) {
                        Toast.makeText(MainActivity.this, "Nome da escola não pode estar vazio", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
                        String escola = txtEscola.getText().toString();
                        intent.putExtra("escola", escola);
                        finish();
                        startActivity(intent);
                    }
                    break;

                case R.id.btnCancelar:
                    finish();
                    break;
            }
        }
    }
}
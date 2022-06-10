package com.example.avaliacaoddm0610;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfessorActivity extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtTitulacao;
    private Button btnProfessorOK;
    private Button btnProfessorCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);
        txtNome = findViewById(R.id.txtNome);
        txtTitulacao = findViewById(R.id.txtTitulacao);
        btnProfessorOK = findViewById(R.id.btnProfessorOK);
        btnProfessorCancelar = findViewById(R.id.btnProfessorCancelar);
        btnListener btnListener = new btnListener();
        btnProfessorOK.setOnClickListener(btnListener);
        btnProfessorCancelar.setOnClickListener(btnListener);
    }

    class btnListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button botao = (Button) view;
            switch (botao.getId()) {
                case R.id.btnProfessorOK:
                    Intent intent = new Intent();
                    String nomeProfessor = txtNome.getText().toString();
                    String titulacao = txtTitulacao.getText().toString();
                    if (nomeProfessor.trim().length() == 0 || titulacao.trim().length() == 0) {
                        Toast.makeText(ProfessorActivity.this, "Nome do professor e titulação não podem ser vazios", Toast.LENGTH_SHORT).show();
                    } else {
                        intent.putExtra("nome", nomeProfessor);
                        intent.putExtra("titulacao", titulacao);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                    break;
                case R.id.btnProfessorCancelar:
                    setResult(RESULT_CANCELED);
                    finish();
                    break;
            }
        }
    }
}
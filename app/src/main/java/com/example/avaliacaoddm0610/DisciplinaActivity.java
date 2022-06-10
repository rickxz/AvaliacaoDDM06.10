package com.example.avaliacaoddm0610;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DisciplinaActivity extends AppCompatActivity {

    private EditText txtDisciplina;
    private Button btnDisciplinaOK;
    private Button btnDisciplinaCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplina);

        txtDisciplina = findViewById(R.id.txtDisciplina);
        btnDisciplinaOK = findViewById(R.id.btnDisciplinaOK);
        btnDisciplinaCancelar = findViewById(R.id.btnDisciplinaCancelar);

        btnListener btnListener = new btnListener();
        btnDisciplinaOK.setOnClickListener(btnListener);
        btnDisciplinaCancelar.setOnClickListener(btnListener);
    }

    class btnListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button botao = (Button) view;
            switch (botao.getId()) {
                case R.id.btnDisciplinaOK:
                    Intent intent = new Intent();
                    String nome = txtDisciplina.getText().toString();
                    if (nome.trim().length() == 0) {
                        Toast.makeText(DisciplinaActivity.this, "O nome da disciplina não pode estar vazio", Toast.LENGTH_SHORT).show();
                    } else {
                        intent.putExtra("nomeDisciplina", nome);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                    break;
                case R.id.btnDisciplinaCancelar:
                    setResult(RESULT_CANCELED);
                    finish();
                    break;
            }
        }
    }
}
package com.example.avaliacaoddm0610;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {

    private TextView lblEscola;
    private Button btnProfessor;
    private Button btnDisciplina;
    private RadioGroup radioGroup;
    private RadioButton radDisc1;
    private RadioButton radDisc2;
    private RadioButton radDisc3;
    private TextView lblProf;
    private TextView lblTitulo;
    private TextView lblDisc1;
    private TextView lblDisc2;
    private TextView lblDisc3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        lblEscola = findViewById(R.id.lblEscola);
        btnProfessor = findViewById(R.id.btnProfessor);
        btnDisciplina = findViewById(R.id.btnDisciplina);
        radioGroup = findViewById(R.id.radioGroup);
        radDisc1 = findViewById(R.id.radDisc1);
        radDisc2 = findViewById(R.id.radDisc2);
        radDisc3 = findViewById(R.id.radDisc3);
        lblProf = findViewById(R.id.lblProf);
        lblTitulo = findViewById(R.id.lblTitulo);
        lblDisc1 = findViewById(R.id.lblDisc1);
        lblDisc2 = findViewById(R.id.lblDisc2);
        lblDisc3 = findViewById(R.id.lblDisc3);

        Intent intent = getIntent();
        String nomeEscola = intent.getStringExtra("escola");
        lblEscola.setText(nomeEscola);

        btnProfessor.setOnClickListener(new btnProfessorListener());
        btnDisciplina.setOnClickListener(new btnDisciplinaListener());
    }

    class btnProfessorListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), ProfessorActivity.class);
            startActivityForResult(intent, 1);
        }
    }

    class btnDisciplinaListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int radioSelecionado = radioGroup.getCheckedRadioButtonId();
            if (radioSelecionado == -1) {
                Toast.makeText(PrincipalActivity.this, "Nenhuma disciplina selecionada", Toast.LENGTH_SHORT).show();
            } else {
                int disciplinaEscolhida = 0;
                switch (radioSelecionado) {
                    case R.id.radDisc1:
                        disciplinaEscolhida = R.id.radDisc1;
                        break;
                    case R.id.radDisc2:
                        disciplinaEscolhida = R.id.radDisc2;
                        break;
                    case R.id.radDisc3:
                        disciplinaEscolhida = R.id.radDisc3;
                        break;
                }
                Intent intent = new Intent(getApplicationContext(), DisciplinaActivity.class);
                startActivityForResult(intent, disciplinaEscolhida);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String nome = data.getStringExtra("nome");
                    String titulacao = data.getStringExtra("titulacao");
                    lblProf.setText(nome);
                    lblTitulo.setText(titulacao);
                }
                break;
            case R.id.radDisc1:
                if (resultCode == RESULT_OK) {
                    String disciplina1 = data.getStringExtra("nomeDisciplina");
                    lblDisc1.setText(disciplina1);
                }
                break;
            case R.id.radDisc2:
                if (resultCode == RESULT_OK) {
                    String disciplina2 = data.getStringExtra("nomeDisciplina");
                    lblDisc2.setText(disciplina2);
                }
                break;
            case R.id.radDisc3:
                if (resultCode == RESULT_OK) {
                    String disciplina3 = data.getStringExtra("nomeDisciplina");
                    lblDisc3.setText(disciplina3);
                }
                break;
        }
    }
}
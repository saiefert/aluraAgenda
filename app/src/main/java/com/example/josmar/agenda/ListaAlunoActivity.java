package com.example.josmar.agenda;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.example.josmar.agenda.DAO.AlunoDAO;
import com.example.josmar.agenda.modelo.Aluno;

import java.util.List;

public class ListaAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_aluno);
        }

    private void carregaLista() {
        AlunoDAO dao = new AlunoDAO(this);
        List<Aluno> alunos = dao.buscaAlunos();
        dao.close();


        ListView listaAlunos = findViewById(R.id.lista_alunos);
        ArrayAdapter<Aluno> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alunos);
        listaAlunos.setAdapter(adapter);
    }

    public void novoAluno(View view) {
        Intent intentVaiProFormulario = new Intent(ListaAlunoActivity.this, FormularioActivity.class);
        startActivity(intentVaiProFormulario);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }
}



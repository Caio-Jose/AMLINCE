package br.com.fiap.lince;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);
    }

    public void adicionarCredito(View view) {
        Intent it = new Intent(this, AddCredito.class);
        startActivity(it);
    }

    public void sair(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}

package br.com.fiap.lince;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Cadastrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);
    }

    public void cadastro(View view) {
        Toast.makeText(this, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
    }
}

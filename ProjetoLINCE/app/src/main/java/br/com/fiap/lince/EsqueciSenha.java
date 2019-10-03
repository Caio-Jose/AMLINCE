package br.com.fiap.lince;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class EsqueciSenha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.esqueci_senha);
    }

    public void enviarEmail(View view) {
        Toast.makeText(this, "Senha para alterção enviada com sucesso!", Toast.LENGTH_SHORT).show();
        Intent it = new Intent(this, TrocarSenha.class);
        startActivity(it);
    }
}

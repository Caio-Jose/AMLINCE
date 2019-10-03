package br.com.fiap.lince;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class TrocarSenha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trocar_senha);
    }


    public void trocarSenha(View view) {
        Toast.makeText(this, "Senha alterada com sucesso!", Toast.LENGTH_SHORT).show();
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}

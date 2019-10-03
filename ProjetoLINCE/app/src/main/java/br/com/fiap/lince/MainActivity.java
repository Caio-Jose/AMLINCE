package br.com.fiap.lince;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    /*private void mostrarTelaPrincipal() {
        Intent intent = new Intent(MainActivity.this, SplashScreen.class);
        startActivity(intent);
        finish();
    }*/


    public void telaPrincipal(View view) {
        Intent it = new Intent(this, TelaPrincipal.class);
        startActivity(it);
    }

    public void esqueciSenha(View view) {
        Intent it = new Intent(this, EsqueciSenha.class);
        startActivity(it);
    }

    public void cadastrar(View view) {
        Intent it = new Intent(this, Cadastrar.class);
        startActivity(it);
    }


}

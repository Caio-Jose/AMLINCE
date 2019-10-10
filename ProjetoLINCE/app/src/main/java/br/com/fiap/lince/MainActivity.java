package br.com.fiap.lince;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtSenha;
    EditText edtUsuario;
    UsuarioDB usuarioDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usuarioDB = new UsuarioDB(this);
        setContentView(R.layout.activity_main);
        edtUsuario = findViewById(R.id.usuario);
        edtSenha = findViewById(R.id.senha);
    }

    /*private void mostrarTelaPrincipal() {
        Intent intent = new Intent(MainActivity.this, SplashScreen.class);
        startActivity(intent);
        finish();
    }*/


    public void telaPrincipal(View view) {
        Intent it = new Intent(this, TelaPrincipal.class);
        String senha = edtSenha.getText().toString();
        String username = edtUsuario.getText().toString();
        Usuario usuario = usuarioDB.findByUsuarioSenha(username,senha);
        it.putExtra("usuario", usuario);
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


    public void login(View view) {


    }
}

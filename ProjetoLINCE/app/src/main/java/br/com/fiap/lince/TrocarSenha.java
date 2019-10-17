package br.com.fiap.lince;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TrocarSenha extends AppCompatActivity {

    UsuarioDB usuarioDB;
    Usuario usuario;
    EditText senha;
    EditText confirmaSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trocar_senha);
        senha = findViewById(R.id.senhaNova);
        confirmaSenha = findViewById(R.id.confirmaSenhaNova);
        usuarioDB = new UsuarioDB(this);
        Bundle extras = getIntent().getExtras();
        if( extras == null){
            Intent it = new Intent(this, MainActivity.class);
            Toast.makeText(this, "Usuario não carregado!", Toast.LENGTH_SHORT).show();
            startActivity(it);
        }else {
            usuario = (Usuario) extras.get("usuario");
        }
    }


    public void trocarSenha(View view) {
        if(!senha.getText().toString().equals(confirmaSenha.getText().toString())){
            Toast.makeText(this, "A senha e a confirmação da senhão não batem!", Toast.LENGTH_SHORT).show();
        }else {
            usuario.setSenha(senha.getText().toString());
            usuarioDB.atualizar(usuario);
            Toast.makeText(this, "Senha alterada com sucesso!", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(this, MainActivity.class);
            startActivity(it);
        }
    }
}

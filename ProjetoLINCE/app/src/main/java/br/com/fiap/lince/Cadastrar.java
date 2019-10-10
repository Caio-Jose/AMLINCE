package br.com.fiap.lince;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastrar extends AppCompatActivity {

    UsuarioDB usuarioDB;
    EditText edtNome;
    EditText edtSenha;
    EditText edtEmail;
    EditText edtSobrenome;
    EditText edtConfirmaSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);
        edtNome = findViewById(R.id.edtNome);
        edtSenha = findViewById(R.id.edtSenha);
        edtEmail = findViewById(R.id.edtEmail);
        edtSobrenome = findViewById(R.id.edtSobrenome);
        edtConfirmaSenha = findViewById(R.id.edtConfirmaSenha);
        usuarioDB = new UsuarioDB(this);
    }

    public void cadastro(View view) {
        if(edtSenha.getText().toString() != edtConfirmaSenha.getText().toString()){
            Toast.makeText(this, "A senha e a confirmação da senhão não batem!", Toast.LENGTH_SHORT).show();
            finish();
        }
        Intent it = new Intent(this, MainActivity.class);
        Usuario usuario = new Usuario();
        usuario.setNome(edtNome.getText().toString() + " " + edtSobrenome.getText().toString());
        usuario.setSenha(edtSenha.getText().toString());
        usuario.setEmail(edtEmail.getText().toString());
        usuarioDB.inserir(usuario);
        Toast.makeText(this, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        startActivity(it);
    }
}

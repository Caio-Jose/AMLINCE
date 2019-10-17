package br.com.fiap.lince;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cadastrar extends AppCompatActivity {

    UsuarioDB usuarioDB;
    EditText edtNome;
    EditText edtSenha;
    EditText edtEmail;
    Button btnCadastrar;
    EditText edtConfirmaSenha;
    Usuario atualizarusuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        edtNome = findViewById(R.id.edtNome);
        edtSenha = findViewById(R.id.edtSenha);
        edtEmail = findViewById(R.id.edtEmail);
        edtConfirmaSenha = findViewById(R.id.edtConfirmaSenha);
        usuarioDB = new UsuarioDB(this);

        Bundle extras = getIntent().getExtras();
        if( extras !=null){
            atualizarusuario = (Usuario)extras.get("usuario");
            if ( atualizarusuario!= null ) {
                edtNome.setText( atualizarusuario.getNome());
                edtSenha.setText(atualizarusuario.getSenha());
                edtConfirmaSenha.setText(atualizarusuario.getSenha());
                edtEmail.setText(atualizarusuario.getEmail());
                btnCadastrar.setText("Editar");
            }
        }
    }

    public void cadastro(View view) {
        String senha = edtSenha.getText().toString();
        String confirmaSenha = edtConfirmaSenha.getText().toString();

        if(!senha.equals(confirmaSenha)){
            Toast.makeText(this, "A senha e a confirmação da senhão não batem!", Toast.LENGTH_SHORT).show();
        }else {
            if (atualizarusuario != null) {
                Intent it = new Intent(this, TelaPrincipal.class);

                atualizarusuario.setSenha(edtSenha.getText().toString());
                atualizarusuario.setEmail(edtEmail.getText().toString());
                atualizarusuario.setNome(edtNome.getText().toString());
                usuarioDB.atualizar(atualizarusuario);
                Toast.makeText(this, "Usuário Atualizado com sucesso!", Toast.LENGTH_SHORT).show();
                it.putExtra("usuario", atualizarusuario);
                startActivity(it);

            } else {
                if(usuarioDB.findByEmail(edtEmail.getText().toString())==null) {
                    Intent it = new Intent(this, MainActivity.class);
                    Usuario usuario = new Usuario();
                    usuario.setNome(edtNome.getText().toString());
                    usuario.setSenha(edtSenha.getText().toString());
                    usuario.setEmail(edtEmail.getText().toString());
                    usuarioDB.inserir(usuario);
                    Toast.makeText(this, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                    startActivity(it);
                }else{
                    Toast.makeText(this, "Já existe usuário cadastrado com esse email!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}

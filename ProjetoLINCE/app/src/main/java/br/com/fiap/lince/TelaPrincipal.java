package br.com.fiap.lince;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TelaPrincipal extends AppCompatActivity {

    Usuario usuario;
    TextView txvNameUser;
    TextView txvSaldo;
    UsuarioDB usuarioDB;
    Double creditado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);
        txvNameUser = findViewById(R.id.nameUser);
        txvSaldo = findViewById(R.id.saldo);
        usuarioDB = new UsuarioDB(this);

        Bundle extras = getIntent().getExtras();
        if( extras == null){
            Intent it = new Intent(this, MainActivity.class);
            Toast.makeText(this, "Usuario não carregado!", Toast.LENGTH_SHORT).show();
            startActivity(it);
        }else{
            usuario = (Usuario)extras.get("usuario");
            if ( usuario!= null ) {
                txvNameUser.setText( usuario.getNome());
                txvSaldo.setText(usuario.getSaldo().toString());
                usuarioDB.atualizar(usuario);
            }
        }

    }

    public void adicionarCredito(View view) {
        Intent it = new Intent(this, AddCredito.class);
        it.putExtra("usuario",usuario);
        startActivity(it);
    }

    public void menuOpcoes(View view) {
        Intent it = new Intent(this, menu_opcoes.class);
        it.putExtra("usuario",usuario);
        startActivity(it);
    }
}

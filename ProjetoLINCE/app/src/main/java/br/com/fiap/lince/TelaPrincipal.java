package br.com.fiap.lince;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TelaPrincipal extends AppCompatActivity {

    Usuario usuario;
    EditText edtNameUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        Bundle extras = getIntent().getExtras();
        if( extras == null){
            Intent it = new Intent(this, MainActivity.class);
            Toast.makeText(this, "Usuario não carregado!", Toast.LENGTH_SHORT).show();
            startActivity(it);
        }else{
            usuario = (Usuario)extras.get("usuario");
            if ( usuario!= null ) {
                edtNameUser.setText( usuario.getNome() );
            }
        }

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

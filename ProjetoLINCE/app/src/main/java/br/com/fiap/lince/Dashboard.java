package br.com.fiap.lince;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    TextView txvNome;
    TextView txvSaldo;
    Usuario usuario;
    Bilhete bilhete;
    BilheteDB bilheteDB;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        txvSaldo = findViewById(R.id.saldo);
        bilheteDB = new BilheteDB(this);

        Bundle extras = getIntent().getExtras();
        if( extras == null){
            Intent it = new Intent(this, MainActivity.class);
            Toast.makeText(this, "Usuario não carregado!", Toast.LENGTH_SHORT).show();
            startActivity(it);
        }else{
            usuario = (Usuario)extras.get("usuario");
            if ( usuario != null ) {
                txvNome.setText( usuario.getNome() );
            }
        }
        if(usuario.getBilhete()!=null) {
            bilhete = usuario.getBilhete();
        }else{
            bilhete.setDescricacao("Bilhete do "+usuario.getNome());
            bilhete.setSaldo(0.00);
            bilhete.setTipo(TipoBilhete.COMUM);
            bilheteDB.inserir(bilhete);
        }

        if(extras.get("aumentaSaldo") != null){
            bilhete.setSaldo(bilhete.getSaldo()+(Double)extras.get("aumentaSaldo"));
        }

        txvSaldo.setText(bilhete.getSaldo().toString());
    }

    public void exit(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

    public void carregarBilhete(View view) {
        Intent it = new Intent(this, AddCredito.class);
        startActivity(it);
    }
}

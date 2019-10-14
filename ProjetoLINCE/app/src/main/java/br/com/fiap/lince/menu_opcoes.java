package br.com.fiap.lince;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class menu_opcoes extends AppCompatActivity{
    Usuario usuario;
    UsuarioDB usuarioDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuopcoes);
        usuarioDB = new UsuarioDB(this);


        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Intent it = new Intent(this, MainActivity.class);
            Toast.makeText(this, "Usuario não carregado!", Toast.LENGTH_SHORT).show();
            startActivity(it);
        } else {
            usuario = (Usuario) extras.get("usuario");

        }
    }

    public void voltarATelaPrincipal(View view) {
        Intent it = new Intent(this, TelaPrincipal.class);
        it.putExtra("usuario", usuario);
        startActivity(it);
    }

    public void deslogar(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

    public void apagarUsuario(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Apagar Usuario")
                .setMessage("Deseja realmente apagar este usuário?" + "Você possui um saldo de R$"+ usuario.getSaldo().toString())
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // continue with delete
                usuarioDB.excluir(usuario.getId());
                Intent it = new Intent( getApplicationContext(),MainActivity.class);
                startActivity(it);
            }
        })
    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // do nothing
            }
        })
    .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void atualizarUsuario(View view) {
        Intent it = new Intent( getApplicationContext(),Cadastrar.class);
        it.putExtra("usuario",usuario);
        startActivity(it);
    }

    public void listarCompra(View view) {
        Intent it = new Intent( getApplicationContext(),ListarCompras.class);
        it.putExtra("usuario",usuario);
        startActivity(it);
    }
}

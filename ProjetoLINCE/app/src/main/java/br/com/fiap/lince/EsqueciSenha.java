package br.com.fiap.lince;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EsqueciSenha extends AppCompatActivity {

    EditText email;
    UsuarioDB usuarioDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.esqueci_senha);
        usuarioDB = new UsuarioDB(this);
        email = findViewById(R.id.emailTrocar);
    }

    public void enviarEmail(View view) {
        Usuario usuario = usuarioDB.findByEmail(email.getText().toString());
        if(usuario!=null) {
            Toast.makeText(this, "Email para alterção enviada com sucesso!", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(this, TrocarSenha.class);

            it.putExtra("usuario", usuario);
            startActivity(it);
        }else{
            Toast.makeText(this, "Usuario com esse email não existe!", Toast.LENGTH_SHORT).show();
        }
    }
}

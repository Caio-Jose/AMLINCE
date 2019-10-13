package br.com.fiap.lince;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddCredito extends AppCompatActivity {

    EditText edtSaldo;
    Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_credito);
        edtSaldo = findViewById(R.id.valorCredito);
        Bundle extras = getIntent().getExtras();
        if( extras == null){
            Intent it = new Intent(this, MainActivity.class);
            Toast.makeText(this, "Erro!", Toast.LENGTH_SHORT).show();
            startActivity(it);
        }else{
            usuario = (Usuario)extras.get("usuario");
        }
    }

    public void efetuarPagamento(View view) {
        Toast.makeText(this, "Pagamento aprovado", Toast.LENGTH_SHORT).show();
        Intent it = new Intent(this, TelaPrincipal.class);
        usuario.setSaldo(Double.parseDouble(edtSaldo.getText().toString()) + usuario.getSaldo());
        it.putExtra("usuario", usuario);
        startActivity(it);
    }
}

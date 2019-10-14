package br.com.fiap.lince;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class AddCredito extends AppCompatActivity {

    EditText edtSaldo;
    Usuario usuario;
    CompraDB compraDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_credito);
        compraDB = new CompraDB(this);
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
        Intent it = new Intent(this, TelaPrincipal.class);
        it.putExtra("usuario", usuario);

        try{
            Compra compra = new Compra();
            compra.setIdUsuario(usuario.getId());
            compra.setValor(Double.parseDouble(edtSaldo.getText().toString()));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            compra.setDataCompra(formatter.format(date));
            compraDB.inserir(compra);
            Toast.makeText(this, "Pagamento aprovado", Toast.LENGTH_SHORT).show();
            usuario.setSaldo(Double.parseDouble(edtSaldo.getText().toString()) + usuario.getSaldo());
            startActivity(it);
        }catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Ocorreu um erro na compra", Toast.LENGTH_SHORT).show();
            startActivity(it);
            this.finish();
        }

    }
}

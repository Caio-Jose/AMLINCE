package br.com.fiap.lince;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddCredito extends AppCompatActivity {

    EditText edtSaldo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_credito);
        edtSaldo = findViewById(R.id.qtdeCredito);
    }

    public void efetuarPagamento(View view) {
        Toast.makeText(this, "Pagamento aprovado", Toast.LENGTH_SHORT).show();
        Intent it = new Intent(this, Dashboard.class);
        it.putExtra("aumentaSaldo", edtSaldo.getText().toString());
        startActivity(it);
    }
}

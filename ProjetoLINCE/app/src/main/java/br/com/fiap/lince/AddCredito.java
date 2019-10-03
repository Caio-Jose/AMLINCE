package br.com.fiap.lince;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class AddCredito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_credito);
    }

    public void efetuarPagamento(View view) {
        Toast.makeText(this, "Pagamento aprovado", Toast.LENGTH_SHORT).show();
    }
}

package br.com.fiap.lince;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ListarCompras extends AppCompatActivity {

    ListView lstCompras;
    List<Compra> compraList;
    CompraDB compraDB;
    Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compras);

        lstCompras = findViewById(R.id.lstCompras);
        compraDB = new CompraDB(this);

        Bundle extras = getIntent().getExtras();
        if( extras == null){
            Intent it = new Intent(this, MainActivity.class);
            Toast.makeText(this, "Usuario não carregado!", Toast.LENGTH_SHORT).show();
            startActivity(it);
        }else{
            usuario = (Usuario)extras.get("usuario");
            if ( usuario!= null ) {

                compraList = compraDB.listarCompras(usuario.getId());
                Compra[] compras = compraList.toArray(new Compra[compraList.size()]);
                CompraAdapter adapter = new CompraAdapter(this, compras);
                lstCompras.setAdapter(adapter);
            }
        }




    }



}

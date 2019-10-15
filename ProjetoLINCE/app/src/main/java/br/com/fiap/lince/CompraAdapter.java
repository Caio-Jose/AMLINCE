package br.com.fiap.lince;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CompraAdapter extends BaseAdapter {

    private Context context;
    private Compra[] compras;

    public CompraAdapter(Context context, Compra[] compras) {
        this.context = context;
        this.compras = compras;
    }

    @Override
    public int getCount() {
        return this.compras.length;
    }

    @Override
    public Object getItem(int i) {
        return this.compras[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View v = inflater.inflate(R.layout.listview_compra, viewGroup, false);

        TextView txvData = v.findViewById(R.id.dtCompra);
        TextView txvValor = v.findViewById(R.id.txtValor);

        Compra compra = this.compras[i];

        txvData.setText(compra.getDataCompra());
        txvValor.setText(compra.getValor().toString());
        return v;
    }
}

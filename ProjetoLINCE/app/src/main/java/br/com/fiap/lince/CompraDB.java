package br.com.fiap.lince;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CompraDB extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "CompraDB";
    public static final int DATABASE_VERSION = 1;
    public static final String TB_COMPRA    = "compra";


    public CompraDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TB_COMPRA + " (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "idUsuario INTEGER NOT NULL," +
                "dataCompra Text NOT NULL UNIQUE," +
                "valor DOUBLE NOT NULL" +
                ")";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS compra");

        // create fresh books table
        this.onCreate(db);
    }

    public void inserir(Compra compra) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("idUsuario", compra.getId());
        cv.put("dataCompra", compra.getDataCompra());
        cv.put("valor",compra.getValor());

        db.insert(TB_COMPRA, null, cv);
    }

    public void excluir(int id) {
        SQLiteDatabase db = getWritableDatabase();

        db.delete(
                TB_COMPRA,
                "id = ?",
                new String[]{  String.valueOf(id) }
        );
    }

    public void atualizar(Compra compra) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("idUsuario", compra.getId());
        cv.put("dataCompra", compra.getDataCompra());
        cv.put("valor",compra.getValor());


        db.update(
                TB_COMPRA,
                cv,
                "id = ?",
                new String[] { String.valueOf( compra.getId() ) }
        );
    }

    public List<Compra> listarCompras(int usuarioId) {
        List<Compra> compras = new ArrayList<>();

        String selection = "idUsuario = ?";
        String[] selectionArgs = {Integer.toString(usuarioId)};
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TB_COMPRA+" WHERE idUsuario = ?";


        Cursor cursor = db.rawQuery(query,selectionArgs);


        cursor.moveToFirst();

        try{
            if ( cursor.moveToFirst() ) {
                do {
                    Compra compra = new Compra();
                    compra.setId( cursor.getInt( 0 )  );
                    compra.setIdUsuario( cursor.getInt( 1 ));
                   compra.setDataCompra( cursor.getString( 2 ));
                   compra.setValor(cursor.getDouble(3));

                   compras.add( compra );
                } while( cursor.moveToNext() );
            }
        }catch (Exception e){
            return null;
        }

        return compras;
    }
}

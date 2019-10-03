package br.com.fiap.lince;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BilheteDB extends SQLiteOpenHelper {

    public BilheteDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public static final String DATABASE_NAME = "BilheteDB";
    public static final int DATABASE_VERSION = 1;
    public static final String TB_BILHETE    = "bilhete";
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TB_BILHETE + " (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "descricacao TEXT," +
                "saldo REAL NOT NULL," +
                "tipo TEXT NOT NULL" +
                ")";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inserir(Bilhete bilhete) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("descricacao", bilhete.getDescricacao());
        cv.put("saldo", bilhete.getSaldo().toString());
        cv.put("tipo",bilhete.getTipo().toString());
        db.insert(TB_BILHETE, null, cv);
    }

    public void excluir(int id) {
        SQLiteDatabase db = getWritableDatabase();

        db.delete(
                TB_BILHETE,
                "id = ?",
                new String[]{  String.valueOf(id) }
        );
    }

    public void atualizar(Bilhete bilhete) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("descricacao", bilhete.getDescricacao());
        cv.put("saldo", bilhete.getSaldo().toString());
        cv.put("tipo",bilhete.getTipo().toString());

        db.update(
                TB_BILHETE,
                cv,
                "id = ?",
                new String[] { String.valueOf( bilhete.getId() ) }
        );
    }

    public List<Bilhete> listarBilhete() {
        List<Bilhete> bilhetes = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                TB_BILHETE,
                new String[] {"id", "descricacao", "saldo","tipo"},
                null,
                null,
                null,
                null,
                "saldo"
        );

        cursor.moveToFirst();


        if ( cursor.moveToFirst() ) {
            do {
                Bilhete bilhete = new Bilhete();
                bilhete.setId( cursor.getInt( 0 )  );
                bilhete.setDescricacao( cursor.getString( 1 ) );
                bilhete.setSaldo( cursor.getDouble( 2 ) );
                bilhete.setTipo(TipoBilhete.valueOf(cursor.getString(3)));
                bilhetes.add( bilhete );
            } while( cursor.moveToNext() );
        }

        return bilhetes;
    }

    public Bilhete buscar(int id){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                TB_BILHETE,
                new String[] {"id", "descricacao", "saldo","tipo"},
                null,
                null,
                null,
                "id",
                "saldo"
        );
        Bilhete bilhete = new Bilhete();

        if ( cursor.moveToFirst() ) {
                bilhete.setId( cursor.getInt( 0 )  );
                bilhete.setDescricacao( cursor.getString( 1 ) );
                bilhete.setSaldo( cursor.getDouble( 2 ) );
                bilhete.setTipo(TipoBilhete.valueOf(cursor.getString(3)));
        }
        return bilhete;
    }
}

package br.com.fiap.lince;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDB extends SQLiteOpenHelper {

    public UsuarioDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public static final String DATABASE_NAME = "UsuarioDB";
    public static final int DATABASE_VERSION = 3;
    public static final String TB_USUARIO    = "usuario";
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TB_USUARIO + " (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "email Text NOT NULL UNIQUE," +
                "senha TEXT NOT NULL," +
                "saldo DOUBLE" +
                ")";

        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS usuario");

        // create fresh books table
        this.onCreate(db);
    }

    public void inserir(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nome", usuario.getNome());
        cv.put("email",usuario.getEmail());
        cv.put("senha",usuario.getSenha());
        cv.put("saldo", usuario.getSaldo());
        db.insert(TB_USUARIO, null, cv);
    }

    public void excluir(int id) {
        SQLiteDatabase db = getWritableDatabase();

        db.delete(
                TB_USUARIO,
                "id = ?",
                new String[]{  String.valueOf(id) }
        );
    }

    public void atualizar(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nome", usuario.getNome());
        cv.put("email",usuario.getEmail());
        cv.put("senha",usuario.getSenha());
        cv.put("saldo", usuario.getSaldo());


        db.update(
                TB_USUARIO,
                cv,
                "id = ?",
                new String[] { String.valueOf( usuario.getId() ) }
        );
    }

    public List<Usuario> listarUsuario() {
        List<Usuario> usuarios = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(
                TB_USUARIO,
                new String[] {"id", "nome", "email","senha","saldo"},
                null,
                null,
                null,
                null,
                "nome"
        );

        cursor.moveToFirst();


        if ( cursor.moveToFirst() ) {
            do {
                Usuario usuario = new Usuario();
                usuario.setId( cursor.getInt( 0 )  );
                usuario.setNome( cursor.getString( 1 ));
                usuario.setEmail( cursor.getString( 2 ));
                usuario.setSenha(cursor.getString(3));
                usuario.setSaldo(cursor.getDouble(4));
                usuarios.add( usuario );
            } while( cursor.moveToNext() );
        }

        return usuarios;
    }

    public Usuario findByUsuarioSenha(String email, String senha) {

        String selection = "email = ? and senha = ?";
        String[] selectionArgs = {email,senha};
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                TB_USUARIO,
                new String[] {"id", "nome", "email","senha","saldo"},
                selection,
                selectionArgs,
                null,
                null,
                "nome"
        );
        cursor.moveToFirst();
        Usuario usuario = new Usuario();
        try {
            do {
                usuario.setId(cursor.getInt(0));
                usuario.setNome(cursor.getString(1));
                usuario.setEmail(cursor.getString(2));
                usuario.setSenha(cursor.getString(3));
                usuario.setSaldo(cursor.getDouble(4));
                return usuario;
            } while (cursor.moveToNext());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Usuario findByEmail(String email) {

        String selection = "email = ?";
        String[] selectionArgs = {email};
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                TB_USUARIO,
                new String[] {"id", "nome", "email","senha","saldo"},
                selection,
                selectionArgs,
                null,
                null,
                "nome"
        );
        cursor.moveToFirst();
        Usuario usuario = new Usuario();
        try {
            do {
                usuario.setId(cursor.getInt(0));
                usuario.setNome(cursor.getString(1));
                usuario.setEmail(cursor.getString(2));
                usuario.setSenha(cursor.getString(3));
                usuario.setSaldo(cursor.getDouble(4));
                return usuario;
            } while (cursor.moveToNext());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

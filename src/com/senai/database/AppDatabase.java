package com.senai.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AppDatabase {

	private final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "jogosenha.db";
	
	public static final String TABELA_JOGADOR  = "jogador";

	public static final String COLUNA_ID 	   = "_id";
	public static final String COLUNA_EMAIL    = "email";
	public static final String COLUNA_VITORIAS = "vitorias";
	public static final String COLUNA_DERROTAS = "derrotas";
	
	private static final String DATABASE_CREATE = "create table " + TABELA_JOGADOR + "( " 
			+ COLUNA_ID    	  + " integer primary key autoincrement, " 
			+ COLUNA_EMAIL 	  + " text not null, "
			+ COLUNA_VITORIAS + " integer not null, "
			+ COLUNA_DERROTAS + " integer not null "
			+ ");";

	private SQLiteDatabase database;
	private DatabaseHelper dbHelper;

	public AppDatabase(Context context) {
		this.dbHelper = new DatabaseHelper(context);
		this.database = dbHelper.getWritableDatabase();
	}

	public SQLiteDatabase getDatabase() {
		return database;
	}
	
	public void closeConnection() {
		dbHelper.close();
	}
	
	class DatabaseHelper extends SQLiteOpenHelper {

		public DatabaseHelper(Context ctx) {
			super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DATABASE_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w("APP DATABASE", "Atualizando banco de dados da versão " + oldVersion + " para versão " + newVersion + ". Todos os dados serão perdidos");
			db.execSQL("DROP TABLE IF EXISTS " + TABELA_JOGADOR);
			onCreate(db);
		}
	}
}

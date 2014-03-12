package com.senai.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AppDatabase {

	private final int DATABASE_VERSION = 1;

	private static final String DATABASE_NAME = "jogosenha.db";

	private SQLiteDatabase database;
	private DatabaseHelper dbHelper;

	public AppDatabase(Context context) {
		this.dbHelper = new DatabaseHelper(context);
		this.database = dbHelper.getWritableDatabase();
	}

	public SQLiteDatabase getDatabase() {
		return database;
	}

	class DatabaseHelper extends SQLiteOpenHelper {

		public DatabaseHelper(Context ctx) {
			super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE ranking(id INTEGER, email TEXT, vitorias INTEGER, derrotas INTEGER, PRIMARY KEY(id ASC));");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//			db.execSQL("script delete...");
//			db.execSQL("script create...");
		}

	}

}

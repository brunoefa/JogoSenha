package com.senai.database;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.senai.entidade.Jogador;

public class JogadorDatabaseDao {

	private SQLiteDatabase database;
	private AppDatabase dbHelper;
	private String[] colunas = { AppDatabase.COLUNA_ID,
								 AppDatabase.COLUNA_EMAIL, 
								 AppDatabase.COLUNA_VITORIAS,
								 AppDatabase.COLUNA_DERROTAS };

	public JogadorDatabaseDao(Context context) {
		dbHelper = new AppDatabase(context);
		database = dbHelper.getDatabase();
	}

	public void open() throws SQLException {
		database = dbHelper.getDatabase();
	}

	public void close() {
		dbHelper.closeConnection();
	}

	public Jogador salvar(Jogador j) {
		Jogador novoJogador = null;
		ContentValues values = new ContentValues();

		values.put(AppDatabase.COLUNA_EMAIL, j.getEmail());
		values.put(AppDatabase.COLUNA_VITORIAS, j.getVitorias());
		values.put(AppDatabase.COLUNA_DERROTAS, j.getDerrotas());

		long insertId = database.insert(AppDatabase.TABELA_JOGADOR, null, values);
		Cursor cursor = database.query(AppDatabase.TABELA_JOGADOR, colunas,
									   AppDatabase.COLUNA_ID + " = " + insertId, 
									   null, null, null, null);

		if (cursor.moveToFirst()) {
			novoJogador = cursorToJogador(cursor);
		} 
		cursor.close();
		return novoJogador;
	}

	public void deletar(Jogador jogador) {
		database.delete(AppDatabase.TABELA_JOGADOR, AppDatabase.COLUNA_ID + " = ?", new String[]{String.valueOf(jogador.getId())});
	}

	public ArrayList<Jogador> buscarTodos() {
		ArrayList<Jogador> listaJogadores = new ArrayList<Jogador>();

		Cursor cursor = database.query(AppDatabase.TABELA_JOGADOR, colunas,
									   null, null, null, null, null);
		
		if (cursor.moveToFirst()) {
			while (!cursor.isAfterLast()) {
				Jogador j = cursorToJogador(cursor);
				listaJogadores.add(j);
				cursor.moveToNext();
			}
		}
		
		cursor.close();
		return listaJogadores;
	}

	public Jogador buscarPorEmail(String email) {
		Jogador j = null;
		Cursor cursor = database.query(AppDatabase.TABELA_JOGADOR, colunas,
									   AppDatabase.COLUNA_EMAIL + " = ?", new String[] { email },
									   null, null, null);

		if (cursor.moveToFirst()) {
			j = cursorToJogador(cursor);
		}
		cursor.close();
		return j;

	}

	public Jogador buscar(Integer id) {
		Jogador j = null;
		Cursor cursor = database.query(AppDatabase.TABELA_JOGADOR, colunas,
									   AppDatabase.COLUNA_ID + " = ?", new String[] { String.valueOf(id) }, 
									   null, null, null);

		if (cursor.moveToFirst()) {
			j = cursorToJogador(cursor);
		}
		cursor.close();
		return j;
	}
	
	
	public Jogador atualizar(Jogador j) {
		ContentValues values = new ContentValues();

		values.put(AppDatabase.COLUNA_EMAIL, j.getEmail());
		values.put(AppDatabase.COLUNA_VITORIAS, j.getVitorias());
		values.put(AppDatabase.COLUNA_DERROTAS, j.getDerrotas());

		long insertId = database.update(AppDatabase.TABELA_JOGADOR, values, AppDatabase.COLUNA_ID + " = ?", new String[] {String.valueOf(j.getId())});
		Cursor cursor = database.query(AppDatabase.TABELA_JOGADOR, colunas,
									   AppDatabase.COLUNA_ID + " = " + insertId, 
									   null, null, null, null);

		cursor.moveToFirst();
		Jogador novoJogador = cursorToJogador(cursor);
		cursor.close();
		return novoJogador;
	}
	
	private Jogador cursorToJogador(Cursor cursor) {
		Jogador j = new Jogador();

		j.setId(cursor.getLong(0));
		j.setEmail(cursor.getString(1));
		j.setVitorias(cursor.getInt(2));
		j.setDerrotas(cursor.getInt(3));

		return j;
	}
}

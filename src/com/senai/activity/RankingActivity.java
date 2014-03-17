package com.senai.activity;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.senai.adapter.AdapterJogadorListView;
import com.senai.database.JogadorDatabaseDao;
import com.senai.entidade.Jogador;
import com.senai.jogosenha.R;

public class RankingActivity extends Activity {

	private ListView rankingListView;
	private AdapterJogadorListView adapterJogadorListView;
	private ArrayList<Jogador> jogadorList;
//	private JogadorMemoryDao jogadorDao = JogadorMemoryDao.getInstance();
	private JogadorDatabaseDao jogadorDao;
	
	private String email;
	private int vitorias = 0;
	private int derrotas = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ranking);
		jogadorDao = new JogadorDatabaseDao(this);
		rankingListView = (ListView) findViewById(R.id.lv_ranking);
		obtemResultado();
		insereJogador();
		createListView();
	}

	private void insereJogador() {
		Jogador jogador = jogadorDao.buscarPorEmail(email);
		if (jogador == null) {
			jogador = new Jogador(email, vitorias, derrotas);
			jogadorDao.salvar(jogador);
		} else {
			jogador.setDerrotas(jogador.getDerrotas() + derrotas);
			jogador.setVitorias(jogador.getVitorias() + vitorias);
			jogadorDao.atualizar(jogador);
		}
	}
	
	public void obtemResultado(){
		Intent intent = getIntent();
		email = intent.getStringExtra("email");
		boolean resultado = intent.getBooleanExtra("resultado", false);
		if (resultado) {
			vitorias++;
		}else {
			derrotas++;
		}
	}
	
	public ArrayList<Jogador> ordenaRanking(ArrayList<Jogador> listaJogadores) {
		int posicao = 1; 

		Collections.sort(listaJogadores);
		ArrayList<Jogador> listaPosicionada = new ArrayList<Jogador>();

		for (Jogador jogador : listaJogadores) {
			jogador.setPosicao(posicao);
			listaPosicionada.add(jogador);
			posicao++;
		}
		return listaPosicionada;
	}

	private void createListView() {
		jogadorList = jogadorDao.buscarTodos();
		
		ArrayList<Jogador> listaOrdenada = ordenaRanking(jogadorList);

		adapterJogadorListView = new AdapterJogadorListView(this, listaOrdenada);
		rankingListView.setAdapter(adapterJogadorListView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.ranking, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.jogar_novamente:
			reiniciarJogo();
			return true;
		}
		return false;
	}

	private void reiniciarJogo() {
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}
	
	public ArrayList<Jogador> ordenaaRanking(ArrayList<Jogador> listaJogadores) {
		Collections.sort(listaJogadores);
		
		ArrayList<Jogador> listaPosicionada = new ArrayList<Jogador>();
		int posicao = 1;
		
		for (Jogador j : listaJogadores) {
			j.setPosicao(posicao);
			listaPosicionada.add(j);
			posicao++;
		}
		
		return listaPosicionada;
	}

}

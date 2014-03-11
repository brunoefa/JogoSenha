package com.senai.jogosenha;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class RankingActivity extends Activity {

	private ListView rankingListView;
	private AdapterJogadorListView adapterJogadorListView;
	private ArrayList<Jogador> jogadorList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ranking);
		rankingListView = (ListView) findViewById(R.id.lv_ranking);
		createListView();
	}

	private void createListView() {
		jogadorList = new ArrayList<Jogador>();

		jogadorList.add(new Jogador(1, "bruno@gmail.com", 10, 5));
		jogadorList.add(new Jogador(2, "joao@gmail.com", 9, 7));
		jogadorList.add(new Jogador(3, "maria@gmail.com", 7, 8));
		jogadorList.add(new Jogador(4, "jose@gmail.com", 5, 2));
		jogadorList.add(new Jogador(5, "manuel@gmail.com", 3, 6));
		jogadorList.add(new Jogador(6, "juca@gmail.com", 0, 44));
		jogadorList.add(new Jogador(7, "geronimo@gmail.com", 0, 233));
		jogadorList.add(new Jogador(1, "bruno@gmail.com", 10, 5));
		jogadorList.add(new Jogador(2, "joao@gmail.com", 9, 7));
		jogadorList.add(new Jogador(3, "maria@gmail.com", 7, 8));
		jogadorList.add(new Jogador(4, "jose@gmail.com", 5, 2));
		jogadorList.add(new Jogador(5, "manuel@gmail.com", 3, 6));
		jogadorList.add(new Jogador(6, "juca@gmail.com", 0, 44));
		jogadorList.add(new Jogador(7, "geronimo@gmail.com", 0, 233));
		jogadorList.add(new Jogador(1, "bruno@gmail.com", 10, 5));
		jogadorList.add(new Jogador(2, "joao@gmail.com", 9, 7));
		jogadorList.add(new Jogador(3, "maria@gmail.com", 7, 8));
		jogadorList.add(new Jogador(4, "jose@gmail.com", 5, 2));
		jogadorList.add(new Jogador(5, "manuel@gmail.com", 3, 6));
		jogadorList.add(new Jogador(6, "juca@gmail.com", 0, 44));
		jogadorList.add(new Jogador(7, "geronimo@gmail.com", 0, 233));
		jogadorList.add(new Jogador(1, "bruno@gmail.com", 10, 5));
		jogadorList.add(new Jogador(2, "joao@gmail.com", 9, 7));
		jogadorList.add(new Jogador(3, "maria@gmail.com", 7, 8));
		jogadorList.add(new Jogador(4, "jose@gmail.com", 5, 2));
		jogadorList.add(new Jogador(5, "manuel@gmail.com", 3, 6));
		jogadorList.add(new Jogador(6, "juca@gmail.com", 0, 44));
		jogadorList.add(new Jogador(7, "geronimo@gmail.com", 0, 233));
		jogadorList.add(new Jogador(1, "bruno@gmail.com", 10, 5));
		jogadorList.add(new Jogador(2, "joao@gmail.com", 9, 7));
		jogadorList.add(new Jogador(3, "maria@gmail.com", 7, 8));
		jogadorList.add(new Jogador(4, "jose@gmail.com", 5, 2));
		jogadorList.add(new Jogador(5, "manuel@gmail.com", 3, 6));
		jogadorList.add(new Jogador(6, "juca@gmail.com", 0, 44));
		jogadorList.add(new Jogador(7, "geronimo@gmail.com", 0, 233));
		jogadorList.add(new Jogador(1, "bruno@gmail.com", 10, 5));
		jogadorList.add(new Jogador(2, "joao@gmail.com", 9, 7));
		jogadorList.add(new Jogador(3, "maria@gmail.com", 7, 8));
		jogadorList.add(new Jogador(4, "jose@gmail.com", 5, 2));
		jogadorList.add(new Jogador(5, "manuel@gmail.com", 3, 6));
		jogadorList.add(new Jogador(6, "juca@gmail.com", 0, 44));
		jogadorList.add(new Jogador(7, "geronimo@gmail.com", 0, 233));
		jogadorList.add(new Jogador(1, "bruno@gmail.com", 10, 5));
		jogadorList.add(new Jogador(2, "joao@gmail.com", 9, 7));
		jogadorList.add(new Jogador(3, "maria@gmail.com", 7, 8));
		jogadorList.add(new Jogador(4, "jose@gmail.com", 5, 2));
		jogadorList.add(new Jogador(5, "manuel@gmail.com", 3, 6));
		jogadorList.add(new Jogador(6, "juca@gmail.com", 0, 44));
		jogadorList.add(new Jogador(7, "geronimo@gmail.com", 0, 233));
		jogadorList.add(new Jogador(1, "bruno@gmail.com", 10, 5));
		jogadorList.add(new Jogador(2, "joao@gmail.com", 9, 7));
		jogadorList.add(new Jogador(3, "maria@gmail.com", 7, 8));
		jogadorList.add(new Jogador(4, "jose@gmail.com", 5, 2));
		jogadorList.add(new Jogador(5, "manuel@gmail.com", 3, 6));
		jogadorList.add(new Jogador(6, "juca@gmail.com", 0, 44));
		jogadorList.add(new Jogador(7, "geronimo@gmail.com", 0, 233));
		jogadorList.add(new Jogador(1, "bruno@gmail.com", 10, 5));
		jogadorList.add(new Jogador(2, "joao@gmail.com", 9, 7));
		jogadorList.add(new Jogador(3, "maria@gmail.com", 7, 8));
		jogadorList.add(new Jogador(4, "jose@gmail.com", 5, 2));
		jogadorList.add(new Jogador(5, "manuel@gmail.com", 3, 6));
		jogadorList.add(new Jogador(6, "juca@gmail.com", 0, 44));
		jogadorList.add(new Jogador(7, "geronimo@gmail.com", 0, 233));

		adapterJogadorListView = new AdapterJogadorListView(this, jogadorList);

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

}

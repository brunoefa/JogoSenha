package com.senai.jogosenha;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class RankingActivity extends Activity {

    private ListView rankingListView;
    private AdapterJogadorListView adapterJogadorListView;
    private ArrayList<Jogador> jogadorList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ranking);
		rankingListView = (ListView) findViewById(R.id.rankingListView);
        createListView();

	}

    private void createListView() {
    	jogadorList = new ArrayList<Jogador>();
        
        jogadorList.add(new Jogador(1, "brunoefa@gmail.com", 5, 0));
        jogadorList.add(new Jogador(2, "joao@gmail.com", 4, 1));
        jogadorList.add(new Jogador(3, "fulano@gmail.com", 3, 4));
        jogadorList.add(new Jogador(4, "faustao@gmail.com", 2, 6));
        jogadorList.add(new Jogador(5, "lepolepo@gmail.com", 1, 9));
        jogadorList.add(new Jogador(6, "cavalinho@gmail.com", 0, 10));
        
        //Cria o adapter
        adapterJogadorListView = new AdapterJogadorListView(this, jogadorList);

        //Define o Adapter na lista
        rankingListView.setAdapter(adapterJogadorListView);

    }

}

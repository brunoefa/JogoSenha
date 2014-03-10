package com.senai.jogosenha;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterJogadorListView extends BaseAdapter {
	
	private LayoutInflater mInflater;
    private List<Jogador> itens;

    public AdapterJogadorListView(Context context, List<Jogador> itens) {
    	this.itens = itens;
    	mInflater = LayoutInflater.from(context);
    }

	@Override
	public int getCount() {
		return itens.size();
	}

	@Override
	public Object getItem(int position) {
		return itens.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		ItemJogadorSupport itemHolder;

		//se a view estiver nula (nunca criada), inflamos o layout nela.
		if (view == null) {
			//infla o layout para podermos pegar as views
			view = mInflater.inflate(R.layout.ranking_item, null);

			//cria um item de suporte para não precisarmos sempre inflar as mesmas informacoes
			itemHolder = new ItemJogadorSupport(); 
			itemHolder.posicao 	= ((TextView) view.findViewById(R.id.tv_posicao)); 
			itemHolder.email 	= ((TextView) view.findViewById(R.id.tv_email)); 
			itemHolder.vitorias = ((TextView) view.findViewById(R.id.tv_vitorias)); 
			itemHolder.derrotas = ((TextView) view.findViewById(R.id.tv_derrotas));

			//define os itens na view;
			view.setTag(itemHolder);
		} else {
			//se a view já existe pega os itens.
			itemHolder = (ItemJogadorSupport) view.getTag();
		}

		//pega os dados da lista e define os valores nos itens.
		Jogador item = itens.get(position);
		itemHolder.posicao.setText(String.valueOf(item.getPosicao()));
		itemHolder.email.setText(item.getEmail());
		itemHolder.vitorias.setText(String.valueOf(item.getVitorias()));
		itemHolder.derrotas.setText(String.valueOf(item.getDerrotas()));

		//retorna a view com as informações
		return view;

	}

	private class ItemJogadorSupport {
		TextView posicao;
		TextView email;
		TextView vitorias;
		TextView derrotas;
	}
}

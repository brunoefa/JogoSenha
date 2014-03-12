package com.senai.database;

import java.util.ArrayList;

import com.senai.entidade.Jogador;

public class JogadorDao {

	private ArrayList<Jogador> listaJogadores = new ArrayList<Jogador>();

	static {
//		JogadorDao dao = new JogadorDao();
//		dao.salvar(new Jogador("joao@gmail.com", 9, 7));
	}

	private JogadorDao() {}

	public ArrayList<Jogador> listarTodos() {
		return listaJogadores;
	}
	
	public void recriarLista(ArrayList<Jogador> listaJogadores) {
		this.listaJogadores = listaJogadores;
	}

	public Jogador buscar(Jogador jogador) {
		for (Jogador j : listaJogadores) {
			if (j.equals(jogador)) {
				return j;
			}
		}
		return null;
	}

	public void salvar(Jogador jogador) {
		jogador.setId(listaJogadores.size());
		listaJogadores.add(jogador);
	}

	public void atualizar(Jogador jogador) {
		Jogador j = buscar(jogador);
		if (j != null) {
			j.setEmail(jogador.getEmail());
			j.setVitorias(jogador.getVitorias());
			j.setDerrotas(jogador.getDerrotas());
		}
	}

	public void remover(Jogador jogador) {
		listaJogadores.remove(jogador);
	}

	public Jogador buscarPorIndice(int indice) {
		if (indice < listaJogadores.size()) {
			return listaJogadores.get(indice);
		}
		return null;
	}
	
	public Jogador buscarPorEmail(String email) {
		for (Jogador j : listaJogadores) {
			if (j.getEmail().equals(email)) {
				return j;
			}
		}
		return null;
	}

	private static JogadorDao instance;

	public static JogadorDao getInstance() {
		if (instance == null) {
			instance = new JogadorDao();
		}
		return instance;
	}
}

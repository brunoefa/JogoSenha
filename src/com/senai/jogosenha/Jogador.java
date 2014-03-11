package com.senai.jogosenha;

public class Jogador implements Comparable<Jogador> {

	private Integer posicao;
	private String email;
	private Integer vitorias;
	private Integer derrotas;

	public Jogador(Integer posicao, String email, Integer vitorias, Integer derrotas) {
		super();
		this.posicao = posicao;
		this.email = email;
		this.vitorias = vitorias;
		this.derrotas = derrotas;
	}	

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getVitorias() {
		return vitorias;
	}

	public void setVitorias(Integer vitorias) {
		this.vitorias = vitorias;
	}

	public Integer getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(Integer derrotas) {
		this.derrotas = derrotas;
	}

	@Override
	public int compareTo(Jogador another) {
		return another.getVitorias().compareTo(this.vitorias);
	}
}
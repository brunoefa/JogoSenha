package com.senai.entidade;

import java.io.Serializable;

public class Jogador implements Comparable<Jogador>, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer posicao;
	private String email;
	private Integer vitorias;
	private Integer derrotas;

	public Jogador(String email, Integer vitorias, Integer derrotas) {
		super();
		this.email = email;
		this.vitorias = vitorias;
		this.derrotas = derrotas;
	}	
	
	public Jogador(Integer id, String email, Integer vitorias, Integer derrotas) {
		super();
		this.id = id;
		this.email = email;
		this.vitorias = vitorias;
		this.derrotas = derrotas;
	}	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
		}
		
		Jogador other = (Jogador) obj;
		if (id == null) {
			if (other.id != null){
				return false;
			}
		} else if (!id.equals(other.id)){
			return false;
		}
		return true;
	}
}
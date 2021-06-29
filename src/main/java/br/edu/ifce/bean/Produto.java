package br.edu.ifce.bean;

import java.util.ArrayList;

public class Produto {

	private int id;
	private String nome;
	private String valor;
	private String imagem;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public boolean check(ArrayList<String> listaCarrinho, String id2) {
		for (String id : listaCarrinho) {
			if (id.equals(id2))
				return true;
		}
		return false;
	}

	public ArrayList<String> remove(ArrayList<String> listaCarrinho, String id) {
		for (String cid : listaCarrinho) {
			if (cid.equals(id)) {
				listaCarrinho.remove(cid);
				break;
			}

		}

		return listaCarrinho;
	}
}

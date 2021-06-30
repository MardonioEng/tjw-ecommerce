package br.edu.ifce.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifce.bean.Produto;
import br.edu.ifce.bean.Usuario;

public class OperacaoDBMemoria {

	/*
	 * DADOS DOS USUÁRIOS
	 */
	List<String> nomeUsuario = new ArrayList<String>();
	List<String> senhaUsuario = new ArrayList<String>();

	private void usuarios() {
		nomeUsuario.add("mardonio");
		senhaUsuario.add("mardonio");
	}
	
	/*
	 * DADOS DOS PRODUTOS
	 */
	List<String> nomeProduto = new ArrayList<String>();
	List<String> valorProduto = new ArrayList<String>();
	List<String> featuredProduto = new ArrayList<String>();
	List<String> imagemProduto = new ArrayList<String>();

	private void produtos() {
		nomeProduto.add("Livro Clean Code");
		valorProduto.add("150");
		featuredProduto.add("yes");
		imagemProduto.add("img/cleancode.jpg");
		
		nomeProduto.add("Livro Algoritmos");
		valorProduto.add("315");
		featuredProduto.add("no");
		imagemProduto.add("img/algoritmos.jpg");
		
		nomeProduto.add("Livro Inteligencia Artificial");
		valorProduto.add("380");
		featuredProduto.add("no");
		imagemProduto.add("img/inteligenciaartificial.jpg");
	}

	
	/*
	 * OPERACOES COM USUARIOS 
	 */
	public void addUser(Usuario usuario) {
		usuarios();
		nomeUsuario.add(usuario.getUsername());
		senhaUsuario.add(usuario.getSenha());
	}

	public boolean checkUser(String username, String senha) {
		usuarios();
		for(int i = 0; i < nomeUsuario.size(); i++) {
			if(nomeUsuario.get(i).equals(username))
				if(senhaUsuario.get(i).equals(senha))
					return true;
		}
		return false;
	}

	public ArrayList<Usuario> fetchUser() {
		usuarios();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		for(int i = 0; i < nomeUsuario.size(); i++) {
			Usuario usuario = new Usuario();
			usuario.setId(i);
			usuario.setUsername(nomeUsuario.get(i));
			usuario.setSenha(senhaUsuario.get(i));
			usuarios.add(usuario);
		}
		return usuarios;
	}

	/*
	 * OPERACOES COM PRODUTOS
	 */
	public void addProduct(Produto p) {
		produtos();
		nomeProduto.add(p.getNome());
		valorProduto.add(p.getValor());
		featuredProduto.add("no");
		imagemProduto.add(p.getImagem());		
	}

	public void updateProduct(Produto p) {
		produtos();
		nomeProduto.set(p.getId(), p.getNome());
		valorProduto.set(p.getId(), p.getValor());
		imagemProduto.set(p.getId(), p.getImagem());
	}

	public ArrayList<Produto> fetchProducts() {
		produtos();
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		for(int i = 0; i < nomeProduto.size(); i++) {
			Produto produto = new Produto();
			produto.setId(i);
			produto.setNome(nomeProduto.get(i));
			produto.setValor(valorProduto.get(i));
			produto.setImagem(imagemProduto.get(i));
			produtos.add(produto);
		}
		return produtos;
	}

	public Produto fetchProductsById(String id) {
		int idp = Integer.parseInt(id);
		produtos();
		Produto produto = new Produto();
		produto.setId(idp);
		produto.setNome(nomeProduto.get(idp));
		produto.setValor(valorProduto.get(idp));
		produto.setImagem(imagemProduto.get(idp));
		return produto;
	}

	public void deleteProductById(String id) {
		int idp = Integer.parseInt(id);
		produtos();
		nomeProduto.remove(idp);
		valorProduto.remove(idp);
		imagemProduto.remove(idp);
		featuredProduto.remove(idp);
	}

}

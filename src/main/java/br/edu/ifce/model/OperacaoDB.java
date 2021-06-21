package br.edu.ifce.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.ifce.bean.Produto;
import br.edu.ifce.bean.Usuario;
import br.edu.ifce.utils.ConnectionDB;
import br.edu.ifce.utils.exceptions.DBException;

public class OperacaoDB {

	private Connection conn;

	ArrayList<Usuario> userList = new ArrayList<Usuario>();

	// OPERACOES COM USUARIOS

	public void addUser(Usuario usuario) {
		conn = ConnectionDB.getConnection();
		PreparedStatement st = null;
		try {
			String query = "Insert into usuario (username, senha) values (?,?)";
			st = conn.prepareStatement(query);

			st.setString(1, usuario.getUsername());
			st.setString(2, usuario.getSenha());

			st.executeUpdate();

		} catch (Exception e) {
			throw new DBException(e.getMessage());
		} finally {
			ConnectionDB.closeStatement(st);
		}
	}

	public boolean checkUser(String username, String senha) {
		conn = ConnectionDB.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			String query = "Select * from usuario where username = ? and senha = ?";
			st = conn.prepareStatement(query);

			st.setString(1, username);
			st.setString(2, senha);

			rs = st.executeQuery();

			if (rs.next()) {
				flag = true;
			}

		} catch (Exception e) {
			throw new DBException(e.getMessage());
		} finally {
			ConnectionDB.closeStatement(st);
			ConnectionDB.closeResultSet(rs);
		}

		if (flag) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Usuario> fetchUser() {

		conn = ConnectionDB.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String query = "Select * from usuario";
			st = conn.prepareStatement(query);
			rs = st.executeQuery();
			ArrayList<Usuario> userList = new ArrayList<Usuario>();

			while (rs.next()) {

				int id = rs.getInt("id");
				String username = rs.getString("username");
				String senha = rs.getString("senha");

				Usuario usuario = new Usuario();

				usuario.setId(id);
				usuario.setUsername(username);
				usuario.setSenha(senha);
				userList.add(usuario);
			}
			return userList;

		} catch (Exception e) {
			throw new DBException(e.getMessage());
		} finally {
			ConnectionDB.closeStatement(st);
			ConnectionDB.closeResultSet(rs);
		}
	}

	// OPERACOES COM PRODUTOS

	public void addProduct(Produto p) {

		conn = ConnectionDB.getConnection();
		PreparedStatement st = null;

		try {
			String query = "Insert into produto (nome,valor,featured,imagem) values (?,?,?,?)";
			st = conn.prepareStatement(query);

			st.setString(1, p.getNome());
			st.setString(2, p.getValor());
			st.setString(4, p.getImagem());

			st.executeUpdate();

		} catch (Exception e) {
			throw new DBException(e.getMessage());
		} finally {
			ConnectionDB.closeStatement(st);
		}
	}

	public void updateProduct(Produto p) {

		conn = ConnectionDB.getConnection();
		PreparedStatement st = null;

		try {
			String query = "update produto set nome=?,valor=?,featured=?,imagem=? where id=?";
			st = conn.prepareStatement(query);

			st.setString(1, p.getNome());
			st.setString(2, p.getValor());
			st.setString(4, p.getImagem());
			st.setInt(5, p.getId());

			st.executeUpdate();

		} catch (Exception e) {
			throw new DBException(e.getMessage());
		} finally {
			ConnectionDB.closeStatement(st);
		}
	}

	public ArrayList<Produto> fetchProducts() {

		conn = ConnectionDB.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String query = "Select * from produto";
			st = conn.prepareStatement(query);
			rs = st.executeQuery();
			ArrayList<Produto> Productlist = new ArrayList<Produto>();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String valor = rs.getString("valor");
				String imagem = rs.getString("imagem");

				Produto p = new Produto();

				p.setId(id);
				p.setNome(nome);
				p.setValor(valor);
				p.setImagem(imagem);

				Productlist.add(p);
			}
			return Productlist;

		} catch (Exception e) {
			throw new DBException(e.getMessage());
		} finally {
			ConnectionDB.closeStatement(st);
			ConnectionDB.closeResultSet(rs);
		}
	}

	public Produto fetchProductsById(String id) {

		conn = ConnectionDB.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String query = "select * from produto where id=?";
			st = conn.prepareStatement(query);
			st.setString(1, id);
			rs = st.executeQuery();
			Produto p = new Produto();

			if (rs.next()) {
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setValor(rs.getString("valor"));
//				p.setFeatured(rs.getString("featured"));
				p.setImagem(rs.getString("imagem"));
			}

			return p;

		} catch (Exception e) {
			throw new DBException(e.getMessage());
		} finally {
			ConnectionDB.closeStatement(st);
			ConnectionDB.closeResultSet(rs);
		}
	}

	public void deleteProductById(String id) {

		conn = ConnectionDB.getConnection();
		PreparedStatement st = null;

		try {
			String query = "delete from produto where id=?";
			st = conn.prepareStatement(query);

			st.setString(1, id);
			st.executeUpdate();

		} catch (Exception e) {
			throw new DBException(e.getMessage());
		} finally {
			ConnectionDB.closeStatement(st);
		}

	}
}

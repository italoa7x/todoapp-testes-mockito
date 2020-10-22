package br.ifpb.edu.service;

import java.util.ArrayList;
import java.util.List;

import br.ifpb.edu.domain.Usuario;

public class UsuarioService {

	// usuario cadastrados no banco em memoria
	private List<Usuario> usuariosCadastrados;
	private Usuario usuario1, usuario2, usuario3;

	public UsuarioService() {
		// instancia os objetos usuarios
		usuariosCadastrados = new ArrayList();
		usuario1 = new Usuario("Joao", "joao@gmail.com", "111");
		usuario1.setId(usuariosCadastrados.size() + 1);

		usuario2 = new Usuario("Miguel", "miguel@gmail.com", "222");
		usuario2.setId(usuariosCadastrados.size() + 1);

		usuario3 = new Usuario("Carlos", "carlos@gmail.com", "333");
		usuario3.setId(usuariosCadastrados.size() + 1);
		// salva os usuario no banco temporario
		salvarNovoUsuario(usuario1);
		salvarNovoUsuario(usuario2);
		salvarNovoUsuario(usuario3);
	}

	// verifica se o email ou senha � nulo, se sim, retorna nulo pois n�o ser�
	// poss�vel continuar com o login.
	public Usuario logar(String email, String senha) {
		if (email == null || senha == null) {
			return null;
		}
		// verifica entre os usuarios cadastrados qual tem os dados iguais ao passado no
		// parametro
		for (Usuario usr : usuariosCadastrados) {
			if(email.equalsIgnoreCase(usr.getEmail()) && senha.equalsIgnoreCase(usr.getSenha())) {
				return usr;
			}
		}
		return null;
	}

	public boolean salvarNovoUsuario(Usuario u) {
		if (u == null) {
			return false;
		}
		else if (u.getSenha() == null) {
			return false;
		}
		else if (u.getEmail() == null) {
			return false;
		}
		u.setId(usuariosCadastrados.size() + 1);
		usuariosCadastrados.add(u);
		return true;
	}

	public List<Usuario> getUsuariosCadastrados() {
		return usuariosCadastrados;
	}

	public Usuario buscaUsuarioPorId(Integer id) {
		Usuario usuarioBuscado = usuariosCadastrados.get(id);
		if (usuarioBuscado == null) {
			return null;
		}
		return usuarioBuscado;
	}
	
	public boolean atualizarDados(Usuario usuario) {
		for(Usuario u : usuariosCadastrados) {
			if(u.getId() == usuario.getId()) {
				u = usuario;
				return true;
			}
		}
		return false;
	}

}

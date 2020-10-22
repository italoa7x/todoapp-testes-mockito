package br.ifpb.edu.domain;

import java.util.Date;
import java.util.List;

import br.ifpb.edu.service.UsuarioService;

public class Usuario {
	private String nome;
	private String email;
	private String senha;
	private Integer id;
	private List<Tarefa> tarefas;

	private UsuarioService usuarioService;

	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public boolean adicionarTarefa(Tarefa tarefa) {
		if (tarefa == null) {
			return false;
		}
		if (tarefa.getDescricao() == null && tarefa.getTitulo() == null && tarefa.getDataCriacao() == null) {
			return false;
		}

		tarefas.add(tarefa);
		return true;
	}

	public boolean atualizarTarefa(Tarefa tarefa) {
		if (tarefa.getTitulo() == null || tarefa.getDescricao() == null) {
			return false;
		} else if (tarefa.getDataCriacao() == null || tarefa.getDataFinalizacao() == null) {
			return false;
		} else {
			for (Tarefa t : tarefas) {
				if (t.equals(tarefa)) {
					t.setDataFinalizacao(new Date());
					return true;
				}
			}

		}
		return false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((tarefas == null) ? 0 : tarefas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (tarefas == null) {
			if (other.tarefas != null)
				return false;
		} else if (!tarefas.equals(other.tarefas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", senha=" + senha + ", tarefas=" + tarefas + "]";
	}

}

package br.ifpb.edu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ifpb.edu.domain.Tarefa;

public class TarefaService {
	private List<Tarefa> tarefasCadastradas;
	private Tarefa tarefa1, tarefa2, tarefa3;

	public TarefaService() {
		// instancia a lista e chama o método para salvar as tarefas criadas
		tarefasCadastradas = new ArrayList<Tarefa>();

		tarefa1 = new Tarefa("Titulo 1", "Descrição 1", new Date());

		tarefa2 = new Tarefa("Titulo 2", "Descrição 2", new Date());

		tarefa3 = new Tarefa("Titulo 3", "Descrição 3", new Date());

		salvarTarefa(tarefa1);
		salvarTarefa(tarefa2);
		salvarTarefa(tarefa3);
	}

	public boolean salvarTarefa(Tarefa tarefa) {
		// se a tarefa for nula, retorna um null
		if (tarefa == null) {
			return false;
		}
		// estratégia de criar um ID de forma dinâmica
		tarefa.setId(tarefasCadastradas.size() + 1);
		tarefasCadastradas.add(tarefa);
		return true;
	}

	public boolean atualizarTarefa(Tarefa tarefa) {
		// verifica a tarefa passada por parâmetro, se ela não existir, é retornado um
		// nulo, caso contrário
		// é feito o processo de atualização da mesma
		if (tarefa == null) {
			return false;
		} else if (tarefa.getId() == null) {
			return false;
		}
		for (Tarefa t : tarefasCadastradas) {
			if (t.getId() == tarefa.getId()) {
				t = tarefa;
				return true;
			}
		}
		return true;
	}

	public boolean excluirTarefa(Integer id) {
		if (id == null) {
			return false;
		}
		for (Tarefa t : tarefasCadastradas) {
			if (t.getId() == id) {
				tarefasCadastradas.remove(t);
				return true;
			}
		}
		return false;
	}

	public List<Tarefa> getTarefasCadastradas() {
		return tarefasCadastradas;
	}

}

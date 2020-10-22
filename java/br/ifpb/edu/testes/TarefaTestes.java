package br.ifpb.edu.testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import br.ifpb.edu.domain.Tarefa;
import br.ifpb.edu.service.TarefaService;


public class TarefaTestes {

	private TarefaService service;
	private Tarefa tarefaCorreta, tarefaIncorreta;

	@Before
	public void initiMocks() {
		tarefaCorreta = mock(Tarefa.class);
		service = mock(TarefaService.class);
	}

	@Test
	public void testaSalvarUmaTarefaComTodosOsDados() {

		tarefaCorreta.setDescricao("descricao tarefa correta");
		tarefaCorreta.setTitulo("titulo tarefa correta");
		tarefaCorreta.setDataCriacao(new Date());

		when(service.salvarTarefa(tarefaCorreta)).thenReturn(true);
		assertTrue(service.salvarTarefa(tarefaCorreta));
	}

	@Test
	public void testaSalvarUmaTarefaNaoInstanciada() {
		when(service.salvarTarefa(tarefaIncorreta)).thenReturn(false);
		assertFalse(service.salvarTarefa(tarefaIncorreta));
	}

	@Test
	public void testaAtualizarUmaTarefaComTodosOsDados() {
		tarefaCorreta.setDescricao("descricao tarefa correta");
		tarefaCorreta.setTitulo("titulo tarefa correta");
		tarefaCorreta.setDataCriacao(new Date());

		when(service.salvarTarefa(tarefaCorreta)).thenReturn(true);

		tarefaCorreta.setTitulo("titulo atualizado");
		when(service.atualizarTarefa(tarefaCorreta)).thenReturn(true);
	}

	@Test
	public void testaAtualizacaoDeDadosDeUmaTarefaQueNaoFoiInstanciada() {
		when(service.atualizarTarefa(tarefaIncorreta)).thenReturn(false);
	}

	@Test
	public void testaExclusaoDeUmaTarefaPassandoUmIdValido() {
		Tarefa tarefaComId = mock(Tarefa.class);
		when(service.excluirTarefa(2)).thenReturn(true);
	}

	@Test
	public void testaExclusaoDeUmaTarefaPassandoUmIdInvalido() {
		when(service.excluirTarefa(2)).thenReturn(false);
	}
}

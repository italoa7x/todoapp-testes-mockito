package br.ifpb.edu.testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import br.ifpb.edu.domain.Tarefa;
import br.ifpb.edu.domain.Usuario;
import br.ifpb.edu.service.UsuarioService;

public class UsuarioTestes {

	private UsuarioService service = mock(UsuarioService.class);

	private Usuario usuarioCorreto, usuarioInvalido, usuarioSemSenha, usuarioSemEmail;

	@Before
	public void initMocks() {
		usuarioCorreto = mock(Usuario.class);
		usuarioSemSenha = mock(Usuario.class);
		usuarioSemEmail = mock(Usuario.class);
		usuarioInvalido = mock(Usuario.class);
		service = mock(UsuarioService.class);
	}

	@Test
	public void testaSeCadastraUmUsuarioComSucesso() {

		usuarioCorreto.setEmail("emailMock@gmail.com");
		usuarioCorreto.setSenha("senhamock");
		usuarioCorreto.setNome("usuario mock");

		when(service.salvarNovoUsuario(usuarioCorreto)).thenReturn(true);

		assertTrue(service.salvarNovoUsuario(usuarioCorreto));
	}

	@Test
	public void testaSalvarUmUsuarioSemSenha() {

		usuarioSemSenha.setEmail("emailMock@gmail.com");
		usuarioSemSenha.setNome("usuario mock");

		when(service.salvarNovoUsuario(usuarioSemSenha)).thenReturn(false);

		assertFalse(service.salvarNovoUsuario(usuarioSemSenha));
	}

	@Test
	public void testaSalvarUmUsuarioSemEmail() {

		usuarioSemEmail.setSenha("senhamock");
		usuarioSemEmail.setNome("usuario mock");

		when(service.salvarNovoUsuario(usuarioSemEmail)).thenReturn(false);

		assertFalse(service.salvarNovoUsuario(usuarioSemEmail));
	}

	@Test
	public void testaSalvarTarefaSemDadosParaOUsuarioCorreto() {
		Tarefa tarefa = mock(Tarefa.class);

		when(service.salvarNovoUsuario(usuarioInvalido)).thenReturn(false);
		assertFalse(service.salvarNovoUsuario(usuarioInvalido));
		when(usuarioInvalido.adicionarTarefa(tarefa)).thenReturn(false);

		assertFalse(usuarioInvalido.adicionarTarefa(tarefa));

	}

	@Test
	public void testaLoginNoSistema() {
		Usuario usuario = mock(Usuario.class);
		usuario.setEmail("italo@gmail.com");
		usuario.setSenha("123");
		usuario.setId(1);
		verify(usuario).setEmail("italo@gmail.com");
		verify(usuario).setSenha("123");
		
		//when(service.logar(usuario.getEmail(), usuario.getSenha())).thenReturn(usuario);
		
	}

	@Test
	public void testaLogarComUsuarioInvalido() {

		when(service.logar(usuarioInvalido.getEmail(), usuarioInvalido.getSenha())).thenReturn(null);

		assertNull(service.logar(usuarioInvalido.getEmail(), usuarioInvalido.getSenha()));
	}

	@Test
	public void testaAtualizacaoDeDadosDeUmUsuario() {
		usuarioCorreto.setNome("italo");
		usuarioCorreto.setEmail("italo@gmail.com");
		usuarioCorreto.setSenha("123");
		usuarioCorreto.setId(1);

		when(service.salvarNovoUsuario(usuarioCorreto)).thenReturn(true);
		assertTrue(service.salvarNovoUsuario(usuarioCorreto));

		verify(usuarioCorreto).setNome("italo");
		verify(usuarioCorreto).setEmail("italo@gmail.com");
		verify(usuarioCorreto).setSenha("123");
		when(service.atualizarDados(usuarioCorreto)).thenReturn(true);
		assertTrue(service.atualizarDados(usuarioCorreto));
	}

}

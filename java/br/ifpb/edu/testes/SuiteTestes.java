package br.ifpb.edu.testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = {
		UsuarioTestes.class,
		TarefaTestes.class})
public class SuiteTestes {

}

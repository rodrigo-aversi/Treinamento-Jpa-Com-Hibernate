package br.com.ciandt.treinamento.entitybean;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Ignore;
import org.junit.Test;

public class ContaTest {

	final static Logger logger = Logger.getLogger(ContaTest.class);
	
	@Test
	public void testeGerandoBancoDeDadosGravandoDados() {
		
		
		Date currentDate = new Date();
		DateTime dataAtualização = new DateTime(2017, 4, 1, 10, 0, DateTimeZone.forID("America/Sao_Paulo"));
		
		Conta conta = new Conta("FULANO DE TAL", 123, "123345678", "XPTO", currentDate, dataAtualização.getMillis());

		EntityManager entityManager = Persistence.createEntityManagerFactory(
				"tarefas").createEntityManager();
		
		long startDate = System.currentTimeMillis();

		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.getTransaction().commit();
		long endDate = System.currentTimeMillis();
		logger.info("Conta criada " + conta);
		entityManager.close();
		
		System.out.println("Tempo total gasto - " + (startDate - endDate) + " milisegundos");
		
		// Atenção aos logs de aplicação, ele mostra a comunicação com o banco de dados.
		// Usar <property name="hibernate.hbm2ddl.auto" value="create" /> no persistence.xml.

	}
	
	@Test
	@Ignore
	public void testeExemploHibernateHbm2ddlAutoCreateDrop() {
		
		Date currentDate = new Date();
		DateTime dataAtualização = new DateTime(2017, 4, 1, 10, 0, DateTimeZone.forID("America/Sao_Paulo"));
		
		Conta conta = new Conta("FULANO DE TAL", 123, "123345678", "XPTO", currentDate, dataAtualização.getMillis());

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
				"tarefas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.getTransaction().commit();
		logger.info("Conta criada " + conta);
		entityManager.close();
		entityManagerFactory.close();
		
		// Atenção aos logs de aplicação, ele mostra a comunicação com o banco de dados.
		// Usar <property name="hibernate.hbm2ddl.auto" value="create-drop" /> no persistence.xml.

	}
	
	@Test
	@Ignore
	public void testeExemploHibernateHbm2ddlAutoUpdate() {
		
		Date currentDate = new Date();
		DateTime dataAtualização = new DateTime(2017, 4, 1, 10, 0, DateTimeZone.forID("America/Sao_Paulo"));
		
		Conta conta = new Conta("FULANO DE TAL", 123, "123345678", "XPTO", currentDate, "novo atributo qualquer", dataAtualização.getMillis());

		EntityManager entityManager = Persistence.createEntityManagerFactory(
				"tarefas").createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.getTransaction().commit();
		logger.info("Conta criada " + conta);
		entityManager.close();
		
		// Rode novamente o exemplo testeGerandoBancoDeDadosGravandoDados, porque sua tabela não existe mais.
		// Adicione um novo atributo qualquer na classe Conta.
		// Atenção aos logs de aplicação, ele mostra a comunicação com o banco de dados.
		// Usar <property name="hibernate.hbm2ddl.auto" value="update" /> no persistence.xml.

	}

}

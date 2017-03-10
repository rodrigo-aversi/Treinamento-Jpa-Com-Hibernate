package br.com.ciandt.treinamento.entitybean;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

public class ContaTest {

	final static Logger logger = Logger.getLogger(ContaTest.class);
	
	@Test
	public void testMyFirst() {
		
		Date currentDate = new Date();
		DateTime dataAtualização = new DateTime(2017, 4, 1, 10, 0, DateTimeZone.forID("America/Sao_Paulo"));
		
		Conta conta = new Conta("FULANO DE TAL", 123, "123345678", "XPTO", currentDate, dataAtualização.getMillis());

		EntityManager entityManager = Persistence.createEntityManagerFactory(
				"tarefas").createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.getTransaction().commit();
		logger.info("Conta criada " + conta);
		entityManager.close();

	}

}

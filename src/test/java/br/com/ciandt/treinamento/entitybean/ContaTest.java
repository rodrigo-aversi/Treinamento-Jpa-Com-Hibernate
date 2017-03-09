package br.com.ciandt.treinamento.entitybean;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.junit.Test;

public class ContaTest {

	final static Logger logger = Logger.getLogger(ContaTest.class);
	
	@Test
	public void main() {
		
		Date currentDate = new Date(Calendar.getInstance().getTimeInMillis());
		Conta conta = new Conta("123","Bradesco", "123456-7","Rodrigo", currentDate);

		EntityManager entityManager = Persistence.createEntityManagerFactory(
				"tarefas").createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.getTransaction().commit();
		logger.info("Conta criada " + conta);
		entityManager.close();

	}

}

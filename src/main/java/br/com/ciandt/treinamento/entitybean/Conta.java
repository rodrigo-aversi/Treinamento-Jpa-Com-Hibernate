package br.com.ciandt.treinamento.entitybean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Conta {

	@Id
	@GeneratedValue
	private Long id;
	private String titular;
	private String agencia;
	private String numero;
	private String banco;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	public Conta() {}
	
	public Conta(String titular, String agencia, String numero, String banco, Date dataCriacao) {
		super();
		this.titular = titular;
		this.agencia = agencia;
		this.numero = numero;
		this.banco = banco;
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", titular=" + titular + ", agencia="
				+ agencia + ", numero=" + numero + ", banco=" + banco
				+ ", dataCriacao=" + dataCriacao + "]";
	}
}


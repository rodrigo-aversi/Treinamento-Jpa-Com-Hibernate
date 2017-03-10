package br.com.ciandt.treinamento.entitybean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

@Entity
public class Conta {

	@Id
	@GeneratedValue
	private Long id;
	private String titular;
	private Integer agencia;
	private String numero;
	private String banco;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	private Long dataGravadaComoLong;
	
	public Conta() {}
	
	public Conta(String titular, Integer agencia, String numero, String banco, Date dataCriacao, Long dataGravadaComoLong) {
		super();
		this.titular = titular;
		this.agencia = agencia;
		this.numero = numero;
		this.banco = banco;
		this.dataCriacao = dataCriacao;
		this.dataGravadaComoLong = dataGravadaComoLong;
	}
	
	public DateTime pegarDataLongComoDateTime() {
		return new DateTime(this.dataGravadaComoLong, DateTimeZone.forID("America/Sao_Paulo"));
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", titular=" + titular + ", agencia=" + agencia + ", numero=" + numero + ", banco="
				+ banco + ", dataCriacao=" + dataCriacao + ", dataGravadaComoLong=" + dataGravadaComoLong + "]";
	}

	
}


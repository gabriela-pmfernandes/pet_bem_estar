package br.edu.ifrs.petbemestar.dominio;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Atendimento {
	@Id
	private Long id;
	
	private LocalDateTime dataHora;
	private TipoAtendimento tipo;
	private SituacaoAtendimento situacao;
	
	private Double valor;
	
	private Animal animal;
	
	public Atendimento() {
		
	}
	
	public Atendimento(LocalDateTime dataHor, TipoAtendimento tipo) {
		this.dataHora = dataHora;
		this.tipo = tipo;
		this.situacao = SituacaoAtendimento.AGENDADO;
	}
	
	public Long getId() {
		return id;
	}
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	
	public TipoAtendimento getTipo() {
		return tipo;
	}
	
	public SituacaoAtendimento getSituacao() {
		return situacao;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public Animal getAnimal() {
		return animal;
	}
	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public void setSituacao(SituacaoAtendimento situacao) {
		this.situacao = situacao;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return tipo + "em" + "(" + situacao +")";
	}

}

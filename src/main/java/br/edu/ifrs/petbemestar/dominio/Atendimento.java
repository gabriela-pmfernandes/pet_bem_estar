package br.edu.ifrs.petbemestar.dominio;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Atendimento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime dataHora;
	@Enumerated(EnumType.STRING)
	private TipoAtendimento tipo;
	@Enumerated(EnumType.STRING)
	private SituacaoAtendimento situacao;
	
	private Double valor;
	
	@ManyToOne
	private Animal animal;
	
	public Atendimento() {
		
	}
	
	public Atendimento(LocalDateTime dataHora, TipoAtendimento tipo) {
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
		return tipo + "em" + dataHora + "(" + situacao +")";
	}

}

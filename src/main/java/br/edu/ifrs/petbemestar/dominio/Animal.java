package br.edu.ifrs.petbemestar.dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Animal {
	@Id
	private Long id;
	
	private String nome;
	private Especie especie;
	private Porte porte;
	
	private Tutor tutor;
	
	private List<Atendimento> atendimentos = new ArrayList<>();
	 public Animal() {
		 
	 }
	 public Animal(String nome, Especie especie, Porte porte) {
		 this.nome = nome;
		 this.especie = especie;
		 this.porte = porte;
	 }
	 
	 public void adicionarAtendimento(Atendimento atendimento) {
		 atendimentos.add(atendimento);
		 
	 }
	 
	 public Atendimento ultimoAtendimentoRealizado() {
		 Atendimento ultimo = null;
		 for(Atendimento atendimento : atendimentos) {
			 if(atendimento.getSituacao() != SituacaoAtendimento.REALIZADO) {
				 continue;
			 }
			 if(ultimo == null || atendimento.getDataHora().isAfter(ultimo.getDataHora())) {
				 ultimo = atendimento;
			 }
		 }
		 return ultimo;
	 }
	 
	 public Long getId() {
		 return id;
	 }
	 
	 public String getNome() {
		 return nome;
	 }
	 
	 public Especie getEspecie() {
		 return especie;
	 }
	 
	 public Porte getPorte() {
		 return porte;
	 }
	 
	 public Tutor getTutor() {
		 return tutor;
	 }
	 
	 public void setTuor(Tutor tutor) {
		 this.tutor = tutor;
	 }
	 
	 public void setTutor(Tutor tutor) {
		 this.tutor = tutor;
	 }
	 
	 @Override
	 public String toString() {
		 return nome + "(" + especie + ")";
	 }

}

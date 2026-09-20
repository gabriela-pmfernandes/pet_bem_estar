package br.edu.ifrs.petbemestar;

import java.time.LocalDateTime;

import br.edu.ifrs.petbemestar.dominio.Animal;
import br.edu.ifrs.petbemestar.dominio.Atendimento;
import br.edu.ifrs.petbemestar.dominio.Especie;
import br.edu.ifrs.petbemestar.dominio.Porte;
import br.edu.ifrs.petbemestar.dominio.SituacaoAtendimento;
import br.edu.ifrs.petbemestar.dominio.TipoAtendimento;
import br.edu.ifrs.petbemestar.dominio.Tutor;

public class Principal {
	public static void main(String[] args) {
		Tutor rosa = new Tutor("Rosa", "(51)99999-0000");
		
		Animal mimi = new Animal("Mimi", Especie.GATO, Porte.PEQUENO);
		Animal thor = new Animal("Thor", Especie.CAO, Porte.GRANDE);
		Animal frajola = new Animal("Frajola", Especie.GATO, Porte.PEQUENO);
		Animal nina = new Animal("Nina", Especie.GATO, Porte.PEQUENO);
		
		rosa.adicionarAnimal(mimi);
		rosa.adicionarAnimal(thor);
		rosa.adicionarAnimal(frajola);
		rosa.adicionarAnimal(nina);
		
		Atendimento banhoDaMimi = new Atendimento(LocalDateTime.of(2026, 8, 12, 9, 0), TipoAtendimento.BANHO);
		Atendimento banhoDoThor = new Atendimento(LocalDateTime.of(2026,  8, 12, 9, 0), TipoAtendimento.BANHO);
		Atendimento tosaDoFrajola = new Atendimento(LocalDateTime.of(2026,  8, 12, 14, 0), TipoAtendimento.TOSA);
		Atendimento consultaDaNina = new Atendimento(LocalDateTime.of(2026,  8, 13, 10, 0), TipoAtendimento.CONSULTA);
		
		mimi.adicionarAtendimento(banhoDaMimi);
		thor.adicionarAtendimento(banhoDoThor);
		frajola.adicionarAtendimento(tosaDoFrajola);
		nina.adicionarAtendimento(consultaDaNina);
		
		banhoDaMimi.setSituacao(SituacaoAtendimento.REALIZADO);
		tosaDoFrajola.setSituacao(SituacaoAtendimento.REALIZADO);
		consultaDaNina.setSituacao(SituacaoAtendimento.NAO_COMPARECEU);
		
		System.out.println("Tutora: " + rosa);
		System.out.println("Telefone:  + (um ´so em um lugar só):" + rosa.getTelefone());
		System.out.println("Animais: " + rosa.getAnimais().size() + "->" + rosa.getAnimais());
		System.out.println();
		
		for(Animal animal : rosa.getAnimais()) {
			Atendimento ultimo = animal.ultimoAtendimentoRealizado();
			System.out.println("Última vez que " + animal.getNome() + "veio: " + (ultimo==null ? "nunca veio" : ultimo.getDataHora().toString()));
		}
		
		
	}
}

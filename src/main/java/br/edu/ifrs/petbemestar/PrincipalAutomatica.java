package br.edu.ifrs.petbemestar;

import java.util.List;

import br.edu.ifrs.petbemestar.dao.AtendimentoDAO;
import br.edu.ifrs.petbemestar.dao.AtendimentoDAOJPA;
import br.edu.ifrs.petbemestar.dao.TutorDAO;
import br.edu.ifrs.petbemestar.dao.TutorDAOJPA;
import br.edu.ifrs.petbemestar.dominio.Atendimento;
import br.edu.ifrs.petbemestar.dominio.Tutor;

public class PrincipalAutomatica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TutorDAO tutorDAO = new TutorDAOJPA();
		AtendimentoDAO atendimentoDAO = new AtendimentoDAOJPA();
		Tutor rosa = new Tutor("Rosa", "(51)99999-0000");
		Tutor ana = new Tutor("Ana", "(51)99999-1111");
		tutorDAO.salvar(rosa);
		tutorDAO.salvar(ana);
		
		tutorDAO.buscarPorId(1L);
		if(rosa != null) {
			rosa.setTelefone("(51)98888-1111");
			tutorDAO.atualizar(rosa);
			System.out.println("Tutor atualizado: "+rosa.getNome() + "| Novo telefone: " + rosa.getTelefone());
		}
		atendimentoDAO.remover(2L);
		System.out.println("Atendimento ID 2 removido com sucesso!");
		
		System.out.println("\n----Histórico de Atendimentos da Mimi----");
		List<Atendimento> atendimentosDaMimi = atendimentoDAO.listarPorAnimal(1L);
		for(Atendimento a : atendimentosDaMimi) {
			System.out.println(a);
		}
		

	}

}

package br.edu.ifrs.petbemestar.dao;

import java.util.List;

import br.edu.ifrs.petbemestar.dominio.Animal;
import br.edu.ifrs.petbemestar.dominio.Atendimento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AtendimentoDAOJPA implements AtendimentoDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pet-bem-estar-pu");

	@Override
	public void salvar(Atendimento atendimento) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(atendimento);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public Atendimento buscarPorId(Long id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		Atendimento atendimento = em.find(Atendimento.class, id);
		em.close();
		return atendimento;
	}
	
	@Override
	public List<Atendimento> listarTodos() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		List<Atendimento> atendimentos = em.createQuery("SELECT atendimento FROM Atendimento atendimento", Atendimento.class).getResultList();
		em.close();
		return atendimentos;
	}

	@Override
	public void atualizar(Atendimento atendimento) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(atendimento);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Atendimento atendimento = em.find(Atendimento.class, id);
		em.remove(atendimento);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public List<Atendimento> listarPorAnimal(Long idAnimal){
		EntityManager em = emf.createEntityManager();
		String jpql = "SELECT a FROM Atendimento a WHERE a.animal.id = :idAnimal";
		List<Atendimento> lista = em.createQuery(jpql, Atendimento.class).setParameter("idAnimal", idAnimal).getResultList();
		em.close();
		return lista;
	}

	

}

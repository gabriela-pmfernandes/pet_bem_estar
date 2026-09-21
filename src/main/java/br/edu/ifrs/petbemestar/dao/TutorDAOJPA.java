package br.edu.ifrs.petbemestar.dao;

import java.util.List;

import br.edu.ifrs.petbemestar.dominio.Tutor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TutorDAOJPA implements TutorDAO{
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pet-bem-estar-pu");

	@Override
	public void salvar(Tutor tutor) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(tutor);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public Tutor buscarPorId(Long id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		Tutor tutor = em.find(Tutor.class, id);
		em.close();
		return tutor;
	}

	@Override
	public List<Tutor> listarTodos() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		List<Tutor> tutores = em.createQuery("SELECT t FROM Tutor t", Tutor.class).getResultList();
		em.close();
		return tutores;
	}

	@Override
	public void atualizar(Tutor tutor) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(tutor);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Tutor tutor = em.find(Tutor.class, id);
		em.remove(tutor);
		em.getTransaction().commit();
		em.close();
	}

}

package br.edu.ifrs.petbemestar.dao;

import java.util.List;

import br.edu.ifrs.petbemestar.dominio.Animal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AnimalDAOJPA implements AnimalDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pet-bem-estar-pu");

	@Override
	public void salvar(Animal animal) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(animal);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public Animal buscarPorId(Long id) {
		// TODO Auto-generated method stub]
		EntityManager em = emf.createEntityManager();
		Animal animal = em.find(Animal.class, id);
		em.close();
		return animal;
	}
	
	@Override
	public List<Animal> listarTodos(){
		EntityManager em = emf.createEntityManager();
		List<Animal> animais = em.createQuery("SELECT animal FROM Animal animal", Animal.class).getResultList();
		em.close();
		return animais;
	}

	@Override
	public void atualizar(Animal animal) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(animal);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Animal animal = em.find(Animal.class, id);
		em.remove(animal);
		em.getTransaction().commit();
		em.close();

	}

}

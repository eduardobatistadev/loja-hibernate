package com.loja.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import org.hibernate.Session;

import com.loja.config.HibernateConfig;

public class DaoGeneric <E> {
	public void salvar(E entidade) {
		try(Session session = HibernateConfig.getSessionFactory().openSession()) {
			EntityTransaction transaction = session.getTransaction();
			transaction.begin();
			session.persist(entidade);
			transaction.commit();
		}
	}
	public E atualizar(E entidade) { // salva ou atualiza
		try(Session session = HibernateConfig.getSessionFactory().openSession()) {
			EntityTransaction transaction = session.getTransaction();
			transaction.begin();
			@SuppressWarnings("unchecked")
			E entidadesalva = (E) session.merge(entidade);
			transaction.commit();
			
			return entidadesalva;
		}
		
	}
	public void deletar(E entidade) {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			
			Object id = HibernateConfig.getPrimaryKey(entidade);
			EntityTransaction transaction = session.getTransaction();
			transaction.begin();
			session.remove(entidade); // delete
			transaction.commit();
		}	
	}
	public E buscarId(E entidade) {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			EntityTransaction transaction = session.getTransaction();
			Object id = HibernateConfig.getPrimaryKey(entidade);
			@SuppressWarnings("unchecked")
			E e = (E) session.find(entidade.getClass(), id);
			return e;
		} 
	}
	
	public List<E> BuscarTodos(Class<E> entidade){
		Session session = HibernateConfig.getSessionFactory().openSession();
		EntityTransaction transaction = session.getTransaction();
		transaction.begin();
		
		List<E> lista = session.createQuery("from " + entidade.getName()).getResultList();
		transaction.commit();
		                    
		return lista;
	}
}

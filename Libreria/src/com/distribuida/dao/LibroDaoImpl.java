package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.distribuida.entities.Libro;

@Repository
public class LibroDaoImpl implements LibroDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Libro> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Libro").getResultList();
	}

	@Override
	@Transactional
	public Libro findOne(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Libro.class, id);
	}

	@Override
	@Transactional
	public void add(Libro libro) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(libro);
	}

	@Override
	@Transactional
	public void up(Libro libro) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(libro);
	}

	@Override
	@Transactional
	public void del(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(findOne(id));
	}

}

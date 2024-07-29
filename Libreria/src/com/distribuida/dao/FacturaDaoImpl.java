package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.distribuida.entities.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



@Repository
public class FacturaDaoImpl implements FacturaDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Factura> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Factura").getResultList();
	}

	@Override
	@Transactional
	public Factura findOne(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Factura.class, id);
	}

	@Override
	@Transactional
	public void add(Factura factura) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(factura);

	}

	@Override
	@Transactional
	public void up(Factura factura) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(factura);

	}

	@Override
	@Transactional
	public void del(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(findOne(id));

	}

}

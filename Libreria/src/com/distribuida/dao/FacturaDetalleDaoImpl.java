package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.distribuida.entities.*;

@Repository
public class FacturaDetalleDaoImpl implements FacturaDetalleDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<FacturaDetalle> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("From FacturaDetalle").getResultList();
	}

	@Override
	@Transactional
	public FacturaDetalle findOne(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(FacturaDetalle.class, id);
	}

	@Override
	@Transactional
	public void add(FacturaDetalle facturadetalle) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(facturadetalle);
	}

	@Override
	@Transactional
	public void up(FacturaDetalle facturadetalle) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(facturadetalle);
	}

	@Override
	@Transactional
	public void del(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(findOne(id));

	}

}

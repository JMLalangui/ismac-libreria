package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.distribuida.entities.Autor;



@Repository
public class AutorDaoImpl implements AutorDao {
	
	//SELECT au FROM Autor au WHERE au.idAutor = keyIdAutor
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Autor> findAll() {
		Session session = sessionFactory.getCurrentSession(); 
		return session.createQuery("SELECT au FROM Autor au",Autor.class).getResultList();
	}

	@Override
	@Transactional
	public Autor findOne(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT au FROM Autor au WHERE au.idAutor =: keyIdAutor");
		query.setParameter("keyIdAutor", id);
		return (Autor) query.getSingleResult();
	}

	@Override
	@Transactional
	public void add(Autor autor) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(autor);

	}

	@Override
	@Transactional
	public void up(Autor autor) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("UPDATE Autor au SET au.nombre =: keyNombre"
				+", au.apellido =: keyApellido"
				+", au.pais =: keyPais"
				+", au.direccion =: keyDireccion"
				+", au.telefono =: keyTelefono"
				+", au.correo =: keyCorreo"
				+"  WHERE au.idAutor =: keyIdAutor");
		query.setParameter("keyNombre", autor.getNombre());
		query.setParameter("keyApellido", autor.getApellido());
		query.setParameter("keyPais", autor.getPais());
		query.setParameter("keyDireccion", autor.getDireccion());
		query.setParameter("keyTelefono", autor.getTelefono());
		query.setParameter("keyCorreo", autor.getCorreo());
		query.setParameter("keyIdAutor", autor.getIdAutor());
		query.executeUpdate();

	}

	@Override
	@Transactional
	public void del(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("DELETE Autor au WHERE au.idAutor =: keyIdAutor");
		query.setParameter("keyIdAutor", id);
		query.executeUpdate();

	}

}

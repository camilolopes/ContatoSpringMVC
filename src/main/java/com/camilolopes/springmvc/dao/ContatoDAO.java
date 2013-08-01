package com.camilolopes.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.camilolopes.springmvc.domain.Contato;

@Repository
@Transactional
public class ContatoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void save(Contato contato){
		Session session = getCurrentSession();
		session.getTransaction().begin();
		session.save(contato);
		session.getTransaction().commit();
	}
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Contato> readAll(){
		Session currentSession = getCurrentSession();
		currentSession.getTransaction().begin();
		return currentSession.createCriteria(Contato.class).list();
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}

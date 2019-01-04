package com.anurag.spring.dao;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.Session.LockRequest;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anurag.spring.entity.IdGenerator;

@Component
public class IdGenratorDaoImpl implements IdGeneratorDao {

	@Autowired
	SessionFactory sessionFaactory;

	@Autowired
	IdGeneratorDao idGeneratorDao;

	@Override
	public int doIncrement() {

		System.out.println(" saving increment ");
		Session session = sessionFaactory.getCurrentSession();
		int data = 0;
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(IdGenerator.class);
			criteria.add(Restrictions.eq("id", 1));
			IdGenerator idg = (IdGenerator) criteria.uniqueResult();
			idg.setNumber(idg.getNumber() + 1);
			idg = (IdGenerator) session.merge(idg);
			data = idg.getNumber();
			System.out.println("result -- " + data);
			session.getTransaction().commit();
			System.out.println(" incremet done");
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			throw e;
		}

		return data;

	}

	@Override
	public int doIncrementWithLock() {

		System.out.println(" saving increment ");
		Session session = sessionFaactory.getCurrentSession();
		int data = 0;
		try {
			session.beginTransaction();
			LockRequest lockRequest = session.buildLockRequest(new LockOptions(LockMode.PESSIMISTIC_WRITE))
					.setTimeOut(10000);
			Criteria criteria = session.createCriteria(IdGenerator.class);
			criteria.add(Restrictions.eq("id", 1));
			IdGenerator idg = (IdGenerator) criteria.uniqueResult();

			lockRequest.lock(idg);
			idg.setNumber(idg.getNumber() + 1);
			idg = (IdGenerator) session.merge(idg);
			data = idg.getNumber();
			System.out.println("result -- " + data);
			session.getTransaction().commit();
			System.out.println(" incremet done");
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			throw e;
		}

		return data;

	}

}

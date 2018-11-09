package com.learn.hib.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.learn.hib.entities.Singer;

@Transactional
@Repository("singerDao")
public class SingerDaoImpl implements SingerDao {
	Logger logger = LoggerFactory.getLogger(SingerDaoImpl.class);

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public List<Singer> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Singer s").list();
	}

	@Override
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<Singer> findAllWithAlbum() {
		return sessionFactory.getCurrentSession().getNamedQuery("Singer.findAllWithAlbum").list();
	}

	@Override
	public Singer findById(Long id) {
		return (Singer)	sessionFactory.getCurrentSession().getNamedQuery("Singer.findById").setParameter("id", id).uniqueResult();
	}

	@Override
	public Singer save(Singer singer) {
		sessionFactory.getCurrentSession().saveOrUpdate(singer);
		logger.info("Singer saved with id: " + singer.getId());
		return singer;
	}

	@Override
	public void delete(Singer contact) {
		
	}

}

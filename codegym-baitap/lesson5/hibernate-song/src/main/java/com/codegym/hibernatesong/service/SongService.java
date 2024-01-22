package com.codegym.hibernatesong.service;

import com.codegym.hibernatesong.model.Song;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class SongService implements ISongService{
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Song> getAll() {
        String queryStr = "select s from Song as s";
        TypedQuery<Song> query = entityManager.createQuery(queryStr, Song.class);
        return query.getResultList();
    }


    @Override
    public void save(Song song) {
        Transaction transaction = null;
        Song song1 = null;
        if(getById(song.getId()) == null){
            song1 = new Song();
        } else {
            song1 = getById(song.getId());
        }
        song1.setSongName(song.getSongName());
        song1.setSinger(song.getSinger());
        song1.setType(song.getType());
        song1.setUrl(song.getUrl());
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(song1);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if(transaction != null)
                transaction.rollback();
        }
    }

    @Override
    public Song getById(int id) {
        String queryStr = "select s from Song as s where s.id = :id";
        TypedQuery<Song> query = entityManager.createQuery(queryStr, Song.class);
        query.setParameter("id",id);
        try{
            return query.getSingleResult();
        } catch (Exception e){
            return null;
        }

    }




}

package com.codegym.img_day_nasa.service;

import com.codegym.img_day_nasa.model.Comment;
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
public class CommentService implements ICommentService{
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    static {
        try{
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Comment> findAll() {
        String queryStr = "select c from Comment as c";
        TypedQuery<Comment> query = entityManager.createQuery(queryStr, Comment.class);
        return query.getResultList();
    }


    public Comment findById(int id) {
        String queryStr = "select c from Comment as c where id = :id";
        TypedQuery<Comment> query = entityManager.createQuery(queryStr, Comment.class);
        query.setParameter("id",id);
        try{
            return query.getSingleResult();
        } catch(Exception e){
            return null;
        }

    }

    @Override
    public void save(Comment comment) {
        Transaction transaction = null;
        Comment comment1;
        if(findById(comment.getId()) == null){
            comment1 = new Comment();
        } else {
            comment1 = findById(comment.getId());
        }

        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            comment1.setAuthor(comment.getAuthor());
            comment1.setContent(comment.getContent());
            comment1.setLikes(comment.getLikes());
            session.saveOrUpdate(comment1);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    @Override
    public String saveLike(int id) {
        Transaction transaction = null;
        Comment comment;
        if(findById(id) == null){
            comment = new Comment();
        } else {
            comment = findById(id);
        }
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            comment.setLikes(comment.getLikes() + 1);
            session.saveOrUpdate(comment);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if(transaction != null)
                transaction.rollback();
        }
        return comment.getLikes() + "";
    }
}

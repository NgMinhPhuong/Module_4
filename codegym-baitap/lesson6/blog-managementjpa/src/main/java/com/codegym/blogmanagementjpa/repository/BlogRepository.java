package com.codegym.blogmanagementjpa.repository;

import com.codegym.blogmanagementjpa.model.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogRepository implements IBlogRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Blog findById(int id) {
        String hql = "select b from Blog as b where id = :id";
        TypedQuery<Blog> query = entityManager.createQuery(hql , Blog.class);
        query.setParameter("id",id);
        try {
            return query.getSingleResult();
        } catch (Exception e){
            return null;
        }

    }

    @Override
    public List<Blog> findAll() {
        String hql = "select b from Blog as b";
        TypedQuery<Blog> query = entityManager.createQuery(hql , Blog.class);
        return query.getResultList();
    }

    @Override
    public void save(Blog blog) {
        if(blog.getId() != 0){
            entityManager.merge(blog);
        } else
            entityManager.persist(blog);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));
    }
}

package com.codegym.blogajax.repository;

import com.codegym.blogajax.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    @Query("select b from Blog b where b.name like :name")
    List<Blog> find(@Param("name") String name);
    List<Blog> findAll();
}

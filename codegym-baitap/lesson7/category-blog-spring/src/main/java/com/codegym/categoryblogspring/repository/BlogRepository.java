package com.codegym.categoryblogspring.repository;

import com.codegym.categoryblogspring.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query("select b, c from Blog b join Category c on c.id = b.category.id")
    public List<Blog> findAll();
    @Query("select b from Blog b join  Category c on c.id = b.category.id where c.type like %:type%")
    Page<Blog> findByCategory_Typeee(Pageable pageable, @Param("type") String type);
    Optional<Blog> findById(Long id);

}

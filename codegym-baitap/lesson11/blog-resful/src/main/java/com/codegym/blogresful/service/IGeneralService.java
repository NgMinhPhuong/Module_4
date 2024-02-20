package com.codegym.blogresful.service;

import java.util.List;

public interface IGeneralService<E>{
    List<E> findAll();
    E findById(Long id);
    E save(E entity);
    void delete(E entity);
}

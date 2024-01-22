package com.codegym.pagingcustomer.repository;

import com.codegym.pagingcustomer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Page<Customer> findAllByFirstNameContaining(Pageable pageable, String name);
    Page<Customer> findById(Pageable pageable, Long id);
    Optional<Customer> findById(Long id);
}

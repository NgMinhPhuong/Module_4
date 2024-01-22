package com.codegym.customerprovincemanagement.repository;

import com.codegym.customerprovincemanagement.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Long> {
}

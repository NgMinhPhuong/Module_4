package com.codegym.customermanagementstoredprocedure.repository;

import com.codegym.customermanagementstoredprocedure.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean saveWithStoredProcedure(Customer customer) {
        String sql = "CALL Insert_Customer(:firstName, :lastName)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("firstName", customer.getFirstName());
        query.setParameter("lastName", customer.getLastName());
        return query.executeUpdate() != 0;
    }

    @Override
    public List<Customer> findAll() {
        String hql = "select c from Customer c";
        TypedQuery<Customer> query = entityManager.createQuery(hql, Customer.class);
        return query.getResultList();
    }
}
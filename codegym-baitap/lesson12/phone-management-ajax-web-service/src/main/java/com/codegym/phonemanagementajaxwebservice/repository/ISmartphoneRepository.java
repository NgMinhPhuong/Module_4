package com.codegym.phonemanagementajaxwebservice.repository;

import com.codegym.phonemanagementajaxwebservice.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphoneRepository extends JpaRepository<Smartphone, Long> {
    @Query(value = "update smartphone s set producer=?1,model=?2,price=?3 where id=?4",nativeQuery = true)
    Smartphone update(String producer, String model, double price, Long id);
}

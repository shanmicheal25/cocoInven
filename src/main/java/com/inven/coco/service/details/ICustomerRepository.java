package com.inven.coco.service.details;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inven.coco.model.TblCustomers;

@Repository
public interface ICustomerRepository extends JpaRepository<TblCustomers, Long> {

}

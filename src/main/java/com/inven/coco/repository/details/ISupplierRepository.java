package com.inven.coco.repository.details;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inven.coco.model.TblSuppliers;

@Repository
public interface ISupplierRepository extends JpaRepository<TblSuppliers, Long> {

}

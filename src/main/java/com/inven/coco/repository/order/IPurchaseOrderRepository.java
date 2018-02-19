package com.inven.coco.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inven.coco.model.TblPurchaseorder;

@Repository 
public interface IPurchaseOrderRepository extends JpaRepository<TblPurchaseorder, Long> {

}

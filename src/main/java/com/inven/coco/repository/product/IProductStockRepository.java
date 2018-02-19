package com.inven.coco.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.inven.coco.model.TblProductstock;

@Repository 
public interface IProductStockRepository extends JpaRepository<TblProductstock, Long>  {

}

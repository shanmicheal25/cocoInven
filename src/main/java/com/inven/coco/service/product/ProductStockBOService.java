package com.inven.coco.service.product;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inven.coco.common.constants.GlobelConstant;
import com.inven.coco.model.TblProductdetails;
import com.inven.coco.model.TblProductstock;
import com.inven.coco.model.TblSuppliers;
import com.inven.coco.pojo.product.ProductStockPojo;
import com.inven.coco.pojo.product.ProductdetailsPojo;
import com.inven.coco.repository.product.IProductStockRepository;

@Service("productStockBO")
public class ProductStockBOService implements IProductStockBO {

	private static final Logger log = LoggerFactory.getLogger(ProductStockBOService.class);

	@Autowired
	private IProductStockRepository prodRep;

	public ProductStockPojo addProduct(ProductStockPojo input) {

		log.info("came to add Supplier post method ");
		try {

			TblProductstock productStock = new TblProductstock();

			productStock.setProductName(input.getProductName());
			productStock.setUnitCount(input.getUnitCount());
			productStock.setUnitReturn(0);
			productStock.setUnitSell(0);
			productStock.setCreatedBy("shankar");
			productStock.setCreatedDate(LocalDateTime.now());
			productStock.setUpdatedBy("shankar");
			productStock.setUpdatedDate(LocalDateTime.now());

			ProductdetailsPojo productDetails = input.getProductDetailsPojo().get(0);
			TblProductdetails tblProductDetails = new TblProductdetails();

			tblProductDetails.setProductName(input.getProductName());
			tblProductDetails.setTblProductstock(productStock);
			tblProductDetails.setCategoryId(1);
			tblProductDetails.setCreatedBy("shankar");
			tblProductDetails.setCreatedDate(LocalDateTime.now());
			
			
			
			tblProductDetails.setSupplierId(productDetails.getSupplierId());
			tblProductDetails.setUnitOrder(productDetails.getUnitOrder());
			tblProductDetails.setUnitPrice(productDetails.getUnitPrice());
			tblProductDetails.setUnitRuin(0);
			tblProductDetails.setTotalPrice(productDetails.getTotalPrice());

			productStock.setTblProductdetails(new ArrayList<>());
			productStock.addTblProductdetail(tblProductDetails);

			TblProductstock prodStock = prodRep.save(productStock);

			input.setProductId(prodStock.getProductId());
			input.setSubmitStatus(GlobelConstant.success);
			input.setResponseDesc("Insert Successfully ");
		} catch (Exception e) {
			System.out.println(e);
		}
		return input;
	}

	@Override
	public ProductStockPojo addProductStock(ProductStockPojo input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductStockPojo updateProductStock(ProductStockPojo input) {
		
		TblProductstock productStock = prodRep.findOne(input.getProductId());
		
		//productStock.setProductName(input.getProductName());
		productStock.setUnitCount(productStock.getUnitCount() + input.getUnitCount());
		productStock.setUpdatedBy("shankar");
		productStock.setUpdatedDate(LocalDateTime.now());

		ProductdetailsPojo productDetails = input.getProductDetailsPojo().get(0);
		TblProductdetails tblProductDetails = new TblProductdetails();

		tblProductDetails.setProductName(input.getProductName());
		tblProductDetails.setTblProductstock(productStock);
		tblProductDetails.setCategoryId(1);
		tblProductDetails.setCreatedBy("shankar");
		tblProductDetails.setCreatedDate(LocalDateTime.now());
		//2/7/2018, 12:00:00 AM
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'");
		
		
		LocalDateTime dateValue = LocalDateTime.parse(productDetails.getPurchaseDate(), dtf);
		tblProductDetails.setPurchaseDate(dateValue);
		tblProductDetails.setSupplierId(productDetails.getSupplierId());
		tblProductDetails.setUnitOrder(productDetails.getUnitOrder());
		tblProductDetails.setUnitPrice(productDetails.getUnitPrice());
		tblProductDetails.setUnitRuin(0);
		tblProductDetails.setTotalPrice(productDetails.getTotalPrice());

		productStock.setTblProductdetails(new ArrayList<>());
		productStock.addTblProductdetail(tblProductDetails);

		TblProductstock prodStock = prodRep.save(productStock);

		input.setProductId(prodStock.getProductId());
		input.setUnitCount(prodStock.getUnitCount());
		input.setSubmitStatus(GlobelConstant.success);
		input.setResponseDesc("Insert Successfully ");
		
		return input;
	}
}

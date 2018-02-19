package com.inven.coco.controller.product;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inven.coco.model.TblProductstock;
import com.inven.coco.pojo.product.ProductStockPojo;
import com.inven.coco.repository.product.IProductStockRepository;
import com.inven.coco.service.product.IProductStockBO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/productStock")
public class ProductStockController {

	private static final Logger log = LoggerFactory.getLogger(ProductStockController.class);

	@Autowired
	private IProductStockRepository prodRep;

	@Resource(name = "productStockBO")
	private IProductStockBO productStockBO;

	@RequestMapping("/hi")
	public String hi() {
		return "Hello world from restful api";
	}

	@RequestMapping("/findAll")
	@ResponseBody
	public List<TblProductstock> findAll() {
		return prodRep.findAll();
	}

	@RequestMapping(value = "/addProductStock", method = RequestMethod.POST)
	public ProductStockPojo add(@Valid @RequestBody ProductStockPojo input) {
		ProductStockPojo productStockPojo = null;
		log.info("came to add Product post method ");
		try {
			productStockPojo = productStockBO.addProduct(input);

		} catch (Exception e) {
			System.out.println(e);
		}
		return productStockPojo;
	}

	@PutMapping("/updateProductStock")
	public ProductStockPojo updateProductStock(@Valid @RequestBody ProductStockPojo input) {

		log.info("came to updateProduct get method ");
		ProductStockPojo productStockPojo = null;

		try {
			productStockPojo = productStockBO.updateProductStock(input);

		} catch (Exception e) {
			System.out.println(e);
		}
		return productStockPojo;

	}

	// @GetMapping("/getSuppById/{id}")
	// public ResponseEntity<TblProducts> getCustById(@PathVariable(value =
	// "id") Long noteId) {
	// TblProducts supp = prodRep.findOne(noteId);
	// log.info("came to getCustById get method ");
	// if (supp == null) {
	// return ResponseEntity.notFound().build();
	// }
	// return ResponseEntity.ok().body(supp);
	// }
	//

	//
	// @DeleteMapping("/deleteProduct/{id}")
	// public ResponseEntity<TblProducts> deleteProduct(@PathVariable(value =
	// "id") Long prodId) {
	// TblProducts prod = prodRep.findOne(prodId);
	//
	// log.info("came to deleteProduct get method ");
	// if (prod == null) {
	// return ResponseEntity.notFound().build();
	// }
	//
	// prodRep.delete(prod);
	// return ResponseEntity.ok().build();
	// }

	// private void validateUser(String userId) {
	// this.accountRepository.findByUsername(userId).orElseThrow(
	// () -> new UserNotFoundException(userId));
	// }
}

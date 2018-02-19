package com.inven.coco.controller.details;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inven.coco.common.constants.GlobelConstant;
import com.inven.coco.model.TblSuppliers;
import com.inven.coco.pojo.details.SupplierPojo;
import com.inven.coco.repository.details.ISupplierRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/supplier")
public class SupplierController {
	
	private static final Logger log = LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	private ISupplierRepository suppRep;
	
	@RequestMapping("/hi")
	public String hi(){
		return "Hello world from restful api";
	}
	

	@RequestMapping("/findAll")
	@ResponseBody
	public List<TblSuppliers> findAll() {
		return suppRep.findAll();
	}

	@RequestMapping(value = "/addSupplier", method = RequestMethod.POST)
	public SupplierPojo add(@Valid @RequestBody SupplierPojo input) {

		log.info("came to add Supplier post method ");
		try {
			TblSuppliers supp = suppRep.save(new TblSuppliers(input.getAddress1(), input.getAddress2(), input.getCity(),
					input.getCompanyName(), input.getContactName(), input.getCountry(), input.getPhone(),
					input.getFax(), input.getPostalCode()));
			input.setSupplierId(supp.getSupplierId());
			input.setSubmitStatus(GlobelConstant.success);
			input.setResponseDesc("Insert Successfully ");
		} catch (Exception e) {
			System.out.println(e);
		}
		return input;
	}

	@GetMapping("/getSuppById/{id}")
	public ResponseEntity<TblSuppliers> getCustById(@PathVariable(value = "id") Long noteId) {
		TblSuppliers supp = suppRep.findOne(noteId);
		log.info("came to getCustById get method ");
		if (supp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(supp);
	}

	@PutMapping("/updateSupplier")
	public ResponseEntity<TblSuppliers> updateSupplier(
			@Valid @RequestBody SupplierPojo input) {

		log.info("came to updateSupplier get method ");
		try {

			// TblSuppliers cust = custRep.save(new
			// TblSuppliers(input.getAddress1(), input.getAddress2(),
			// input.getCity(),
			// input.getCompanyName(), input.getContactName(),
			// input.getCountry(), input.getPhone(),
			// input.getFax(), input.getPostalCode()));

			TblSuppliers supp = suppRep.findOne(input.getSupplierId());
			if (supp == null) {
				return ResponseEntity.notFound().build();
			}
			supp.setAddress1(input.getAddress1());
			supp.setAddress2(input.getAddress2());
			supp.setCity(input.getCity());
			supp.setCompanyName(input.getCompanyName());
			supp.setContactName(input.getContactName());
			supp.setCountry(input.getCountry());
			supp.setSupplierId(input.getSupplierId());
			supp.setFax(input.getFax());
			supp.setPhone(input.getPhone());
			supp.setPostalCode(input.getPostalCode());
			supp.setUpdatedDate(LocalDateTime.now());

			TblSuppliers updatedSupplier = suppRep.save(supp);

			// updatedSupplier.setSubmitStatus(GlobelConstant.success);
			// updatedSupplier.setResponseDesc("Insert Successfully ");

			return ResponseEntity.ok(updatedSupplier);

		} catch (Exception e) {

			log.error("update Supplier exception in : " + e);

			return ResponseEntity.notFound().build();
		}
		// return input;
	}

	@DeleteMapping("/deleteSupplier/{id}")
	public ResponseEntity<TblSuppliers> deleteSupplier(@PathVariable(value = "id") Long suppId) {
		TblSuppliers supp = suppRep.findOne(suppId);

		log.info("came to deleteSupplier get method ");
		if (supp == null) {
			return ResponseEntity.notFound().build();
		}

		suppRep.delete(supp);
		return ResponseEntity.ok().build();
	}

	// private void validateUser(String userId) {
	// this.accountRepository.findByUsername(userId).orElseThrow(
	// () -> new UserNotFoundException(userId));
	// }

}

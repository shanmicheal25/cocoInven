package com.inven.coco.controller.details;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inven.coco.service.details.ICustomerRepository;
import com.inven.coco.Application;
import com.inven.coco.common.constants.GlobelConstant;
import com.inven.coco.model.TblCustomers;
import com.inven.coco.pojo.details.CustomerPojo;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private ICustomerRepository custRep;

	@RequestMapping("/findAll")
	@ResponseBody
	public List<TblCustomers> findAll() {
		return custRep.findAll();
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public CustomerPojo add(@Valid @RequestBody CustomerPojo input) {

		log.info("came to add Customer post method ");
		try {
			TblCustomers cust = custRep.save(new TblCustomers(input.getAddress1(), input.getAddress2(), input.getCity(),
					input.getCompanyName(), input.getContactName(), input.getCountry(), input.getPhone(),
					input.getFax(), input.getPostalCode()));
			input.setCustomerId(cust.getCustomerId());
			input.setSubmitStatus(GlobelConstant.success);
			input.setResponseDesc("Insert Successfully ");
		} catch (Exception e) {
			System.out.println(e);
		}
		return input;
	}

	@GetMapping("/getCustById/{id}")
	public ResponseEntity<TblCustomers> getCustById(@PathVariable(value = "id") Long noteId) {
		TblCustomers cust = custRep.findOne(noteId);
		log.info("came to getCustById get method ");
		if (cust == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(cust);
	}

	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<TblCustomers> updateCustomer(@PathVariable(value = "id") Long custId,
			@Valid @RequestBody CustomerPojo input) {

		log.info("came to updateCustomer get method ");
		try {

			// TblCustomers cust = custRep.save(new
			// TblCustomers(input.getAddress1(), input.getAddress2(),
			// input.getCity(),
			// input.getCompanyName(), input.getContactName(),
			// input.getCountry(), input.getPhone(),
			// input.getFax(), input.getPostalCode()));

			TblCustomers cust = custRep.findOne(custId);
			if (cust == null) {
				return ResponseEntity.notFound().build();
			}
			cust.setAddress1(input.getAddress1());
			cust.setAddress2(input.getAddress2());
			cust.setCity(input.getCity());
			cust.setCompanyName(input.getCompanyName());
			cust.setContactName(input.getContactName());
			cust.setCountry(input.getCountry());
			cust.setCustomerId(custId);
			cust.setFax(input.getFax());
			cust.setPhone(input.getPhone());
			cust.setPostalCode(input.getPostalCode());

			TblCustomers updatedCustomer = custRep.save(cust);

			// updatedCustomer.setSubmitStatus(GlobelConstant.success);
			// updatedCustomer.setResponseDesc("Insert Successfully ");

			return ResponseEntity.ok(updatedCustomer);

		} catch (Exception e) {

			log.error("update customer exception in : " + e);

			return ResponseEntity.notFound().build();
		}
		// return input;
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<TblCustomers> deleteCustomer(@PathVariable(value = "id") Long custId) {
		TblCustomers cust = custRep.findOne(custId);

		log.info("came to deleteCustomer get method ");
		if (cust == null) {
			return ResponseEntity.notFound().build();
		}

		custRep.delete(cust);
		return ResponseEntity.ok().build();
	}

	// private void validateUser(String userId) {
	// this.accountRepository.findByUsername(userId).orElseThrow(
	// () -> new UserNotFoundException(userId));
	// }

}

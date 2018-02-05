package com.inven.coco.controller.details;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inven.coco.service.details.ICustomerRepository;
import com.inven.coco.common.constants.GlobelConstant;
import com.inven.coco.model.TblCustomers;
import com.inven.coco.pojo.details.CustomerPojo;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	private ICustomerRepository custRep;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public List<TblCustomers> findAll(){
		
		return custRep.findAll();
	}

	// @RequestMapping(value="/shops",method=RequestMethod.POST)
	// public void shopDetails(@RequestBody Shop shop){
	// shopService.addShopDetails(shop);
	//
	// }
	
	@RequestMapping(method = RequestMethod.POST)
	public CustomerPojo add(@RequestBody CustomerPojo input) {
		//this.validateUser(userId);

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
		return  input;

					
	}
	
	
//	private void validateUser(String userId) {
//		this.accountRepository.findByUsername(userId).orElseThrow(
//				() -> new UserNotFoundException(userId));
//	}
	
}

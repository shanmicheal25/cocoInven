package com.inven.coco.controller.details;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inven.coco.service.details.ICustomerRepository;
import com.inven.coco.model.TblCustomers;


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
}

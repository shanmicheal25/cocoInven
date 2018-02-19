package com.inven.coco.controller.order;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inven.coco.controller.product.ProductStockController;
import com.inven.coco.model.TblPurchaseorder;
import com.inven.coco.pojo.details.CustomerPojo;
import com.inven.coco.pojo.order.PurchaseOrderPojo;
import com.inven.coco.repository.order.IPurchaseOrderRepository;
import com.inven.coco.service.order.IPurchaseOrderBO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/order")
public class OrderController {

	private static final Logger log = LoggerFactory.getLogger(ProductStockController.class);

	@Autowired
	private IPurchaseOrderRepository purchaseRep;

	@Resource(name = "purchaseOrderBO")
	private IPurchaseOrderBO purchaseOrderBO;

	@RequestMapping("/hi")
	public String hi() {
		return "Hello world from restful api";
	}

	@RequestMapping("/findAll")
	@ResponseBody
	public List<PurchaseOrderPojo> findAll() {
		List<TblPurchaseorder> purchaseOrderList = purchaseRep.findAll();

		purchaseOrderList.stream().forEach(p -> System.out.println(p.getOrderId() + "   :  " + p.getTotalPrice()));

		List<PurchaseOrderPojo> purchaseOrderPojoList = purchaseOrderList.stream().map(developer -> {
			PurchaseOrderPojo pojo = new PurchaseOrderPojo();
			CustomerPojo customer = new CustomerPojo();
			try {
				BeanUtils.copyProperties(developer, pojo);
				BeanUtils.copyProperties(developer.getTblCustomers(), customer);
				pojo.setCustomerPojo(customer);
				System.out.println(pojo.getOrderId() + "   :   " + developer.getOrderId());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return pojo;
		}).collect(Collectors.toList());

		purchaseOrderPojoList.forEach(p -> System.out.println(p.getCustomerPojo()));

		// BeanUtils.copyProperties(bw.getWrappedInstance(), purchaseOrder);
		return purchaseOrderPojoList;
	}

	@RequestMapping(value = "/addProductStock", method = RequestMethod.POST)
	public PurchaseOrderPojo add(@Valid @RequestBody PurchaseOrderPojo input) {
		PurchaseOrderPojo purchaseOrderPojo = null;
		log.info("came to add Product post method ");
		try {
			// productStockPojo = purchaseOrderBO.addProduct(input);

		} catch (Exception e) {
			System.out.println(e);
		}
		return purchaseOrderPojo;
	}

	@PutMapping("/updateProductStock")
	public PurchaseOrderPojo updateProductStock(@Valid @RequestBody PurchaseOrderPojo input) {

		log.info("came to updateProduct get method ");
		PurchaseOrderPojo purchaseOrderPojo = null;

		try {
			// productStockPojo = productStockBO.updateProductStock(input);

		} catch (Exception e) {
			System.out.println(e);
		}
		return purchaseOrderPojo;

	}

}

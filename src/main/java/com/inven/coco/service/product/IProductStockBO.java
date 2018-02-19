package com.inven.coco.service.product;

import com.inven.coco.pojo.product.ProductStockPojo;

public interface IProductStockBO {

	public ProductStockPojo addProduct(ProductStockPojo input);

	public ProductStockPojo addProductStock(ProductStockPojo input);

	public ProductStockPojo updateProductStock(ProductStockPojo input);

}

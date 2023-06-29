package org.jsp.productservice.controller;

import java.util.Collections;
import java.util.List;

import org.jsp.productservice.entity.Product;
import org.jsp.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {
	
	@Autowired
	private ProductService service;

	@PostMapping("/createProduct")
	public void createProduct(@RequestBody Product product) {
		service.createProduct(product);
	}
	
	
	public void createProducts(List<Product> listOfProducts) {
	
		
	}
	
	@GetMapping("/getProductById/{altKey}")
	public @ResponseBody Product getProductById(@PathVariable("altKey") Long id) {
		Product productById = service.getProductById(id);
		System.out.println(productById);
		return productById;
	}
	
	@GetMapping("/getAllProducts")
	public @ResponseBody List<Product> getAllProducts(){
		return service.getAllProducts();
	}
	
	
	public List<Product> getProductQuantityById(Long Id) {
		return null;
	}
	
	@DeleteMapping("/deleteById/{altKey}")
	public int delteById(@RequestBody @PathVariable("altKey") Long id) {
		
		return service.deleteById(id);
	}
	
	@PostMapping("/updateProductNameById/{id}/{name}")
	public int updateProductNameById(@RequestBody@PathVariable("id") long id, @RequestBody @PathVariable("name") String name) {
		return service.updateProductNameById(id, name);
	}
	
	@GetMapping("/sortedProductListByName")
	public @ResponseBody List<Product> getAllProductsSortedByName(){
		List<Product> allProducts = getAllProducts();
		Collections.sort(allProducts,(p1,p2)->{
			return p1.getName().compareToIgnoreCase(p2.getName());
		});
		return allProducts;
	}
	
	@GetMapping("/getProductByName")
	public List<Product> getProductByName(@RequestParam("name") String name) {
		return service.getProductByName(name);
	}
	
	public List<Product> getProductInRange(double lowerPrice,double higherPrice){
		return null;
	}
}

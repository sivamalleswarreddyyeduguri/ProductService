package org.jsp.productservice.service;

import java.util.List;

import org.jsp.productservice.dto.ProductDto;
import org.jsp.productservice.entity.Product;
import org.jsp.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void createProduct(Product product) {
		productRepository.createProduct(product);
	}


	public Product getProductById(Long id) {
		return productRepository.getProductById(id);
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAllProducts();
	}
	
	public int deleteById(Long id) {
		return productRepository.deleteById(id);
	}
	
	public int updateProductNameById(long id,String name) {
		return productRepository.updateProductNameById(id, name);
	}
	
	public List<Product> getProductByName(String name){
		return productRepository.getProductByName(name);
	}
	
//	   private RestTemplate restTemplate;
//     public void placeOrder(ProductDto productDto) {
//    	 Product productEntity=new Product();
//    	 productEntity.setAltKey(productDto.getAltKey());
//    	 productEntity.setDesc(productDto.getDesc());
//    	 productEntity.setName(productDto.getName());
//    	 productEntity.setPrice(productDto.getPrice());
//    	 productEntity.setQuantity(productDto.getQuantity());
//    	 
//    	 StringBuilder urlBuilder=new StringBuilder();
//    	 urlBuilder.append("http://localhost:8080/SpringFrameWork/");
//    	 urlBuilder.append(productDto.get)
//    	 
//     }
}

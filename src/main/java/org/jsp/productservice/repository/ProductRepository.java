package org.jsp.productservice.repository;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jsp.productservice.dto.ProductDto;
import org.jsp.productservice.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

	@Autowired
	private SessionFactory factory;
	
	public void createProduct(Product product) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(product);
			transaction.commit();
		}catch(Exception e) {
			
		}
	}
	
	public Product getProductById(Long id) {
		try {
//			String hqlQuery = "from Product where id=:pId";
			Session session = factory.openSession();
//			Query query = session.createQuery(hqlQuery);
//			query.setParameter("pId", id);
			return session.get(Product.class, id);
//			return (Product) query.uniqueResult();
		}catch(Exception e) {
			
		}
		return null;
	}
	
	public List<Product> findAllProducts() {
		try {
			String hqlQuery = "from Product";
			Session session = factory.openSession();
			Query query = session.createQuery(hqlQuery);
			return query.getResultList();
			
		}catch(Exception e) {
			
		}
		return Collections.EMPTY_LIST;
		
	}
	
	public int deleteById(Long id) {
		String hqlQuery = " delete from Product where id= :pId";
		Session session = factory.openSession();
		Query query = session.createQuery(hqlQuery);
		query.setParameter("pId", id);
		Transaction transaction = session.beginTransaction();
		int update = query.executeUpdate();
		transaction.commit();
		return update;
	}
	
	public int updateProductNameById(long id,String name) {
		StringBuilder builder = new StringBuilder();
		builder.append("update Product set name= :pName where id =:pId");
		Session session = factory.openSession();
		Query query = session.createQuery(builder.toString());
		query.setParameter("pName", name);
		query.setParameter("pId", id);
		Transaction transaction = session.beginTransaction();
		int update = query.executeUpdate();
		transaction.commit();
		return update;
	}
	
	public List<Product> getProductByName(String name){
		try {
			String hqlQuery = "from Product where name= :pName";
			Session session = factory.openSession();
			Query query = session.createQuery(hqlQuery);
			query.setParameter("pName", name);
			return query.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}
	
}

package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.*;

import javax.persistence.Query;


public class HibernateTest
{
	public void addProduct(SessionFactory sessionFactory)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		com.Product product=new com.Product();
		System.out.println("Enter the ProductId:");
		product.setProductId(new java.util.Scanner(System.in).nextInt());
		System.out.println("Enter the ProductName:");
		product.setProductName(new java.util.Scanner(System.in).nextLine());
		System.out.println("Enter the ProdPrice:");
		product.setPrice(new java.util.Scanner(System.in).nextInt());
		
		session.save(product);
		transaction.commit();
		session.close();
		
		System.out.println("Save the Data Database:"+"Ok..");
	}
	
	public void displayProduct(SessionFactory sessionFactory)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("form Product");
		List<Product>listProducts=query.getResultList();
		 
		for(Product product:listProducts)
		{
			System.out.println(product.getProductName());
			System.out.println(product.getProductId());
			System.out.println(product.getPrice());
			
		}
	}
	
	
	public Product retrieveProduct(SessionFactory sessionFactory)
	{
		Scanner scanner=new Scanner (System.in);
		System.out.println("Enter the ProductId:");
		int productId;
		productId=scanner.nextInt();
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,productId );
		session.close();
			return product;
		
	}
	public void updateProduct(SessionFactory sessionFactory)
	{
		
		Product product=this.retrieveProduct(sessionFactory);
		String productName;
		int price;
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the ProductName:");
		price=scanner.nextInt();
		productName=scanner.next();
		
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(product);
		transaction.commit();
		session.close();
		
		
	}
	public void deletProduct(SessionFactory sessionFactory)
	{
		Product product=this.retrieveProduct(sessionFactory);
		int productName;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the productId:");
		productName=scanner.nextInt();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.delete(product);
		transaction.commit();
		session.close();
		
	}

	public static void main(String[] args) {
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory=config.buildSessionFactory();
	    
		HibernateTest obj=new HibernateTest();
		Scanner scanner=new Scanner(System.in);
		
		char ch;
		do
		{
			System.out.println("1.Add Product 2.Display User get 3.Update 4.Delet 5.Display");
			ch=scanner.next().charAt(0);
			switch(ch)
			{
			case '1':
				obj.addProduct(sessionFactory);
				break;
			case'2':
				Product product=obj.retrieveProduct(sessionFactory);
				System.out.println("ProductId:"+product.getProductId());
				System.out.println("ProductName:"+product.getProductName());
				System.out.println("Product Pice:"+product.getPrice());
				break;
			case'3':
				obj.updateProduct(sessionFactory);
				break;
			case'4':
				obj.deletProduct(sessionFactory);
				break;
			case'5':
				obj.displayProduct(sessionFactory);
				break;
				
			}
			System.out.println("Do you working Continu.....'y'");
			ch=scanner.next().charAt(0);
			
		}while(ch=='y');
		
		
	}

}

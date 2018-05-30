package com.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Test {
	
	static public List<Product> getProducts()
	{
		
		ArrayList<Product> products = new ArrayList<>();
		
		String selectQuery = "select * from test.product";
		
		try {
			
			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root1234");

			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				
				 Product product = new Product();
				 
				 product.setId(resultSet.getInt("id"));
				 product.setName(resultSet.getString("name"));
				 product.setPrice(resultSet.getFloat("price"));
				 product.setDescription(resultSet.getString("description"));
				 
				 products.add(product);
			}
			
		} catch (Exception e) {
			
				e.printStackTrace();
		}
		
		return products;
	}
	
	static public void addProduct(Product product) {
		
		String insertQuery = "insert into test.product(id,name,price,description)"
				+ "values(?,?,?,?)";
		
		try {
			
			Class.forName("org.gjt.mm.mysql.Driver");
			
			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root1234");
			
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setFloat(3, product.getPrice());
			preparedStatement.setString(4, product.getDescription());
			
			int noOfRows=preparedStatement.executeUpdate();
			
			if(noOfRows == 1) {
				System.out.println("record is added successfully");
			}
			
			connection.close();
			
		}catch (Exception e) {
			e.printStackTrace(); 
		}
	}

	public static void main(String[] args) {
		
		List<Product> products = getProducts();
		
		for(Product product : products)
		{
			System.out.println("Id		: "+product.getId());
			System.out.println("Name		: "+product.getName());
			System.out.println("Price		: "+product.getPrice());
			System.out.println("Description	: "+product.getDescription());
			System.out.println();
		}
		
		
		
//		Product product = new Product(5, "Chromebook", 250, "notebook google");
//		
//		addProduct(product);

	}

}

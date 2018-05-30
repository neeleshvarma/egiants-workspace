package com.mtc.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="price")
	private float price;
	
//	@ManyToOne
//	@JoinColumn(name="supplier_id")
//	private Supplier supplier;
//	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}	

	public Product(int id, String name, String description, float price) {		
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}	

	public Product(String name, String description, float price) {	
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
//	public Supplier getSupplier() {
//		return supplier;
//	}
	
//	public void setSupplier(Supplier supplier) {
//		this.supplier = supplier;
//	}
	
	@Override
	public String toString() {
		return "Id : "+id+" Name : "+name+" Price : "+price+" Desc : "+description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	

}

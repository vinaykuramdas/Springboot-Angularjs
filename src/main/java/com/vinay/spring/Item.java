package com.vinay.spring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bill")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="item")
	private String item;
	@Column(name="quantity")
	private int quantity;
	@Column(name="price")
	private int price;
	
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(String item, int quantity, int price) {
		super();
		this.item = item;
		this.quantity = quantity;
		this.price = price;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String tostring(){
		return "Items=item="+item+"quantity="+quantity+"price"+price+"listed";
	}

}

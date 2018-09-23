package com.vinay.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository  {
	@Autowired
	JdbcTemplate jdbctemp;
	
	
	public List<Item> getAllItems(){
		List<Item> items = jdbctemp.query("select * from bill", (result,rowNum)-> new Item(result.getString("item"),
				                              result.getInt("quantity"),result.getInt("price")));
		return items;
	}
	
	public Item getItem(String item){
		String query = "select * from bill where item =?";
		Item items = jdbctemp.queryForObject(query, new Object[]{item},new BeanPropertyRowMapper<>(Item.class));
		
		return items;
	}
	
	public int addItem(String item,int quantity,int price){
		String query = "insert into bill values(?,?,?)";
		return jdbctemp.update(query, item,quantity,price);
	}
	
	public int deleteItem(String item){
		String query = "delete from bill where item = ?";
		return jdbctemp.update(query, item);
	}
}

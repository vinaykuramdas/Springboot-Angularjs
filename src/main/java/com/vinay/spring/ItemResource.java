package com.vinay.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemResource {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/price/getAllItems")
	@ResponseBody
	public List<Item> getitems(){
		return itemRepository.getAllItems();
	}
	
	@GetMapping("/price/getItem")
	@ResponseBody
	public Item getItem(@RequestParam("item") String item){
		return itemRepository.getItem(item);
	}
	
	@GetMapping("/price/total")
	@ResponseBody
	public int findTotal(){
		return itemRepository.getTotal();
	}
	

	@PostMapping("/price/addItem")
	public ResponseEntity<String> addItem(@RequestBody Item item){
		if(itemRepository.addItem(item.getItem(), item.getQuantity(),item.getPrice()) >= 1){
			return new ResponseEntity<String>(HttpStatus.OK);// "Item added successfully";
		}else{
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);//"Item not added";
		}
	}
	
	@DeleteMapping("/price/deleteItem/{item}")
	@ResponseBody
	
	public String deleteItem(@PathVariable("item") String item){
		if(itemRepository.deleteItem(item)>= 1){
			return "Item deleted successfully";
		}else{
			return "Item not deleted";
		}
	}

}

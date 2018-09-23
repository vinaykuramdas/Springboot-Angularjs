package com.vinay.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Users")
public class UserController {
	
	private List<User> users = new ArrayList();
	
	public UserController() {
		// TODO Auto-generated constructor stub
		this.users = buildUsers();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUsers(){
		return this.users;
	}

	@RequestMapping(value = "/{id} ",method = RequestMethod.GET)
	public User getUser(@PathVariable("id") long id){
		return this.users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public User saveUser(@RequestBody User user) {
		Long nextId = 0L;
		if (this.users.size() != 0) {
			User lastUser = this.users.stream().skip(this.users.size() - 1).findFirst().orElse(null);
			nextId = lastUser.getId() + 1;
		}
 
		user.setId(nextId);
		this.users.add(user);
		return user;
 
	}
	
	
	@RequestMapping(method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
		User modifiedUser = this.users.stream().filter(u -> u.getId() == user.getId()).findFirst().orElse(null);
		modifiedUser.setName(user.getName());
		modifiedUser.setAge(user.getAge());
		modifiedUser.setEmail(user.getEmail());
		return modifiedUser;
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteUser(@PathVariable Long id) {
		User deleteUser = this.users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
		if (deleteUser != null) {
			this.users.remove(deleteUser);
			return true;
		} else  {
			return false;
		}
 
 
	}
	
	
	List<User> buildUsers() {
		List<User> users = new ArrayList<>();

		User user1 = buildUser(1L, "John", 22, "john@email.com");
		User user2 = buildUser(2L, "Jon", 21, "smith@email.com");
		User user3 = buildUser(3L, "Will", 24, "will@email.com");
		User user4 = buildUser(4L, "Sam", 40, "sam@email.com");
		User user5 = buildUser(5L, "Ross", 45, "ross@email.com");

		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);

		return users;

	}
	
	User buildUser(Long id, String name, int age, String email) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setAge(age);
		user.setEmail(email);
		return user;
	}

	
	
	
	
}

package com.phuocvt.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	ArrayList<User> listUser= new ArrayList<>();
	User user1 = new User();
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User addUser(@RequestBody User user) {
		user1 = user;
		listUser.add(user1);
		return user1;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ArrayList<User> showAll() {
		return listUser;
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User showUserID (@PathVariable Long id) {
		int pos = listUser.indexOf(new User(id));
		if(pos != -1) {
			return listUser.get(pos);
		}
		return null;
	}
}

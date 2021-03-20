package com.phuocvt;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	ArrayList<HelloWorldBean> list = new ArrayList<HelloWorldBean>();
	
	@PostMapping("/new")
	public HelloWorldBean post(@RequestBody HelloWorldBean model) {
		list.add(model);
		return model;
	}
	
	@GetMapping("/new")
	@ResponseBody
	public ArrayList<HelloWorldBean> getAll() {
		return list;
	}
	
	@GetMapping("test/{id}")
	public String  test(@PathVariable String id) {
		return id;
	}
}

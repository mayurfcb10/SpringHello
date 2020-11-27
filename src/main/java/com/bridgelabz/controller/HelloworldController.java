package com.bridgelabz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.model.User;

@RestController
@RequestMapping("/hello")
public class HelloworldController {
	@RequestMapping(value = { "", "/", "/home" })
	public String sayHello() {
		return "HelloWorld";
	}
	// http://localhost:8080/hello/home"

	@RequestMapping(value = { "/query" }, method = RequestMethod.GET)
	public String sayHello(@RequestParam(value = "fname") String fname, @RequestParam(value = "lname") String lname) {
		return "Hello " + fname + " "+lname;
	}
	// http://localhost:8080/hello/query/?fname=Mayur&lname=Zope
	
	@GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name) {
    	return "Hello "+ name + "!";
    }
	//http://localhost:8080/hello/param/Zope
	
	 @PostMapping("/post")
	    public String sayHello(@RequestBody User user) {
	    	return "Hello " + user.getFirstName() + " " + user.getLastName() + "!";
	    }
	 
	  @PutMapping("/put/{firstName}")
	    public String sayHelloPut(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
	    	return "Hello " + firstName + " " + lastName + "!";
	    }
}

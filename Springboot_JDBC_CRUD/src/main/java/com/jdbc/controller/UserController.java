package com.jdbc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.Userservice.UserCrud;

@RestController
public class UserController {

	@Autowired
	private UserCrud crud;

	@GetMapping("/save/{id}")
	public void selectAndSaveToaFile(@PathVariable("id") int id) throws IOException {
		this.crud.selectAndSaveToAfile(id);
	}

	@GetMapping("/select/{id}")
	public void select(@PathVariable("id") int id) {
		this.crud.select(id);
	}

	@GetMapping("/update/{name}/{id}") // can use put also here instead of get
	public void update(@PathVariable("name") String name, @PathVariable("id") int id) {

		this.crud.update(name, id);
	}

	@GetMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {

		this.crud.delete(id);
	}

}

package com.xing.springboot_02;

import com.xing.springboot_02.demo.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Springboot02Application {

	/*@Autowired
	private Person person;*/

	@RequestMapping("/")
	public String login() {

		return "login";
	}


	@RequestMapping("/index")
	public String index(Model model) {
		Person person = new Person("wangdongxing", 25);

		List<Person> personList = new ArrayList<>();
		Person p1 = new Person("guoguo", 20);
		Person p2 = new Person("guanguan", 25);
		Person p3 = new Person("jingjing", 25);
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);

		model.addAttribute("person", person);
		model.addAttribute("personList", personList);
		return  "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(Springboot02Application.class, args);
	}
}

/**
 * 
 */
package com.example.demo.trySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ELMAS
 *
 */
@Controller
public class HelloController {

	@GetMapping("/hello")
	public String getHello() {
		System.out.println("hello");
		return "hello";
	}
	
	@PostMapping("/hello")
	public String postRequest(@RequestParam("val1")String val1, Model model) {
		System.out.println("post");
		model.addAttribute("value1", val1);

		return "helloResponse";
	}
	
	@Autowired
	private HelloService helloService;
	
	@PostMapping("/hello/db")
	public String postDbRequest(@RequestParam("id")String idStr, Model model) {
		int id = Integer.parseInt(idStr);
		Employee employee = helloService.findOne(id);
		
		model.addAttribute("id", employee.getEmployeeId());
		model.addAttribute("name", employee.getEmployeeName());
		model.addAttribute("age", employee.getAge());
		
		return "helloResponseDB";
	}
}

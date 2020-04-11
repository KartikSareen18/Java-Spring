package spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String addToModel(HttpServletRequest req,Model model) {
		
		String name=req.getParameter("studentName");
		
		name=name.toUpperCase();
		
		String result="Yo! "+name;
		
		model.addAttribute("message",result);
	
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String addToModel1(@RequestParam("studentName") String name,Model model) {
		
		name=name.toUpperCase();
		
		String result="Yo! "+name;
		
		model.addAttribute("message",result);
	
		return "helloworld";
	}
	
}

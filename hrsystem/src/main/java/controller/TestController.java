package controller;

import javax.servlet.annotation.WebServlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/hahaha")
public class TestController {

	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String testAPI() {
        System.out.println("XXXXXXXXXXXXXXXXXX");
		return "TEST";
    }
	
}

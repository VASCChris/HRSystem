package controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hr.model.EmpInfoBean;
import hr.model.EmpInfoService;
import net.sf.json.JSONObject;

@Controller
@Scope("session")
@RequestMapping("/emp")
public class EmpController implements Serializable{
	@Autowired
    private EmpInfoService empInfoService;

	@RequestMapping(value = "/empsfordep", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String empsForDep(String depNum) throws Exception {
		Integer depNo = Integer.parseInt(depNum);
		return empInfoService.empListByDep(depNo).toString();
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
	public String welcome(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		JSONObject jsonObject = new JSONObject();
		
		EmpInfoBean emp = (EmpInfoBean)session.getAttribute("loginToken");
		jsonObject.put("name", emp.getName());
		
		return jsonObject.toString();
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
	public String login(HttpServletRequest request,String account ,String password) throws Exception {
		HttpSession session = request.getSession();
		JSONObject jsonObject = new JSONObject();
		
		
		if("".equals(account) || "".equals(password)) {
			jsonObject.put("result", "請輸入帳號密碼");
			return jsonObject.toString();
		}
		
		EmpInfoBean result = empInfoService.login(account, password);
		System.out.println(result);
		if(result==null) {
			jsonObject.put("result", "帳號或密碼錯誤");
		}else {
			jsonObject.put("result", "success");
			session.setAttribute("loginToken", result);
		}
		
		return jsonObject.toString();
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		JSONObject jsonObject = new JSONObject();
		
		session.removeAttribute("loginToken");
		jsonObject.put("result", "登出成功");
		
		return jsonObject.toString();
	}
}

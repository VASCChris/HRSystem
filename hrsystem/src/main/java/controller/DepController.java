package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hr.model.DepInfoBean;
import hr.model.DepInfoService;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("/dep")
public class DepController {
	@Autowired
    private DepInfoService depInfoService;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String depList() throws Exception {
		return depInfoService.depList().toString();
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
	public String depSave(String name, String supervisor) throws Exception {

		DepInfoBean bean = new DepInfoBean();
		bean.setNo(0);
		bean.setName(name);
		bean.setSupervisor(supervisor);
		Boolean result = depInfoService.insert(bean);
		if(result){
			return depInfoService.depList().toString();
		}
		return "";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
	public String depUpdate(String no, String name, String supervisor) throws Exception {
		DepInfoBean bean = new DepInfoBean();
		Integer num = Integer.parseInt(no);
		bean.setNo(num);
		bean.setName(name);
		bean.setSupervisor(supervisor);
		Boolean result = depInfoService.update(bean);
		if(result)
		  return depInfoService.depList().toString();
		else
		  return null;
	}
	
	
	@RequestMapping(value = "/depDel", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
	public String depDel(String no) throws Exception {
		
		Integer num = Integer.parseInt(no);
		
		Boolean result = depInfoService.delete(num);
		if(result)
		  return depInfoService.depList().toString();
		else
		  return null;
	}
	

}

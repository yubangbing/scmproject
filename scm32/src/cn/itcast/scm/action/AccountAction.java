package cn.itcast.scm.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;






import cn.itcast.scm.entity.Account;
import cn.itcast.scm.entity.AccountCode;
import cn.itcast.scm.entity.JsonDTO;
import cn.itcast.scm.entity.Supplier;
import cn.itcast.scm.service.AccountService;
import cn.itcast.scm.service.SmsSenderService;
@Controller
@RequestMapping("/account")
public class AccountAction {
	@Resource
	private AccountService<Account> accountService;
	@Resource
	private SmsSenderService smsSenderService;
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	@ResponseBody
	public Object insert(@RequestBody AccountCode accountCode,HttpSession session){
		JsonDTO json = new JsonDTO();
		//1 判断用户是否被注册，2判断验证码是否过期 3判断验证码是否正确 4存入
		if(accountService.selectByAccLogin(accountCode.getAccLogin())!=null){
			json.setIsabnormal(2);//2表示已经注册
			return json;
		}
		String vcodeSession = (String)session.getAttribute("vcode");
		if(vcodeSession==null){
			json.setIsabnormal(3);//3表示验证码过期
			return json;
		}
		if(!accountCode.getVcode().equals(vcodeSession)){
			json.setIsabnormal(4);//4表示验证码不相等
			return json;
		}
		Account account =new Account();
		account.setAccLogin(accountCode.getAccLogin());
		account.setAccName(accountCode.getAccName());
		account.setAccPass(accountCode.getAccPass());
		try {
			accountService.insert(account);
			return json;
		} catch (Exception e) {
			json.setIsabnormal(5);//访问数据库异常
			e.printStackTrace();
			return json;
		}
	}
	
	@RequestMapping(value="/sendcode",method=RequestMethod.POST)
	@ResponseBody
	public Object sendcode(@RequestBody Account account,HttpSession session){
		//1判断用户是否已经注册
		JsonDTO json = new JsonDTO();
		String vcode = null;
		try {
			vcode = smsSenderService.SmsSenderByTel(account.getAccLogin());
		} catch (Exception e) {
			e.printStackTrace();
			json.setIsabnormal(0);//0表示服务异常
			return json;
		}
		session.setAttribute("vcode", vcode);
		session.setMaxInactiveInterval(400);//失效时间五分钟
		json.setExistAccount(1);
		json.setIsabnormal(1);
		json.setVcode(vcode);
		return json;
		
	}
	
	   @RequestMapping(value="/login",method=RequestMethod.POST)
	   @ResponseBody
	   public Object login(@RequestBody Account account,HttpSession session){
		 JsonDTO json = new JsonDTO();
	      try {
	         //用service里面的selectUseDyc方法
	          Account accountDb=accountService.selectByAccLogin(account.getAccLogin());
	          if(accountDb==null){
	        	  json.setIsabnormal(6);//用户不存在
	        	  return json;
	          }
	          if(!account.getAccPass().equals(accountDb.getAccPass())){
	        	  json.setIsabnormal(7);//密码不正确
	        	  return json;
	          }
	          session.setAttribute("accName", accountDb.getAccName());
	          return json;
	      } catch (Exception e) {
	    	  json.setIsabnormal(5);//访问数据库出错
	          e.printStackTrace();
	          return json;
	      }
	   }

	
	
	
	
	
	
	  @RequestMapping("/doAjax")
	   @ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	   public Object doAjax(Supplier supplier){
	      System.out.println("---doAjax.supplier:"+supplier);
	      supplier.setSupName("supName返回");
	      return supplier;
	   }

}

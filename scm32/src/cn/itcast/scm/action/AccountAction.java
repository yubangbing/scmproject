package cn.itcast.scm.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.scm.entity.Account;
import cn.itcast.scm.entity.Supplier;
import cn.itcast.scm.service.AccountService;
@Controller
@RequestMapping("/account")
public class AccountAction {
	@Resource
	private AccountService<Account> accountService;
	
	@RequestMapping(value="/insert")
	public String insert(Account account){
		try {
			accountService.insert(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "forward:/jsp/main.jsp";
	}
	
	
	 @RequestMapping("/login")
	   public String login(Account account,HttpServletRequest request,HttpSession session){
	      
	      try {
	         //用service里面的selectUseDyc方法
	          List<Account> accounts=accountService.selectUseDyc(account);
	          if(accounts.size()>0){
	             session.setAttribute("account", accounts.get(0));
	             return "forward:/WEB-INF/jsp/main.jsp";
	          }
	      } catch (Exception e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	      }
	      request.setAttribute("msg", "账号或密码有错，请重新输入！");
	      return "forward:/login.jsp";
	   }

	
	
	
	
	
	
	  @RequestMapping("/doAjax")
	   @ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	   public Object doAjax(Supplier supplier){
	      System.out.println("---doAjax.supplier:"+supplier);
	      supplier.setSupName("supName返回");
	      return supplier;
	   }

}

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
		//1 �ж��û��Ƿ�ע�ᣬ2�ж���֤���Ƿ���� 3�ж���֤���Ƿ���ȷ 4����
		if(accountService.selectByAccLogin(accountCode.getAccLogin())!=null){
			json.setIsabnormal(2);//2��ʾ�Ѿ�ע��
			return json;
		}
		String vcodeSession = (String)session.getAttribute("vcode");
		if(vcodeSession==null){
			json.setIsabnormal(3);//3��ʾ��֤�����
			return json;
		}
		if(!accountCode.getVcode().equals(vcodeSession)){
			json.setIsabnormal(4);//4��ʾ��֤�벻���
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
			json.setIsabnormal(5);//�������ݿ��쳣
			e.printStackTrace();
			return json;
		}
	}
	
	@RequestMapping(value="/sendcode",method=RequestMethod.POST)
	@ResponseBody
	public Object sendcode(@RequestBody Account account,HttpSession session){
		//1�ж��û��Ƿ��Ѿ�ע��
		JsonDTO json = new JsonDTO();
		String vcode = null;
		try {
			vcode = smsSenderService.SmsSenderByTel(account.getAccLogin());
		} catch (Exception e) {
			e.printStackTrace();
			json.setIsabnormal(0);//0��ʾ�����쳣
			return json;
		}
		session.setAttribute("vcode", vcode);
		session.setMaxInactiveInterval(400);//ʧЧʱ�������
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
	         //��service�����selectUseDyc����
	          Account accountDb=accountService.selectByAccLogin(account.getAccLogin());
	          if(accountDb==null){
	        	  json.setIsabnormal(6);//�û�������
	        	  return json;
	          }
	          if(!account.getAccPass().equals(accountDb.getAccPass())){
	        	  json.setIsabnormal(7);//���벻��ȷ
	        	  return json;
	          }
	          session.setAttribute("accName", accountDb.getAccName());
	          return json;
	      } catch (Exception e) {
	    	  json.setIsabnormal(5);//�������ݿ����
	          e.printStackTrace();
	          return json;
	      }
	   }

	
	
	
	
	
	
	  @RequestMapping("/doAjax")
	   @ResponseBody //�������json��ʽ����Ҫ���ע�⣬�����������Ի���
	   public Object doAjax(Supplier supplier){
	      System.out.println("---doAjax.supplier:"+supplier);
	      supplier.setSupName("supName����");
	      return supplier;
	   }

}

package cn.itcast.scm.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.scm.entity.Page;
import cn.itcast.scm.entity.Supplier;
import cn.itcast.scm.service.SupplierService;
@Controller
@RequestMapping("/supplier")
public class SupplierAction extends BaseAction{
	@Resource
	private SupplierService<Supplier> supplierService;
	   @RequestMapping("/insert")
	   @ResponseBody
	   public Object insert(Supplier supplier){
	      int i=0;
	      try {
	           //可能异常，例如id重复，所以返回0，supplier.jsp中要增加判断
	           i = supplierService.insert(supplier);
	      } catch (Exception e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	      }
	      return i;
	   }

	
	//通过对象主键数组批量删除
	@RequestMapping("/deleteByPks")
	   @ResponseBody
	   public Object deleteByPks(String [] pks) {
	      System.out.println("---deleteByPks.pks:" + pks);
	      int i = 0;
	      try {
	          i = supplierService.deleteByPks(pks);
	      } catch (Exception e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	      }
	      return i;
	   }
	
	//通过对象主键数组批量删除
	@RequestMapping("/updateByPk")
	   @ResponseBody
	   public Object updateByPk(Supplier supplier){
	      int i=0;
	      try {
	           i = supplierService.updateByPk(supplier);
	      } catch (Exception e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	      }
	      return i;
	   }


	//通过关键字单条件（supName来查）分页查询
	@RequestMapping("/selectPage")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object selectPage(Page<Supplier> page){
		System.out.println(page.getRows());
		Page p = supplierService.selectPage(page);
		//此时这个page里包含page和rows(当前页和页大小，从jsp中传过来，且easyUI自动计算页面数)keywords,total和记录数list（查询数据库获得，放入pageMap中了）,
		//easy-UI框架的分页仅仅需要总记录数和查询的记录list（参考datagrid1.json）
		//同时这个map转为jaon格式,参考datagrid1.json）
		return page.getPageMap();
	}
	
	//通过关键字多条件分页查询
	@RequestMapping("/selectPageUseDyc")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	//supplier来存放查询条件supName和supAddress，从jsp自动封装进入suplier中
	public Object selectPageUseDyc(Page<Supplier> page,Supplier supplier){
		page.setParamEntity(supplier);
		Page p = supplierService.selectPageUseDyc(page);
		//supplier.setSupName("supName1");
		/*Map<String, Object> map =new HashMap<String, Object>();
		map.put("total",p.getTotalRecord());
		map.put("rows",p.getList());*/
		return p.getPageMap();
	}
	
/*	//通过关键字分页查询,这个方法没改进
	@RequestMapping("/selectPage")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object selectPage(Page<Supplier> page,HttpServletRequest request){
		String pageIndex=request.getParameter("page");
		String pageSize =  request.getParameter("rows");
		String keyWord =  request.getParameter("keyWord");
		System.out.println("---doAjax.page||rows||keyWord:"+pageIndex+","+pageSize+","+keyWord);

		Page<Supplier> page = new Page<Supplier>();
		page.setPageIndex(Integer.parseInt(pageIndex));
		page.setPageSize(Integer.parseInt(pageSize));
		page.setKeyWord(keyWord);
		Page p = supplierService.selectPage(page);
		System.out.println("----page:"+page);
		//supplier.setSupName("supName1");
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("total",page.getTotalRecord());
		map.put("rows",page.getList());
		return map;
	}*/
	  @RequestMapping("/doAjax")
	   @ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	   public Object doAjax(Supplier supplier){
	      System.out.println("---doAjax.supplier:"+supplier);
	      supplier.setSupName("supName返回");
	      return supplier;
	   }

}

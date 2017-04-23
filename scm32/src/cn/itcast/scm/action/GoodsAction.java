package cn.itcast.scm.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.scm.entity.Goods;
import cn.itcast.scm.entity.Page;
import cn.itcast.scm.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsAction extends BaseAction{
	@Resource
	private GoodsService<Goods> goodsService;
	@RequestMapping(value="/insert")
	public String insert(Goods entity){
		System.out.println(entity);
		try {
			goodsService.insert(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "forward:/jsp/main.jsp";
	}
	
	//通过关键字单条件（supName来查）分页查询
	@RequestMapping("/selectPage")
	@ResponseBody //如果返回json格式，需要这个注解
	public Object selectPage(Page<Goods> page){
		Page p = goodsService.selectPage(page);
		//此时这个page里包含keywords,total和记录数list（查询数据库获得，放入pageMap中了）,
		//easy-UI框架的分页仅仅需要总记录数和查询的记录list（参考datagrid1.json）
		//同时这个map转为jaon格式,参考datagrid1.json）
		return page.getPageMap();
	}
}

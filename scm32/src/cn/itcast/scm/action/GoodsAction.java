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
	
	//ͨ���ؼ��ֵ�������supName���飩��ҳ��ѯ
	@RequestMapping("/selectPage")
	@ResponseBody //�������json��ʽ����Ҫ���ע��
	public Object selectPage(Page<Goods> page){
		Page p = goodsService.selectPage(page);
		//��ʱ���page�����keywords,total�ͼ�¼��list����ѯ���ݿ��ã�����pageMap���ˣ�,
		//easy-UI��ܵķ�ҳ������Ҫ�ܼ�¼���Ͳ�ѯ�ļ�¼list���ο�datagrid1.json��
		//ͬʱ���mapתΪjaon��ʽ,�ο�datagrid1.json��
		return page.getPageMap();
	}
}

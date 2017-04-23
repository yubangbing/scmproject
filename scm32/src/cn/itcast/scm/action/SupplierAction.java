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
	           //�����쳣������id�ظ������Է���0��supplier.jsp��Ҫ�����ж�
	           i = supplierService.insert(supplier);
	      } catch (Exception e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	      }
	      return i;
	   }

	
	//ͨ������������������ɾ��
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
	
	//ͨ������������������ɾ��
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


	//ͨ���ؼ��ֵ�������supName���飩��ҳ��ѯ
	@RequestMapping("/selectPage")
	@ResponseBody //�������json��ʽ����Ҫ���ע�⣬�����������Ի���
	public Object selectPage(Page<Supplier> page){
		System.out.println(page.getRows());
		Page p = supplierService.selectPage(page);
		//��ʱ���page�����page��rows(��ǰҳ��ҳ��С����jsp�д���������easyUI�Զ�����ҳ����)keywords,total�ͼ�¼��list����ѯ���ݿ��ã�����pageMap���ˣ�,
		//easy-UI��ܵķ�ҳ������Ҫ�ܼ�¼���Ͳ�ѯ�ļ�¼list���ο�datagrid1.json��
		//ͬʱ���mapתΪjaon��ʽ,�ο�datagrid1.json��
		return page.getPageMap();
	}
	
	//ͨ���ؼ��ֶ�������ҳ��ѯ
	@RequestMapping("/selectPageUseDyc")
	@ResponseBody //�������json��ʽ����Ҫ���ע�⣬�����������Ի���
	//supplier����Ų�ѯ����supName��supAddress����jsp�Զ���װ����suplier��
	public Object selectPageUseDyc(Page<Supplier> page,Supplier supplier){
		page.setParamEntity(supplier);
		Page p = supplierService.selectPageUseDyc(page);
		//supplier.setSupName("supName1");
		/*Map<String, Object> map =new HashMap<String, Object>();
		map.put("total",p.getTotalRecord());
		map.put("rows",p.getList());*/
		return p.getPageMap();
	}
	
/*	//ͨ���ؼ��ַ�ҳ��ѯ,�������û�Ľ�
	@RequestMapping("/selectPage")
	@ResponseBody //�������json��ʽ����Ҫ���ע�⣬�����������Ի���
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
	   @ResponseBody //�������json��ʽ����Ҫ���ע�⣬�����������Ի���
	   public Object doAjax(Supplier supplier){
	      System.out.println("---doAjax.supplier:"+supplier);
	      supplier.setSupName("supName����");
	      return supplier;
	   }

}

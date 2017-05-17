package cn.itcast.scm.action;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.scm.entity.SysParam;
import cn.itcast.scm.service.SysParamService;

@Controller
@RequestMapping("/sysParam")
public class SysParamAction extends BaseAction {
	@Resource
	private SysParamService sysParamService;

	
	 @RequestMapping(value="/insert")
	 @ResponseBody //�������json��ʽ����Ҫ���ע�⣬�����������Ի���	 
	public Object insert(SysParam sysParam){
		 //��ӵ����ݿ��ϵͳ������
		 
		 reloadSysParam();
		
		 return null;
	}
	
	
	
	//��߿����������¼��ز���
	@RequestMapping(value="/reload")
	@ResponseBody
	public void reloadSysParam() {
		loadSysParam();
	}
	
	//ϵͳ����ʱ���ز���
	@PostConstruct
	public void initSysParam(){
		loadSysParam();
	}
	
	//��������ϵͳ����	
	public void loadSysParam(){
		Map<String, Object> sysParamMap = sysParamService.selectList();
		application.setAttribute("sysParam", sysParamMap);
		System.out.println("===================ϵͳ�������سɹ�2=====================");
	}
	

}

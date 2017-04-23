package cn.itcast.scm.action;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/base")
public class BaseAction {

	@Resource
	ServletContext application;

	// ��������folderͨ��@PathVariableָ����ֵ���Դ�@RequestMapping��{folder}��ȡ��ͬ��fileҲһ��
	// ��ʱ����action�е���ת�Ͳ���Ҫ��
	@RequestMapping("/goURL/{folder}/{file}")
	// @PathVariable��֤���������������RequestMapping�л��
	public String goURL(@PathVariable String folder, @PathVariable String file) {
		return "forward:/WEB-INF/" + folder + "/" + file + ".jsp";
	}
	

}

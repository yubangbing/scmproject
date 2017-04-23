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

	// 方法参数folder通过@PathVariable指定其值可以从@RequestMapping的{folder}获取，同理file也一样
	// 此时其他action中的跳转就不需要了
	@RequestMapping("/goURL/{folder}/{file}")
	// @PathVariable保证下面的两个参数从RequestMapping中获得
	public String goURL(@PathVariable String folder, @PathVariable String file) {
		return "forward:/WEB-INF/" + folder + "/" + file + ".jsp";
	}
	

}

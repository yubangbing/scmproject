package cn.itcast.scm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.scm.service.SmsSenderService;
import cn.itcast.scm.sms.SmsSender;


/**
 * 短信发�?业务�?
 * @author CodeJStudio
 * @2017�?�?2�?
 */
@Service
public class SmsSenderServiceImpl implements SmsSenderService {
	@Resource
	private SmsSender smsSender;

	@Override
	public String SmsSenderByTel(String telephone) {
		return smsSender.sender(telephone);
	}
}

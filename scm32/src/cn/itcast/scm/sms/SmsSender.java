package cn.itcast.scm.sms;


import org.springframework.stereotype.Repository;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudTopic;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.common.ServiceException;
import com.aliyun.mns.model.BatchSmsAttributes;
import com.aliyun.mns.model.MessageAttributes;
import com.aliyun.mns.model.RawTopicMessage;
import com.aliyun.mns.model.TopicMessage;

@Repository
public class SmsSender {
	private static String accessKeyId = "LTAIIidlN1oyk1QB";
	private static String accessKeySecret = "2Zn2jIe2vUk4kI6FWpPOW7S8yp4HqK";
    private static String MNSEndpoint = "http://1949593639925471.mns.cn-hangzhou.aliyuncs.com/";
    private static String myTopic = "sms.topic-cn-hangzhou";
    private static String signName = "城市管理系统网站";
    private static String SMSTemplateCode = "SMS_67156169";
    private static String SMSTemplateParamKey1 = "name";
   // private static String receiverPhoneNumber1 = "13162219002";
    
    public String sender(String phoneNum) {
		/**
         * Step 1. 获取主题引用
         */
        CloudAccount account = new CloudAccount(accessKeyId, accessKeySecret, MNSEndpoint);
        MNSClient client = account.getMNSClient();
        CloudTopic topic = client.getTopicRef(myTopic);
        /**
         * Step 2. 设置SMS消息体（必须）
         *
         * 注：目前暂时不支持消息内容为空，需要指定消息内容，不为空即可。
         */
        RawTopicMessage msg = new RawTopicMessage();
        msg.setMessageBody("sms-message");
        
        /**
         * Step 3. 生成SMS消息属性
         */
        MessageAttributes messageAttributes = new MessageAttributes();
        BatchSmsAttributes batchSmsAttributes = new BatchSmsAttributes();
        // 3.1 设置发送短信的签名（SMSSignName）
        batchSmsAttributes.setFreeSignName(signName);
        // 3.2 设置发送短信使用的模板（SMSTempateCode）
        batchSmsAttributes.setTemplateCode(SMSTemplateCode);
        // 3.3 设置发送短信所使用的模板中参数对应的值（在短信模板中定义的，没有可以不用设置）
        BatchSmsAttributes.SmsReceiverParams smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();
        String vcode = RandomUtil.random();
        smsReceiverParams.setParam(SMSTemplateParamKey1, vcode);
        //smsReceiverParams.setParam("$YourSMSTemplateParamKey2", "$value2");
        // 3.4 增加接收短信的号码
        batchSmsAttributes.addSmsReceiver(phoneNum, smsReceiverParams);
        //batchSmsAttributes.addSmsReceiver("$YourReceiverPhoneNumber2", smsReceiverParams);
        messageAttributes.setBatchSmsAttributes(batchSmsAttributes);
        
        try {
            /**
             * Step 4. 发布SMS消息
             */
            TopicMessage ret = topic.publishMessage(msg, messageAttributes);
            //System.out.println("MessageId: " + ret.getMessageId());
            //System.out.println("MessageMD5: " + ret.getMessageBodyMD5());
            //return vcode;
        } catch (ServiceException se) {
            System.out.println(se.getErrorCode() + se.getRequestId());
            System.out.println(se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        client.close();
		return vcode;
	}
}

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
    private static String signName = "���й���ϵͳ��վ";
    private static String SMSTemplateCode = "SMS_67156169";
    private static String SMSTemplateParamKey1 = "name";
   // private static String receiverPhoneNumber1 = "13162219002";
    
    public String sender(String phoneNum) {
		/**
         * Step 1. ��ȡ��������
         */
        CloudAccount account = new CloudAccount(accessKeyId, accessKeySecret, MNSEndpoint);
        MNSClient client = account.getMNSClient();
        CloudTopic topic = client.getTopicRef(myTopic);
        /**
         * Step 2. ����SMS��Ϣ�壨���룩
         *
         * ע��Ŀǰ��ʱ��֧����Ϣ����Ϊ�գ���Ҫָ����Ϣ���ݣ���Ϊ�ռ��ɡ�
         */
        RawTopicMessage msg = new RawTopicMessage();
        msg.setMessageBody("sms-message");
        
        /**
         * Step 3. ����SMS��Ϣ����
         */
        MessageAttributes messageAttributes = new MessageAttributes();
        BatchSmsAttributes batchSmsAttributes = new BatchSmsAttributes();
        // 3.1 ���÷��Ͷ��ŵ�ǩ����SMSSignName��
        batchSmsAttributes.setFreeSignName(signName);
        // 3.2 ���÷��Ͷ���ʹ�õ�ģ�壨SMSTempateCode��
        batchSmsAttributes.setTemplateCode(SMSTemplateCode);
        // 3.3 ���÷��Ͷ�����ʹ�õ�ģ���в�����Ӧ��ֵ���ڶ���ģ���ж���ģ�û�п��Բ������ã�
        BatchSmsAttributes.SmsReceiverParams smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();
        String vcode = RandomUtil.random();
        smsReceiverParams.setParam(SMSTemplateParamKey1, vcode);
        //smsReceiverParams.setParam("$YourSMSTemplateParamKey2", "$value2");
        // 3.4 ���ӽ��ն��ŵĺ���
        batchSmsAttributes.addSmsReceiver(phoneNum, smsReceiverParams);
        //batchSmsAttributes.addSmsReceiver("$YourReceiverPhoneNumber2", smsReceiverParams);
        messageAttributes.setBatchSmsAttributes(batchSmsAttributes);
        
        try {
            /**
             * Step 4. ����SMS��Ϣ
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

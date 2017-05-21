package cn.itcast.scm.sms;

/**
 * 生成随机�?
 * @author yubangbing
 * @2017�?�?2�?
 */
public class RandomUtil {

	/**
	 * 生成随机�?
	 * 
	 * @return
	 */
	public static String random() {
		String str = "";
		str += (int) (Math.random() * 9 + 1);
		for (int i = 0; i < 5; i++) {
			str += (int) (Math.random() * 10);
		}
		int num = Integer.parseInt(str);
		System.out.println(num);
		return str;
	}
}

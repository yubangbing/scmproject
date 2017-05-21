package cn.itcast.scm.entity;

import java.io.Serializable;

public class JsonDTO implements Serializable{
	private static final long serialVersionUID = 1;
	
	private Integer existAccount = 1;
	private String vcode;
	private Integer isabnormal = 1;
	public Integer getExistAccount() {
		return existAccount;
	}
	public void setExistAccount(Integer existAccount) {
		this.existAccount = existAccount;
	}
	public String getVcode() {
		return vcode;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	public Integer getIsabnormal() {
		return isabnormal;
	}
	public void setIsabnormal(Integer isabnormal) {
		this.isabnormal = isabnormal;
	}
	@Override
	public String toString() {
		return "JsonDTO [existAccount=" + existAccount + ", vcode=" + vcode + ", isabnormal=" + isabnormal + "]";
	}
}

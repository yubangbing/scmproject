package cn.itcast.scm.entity;

import java.io.Serializable;

public class AccountCode implements Serializable{
    private Integer accId;

    private String accLogin;

    private String accName;

    private String accPass;

    private String vcode;
    public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public String getAccLogin() {
        return accLogin;
    }

    public void setAccLogin(String accLogin) {
        this.accLogin = accLogin;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccPass() {
        return accPass;
    }

    public void setAccPass(String accPass) {
        this.accPass = accPass;
    }

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", accLogin=" + accLogin
				+ ", accName=" + accName + ", accPass=" + accPass + "]";
	}
    
}
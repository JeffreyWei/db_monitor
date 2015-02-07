package com.founder.entity;

public class ConnectionLog {
	private String aliasName;
	private Integer sum;
	private Integer fail;
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	
	public Integer getFail() {
		return fail;
	}
	public void setFail(Integer fail) {
		this.fail = fail;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
}

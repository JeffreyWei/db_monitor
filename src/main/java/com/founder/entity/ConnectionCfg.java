package com.founder.entity;

public class ConnectionCfg {
	private Integer id;
	private Integer typeId;
	private String type;
	private String address;
	private Integer port;
	private String instance;
	private String conName;
	private String conPwd;
	private String statement;
	private String aliasName;
	private String valid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getInstance() {
		return instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}

	public String getConName() {
		return conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	public String getConPwd() {
		return conPwd;
	}

	public void setConPwd(String conPwd) {
		this.conPwd = conPwd;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

}

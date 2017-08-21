package com.yeehaw.message.common.httpClient.header;

public enum HeaderEnum {
	
	JSON("Content-Type","application/json;charset=utf-8"),
	;
	private String name;
	private String value;
	
	HeaderEnum(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static HeaderEnum getEnum(String name) {
		HeaderEnum[] enums = HeaderEnum.values();
		for(HeaderEnum e:enums) {
			if(name.equals(e.getName())) {
				return e;
			}
		}
		return null;
	}
	
	
}

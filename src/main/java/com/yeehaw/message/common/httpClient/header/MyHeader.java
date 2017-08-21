package com.yeehaw.message.common.httpClient.header;

import java.io.Serializable;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.BasicLineFormatter;

@SuppressWarnings("serial")
public class MyHeader implements Header ,Serializable {
	
	private  String name;
	private  String value;
	
	
	public MyHeader(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public MyHeader(HeaderEnum e) {
		this.name = e.getName();
		this.value = e.getValue();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		// no need for non-default formatting in toString()
		return BasicLineFormatter.INSTANCE.formatHeader(null, this).toString();
	}

	@Override
	public HeaderElement[] getElements() throws ParseException {
		if (this.value != null) {
			// result intentionally not cached, it's probably not used again
			return BasicHeaderValueParser.parseElements(this.value, null);
		} else {
			return new HeaderElement[] {};
		}
	}

}

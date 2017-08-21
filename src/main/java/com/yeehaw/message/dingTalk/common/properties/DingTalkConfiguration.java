package com.yeehaw.message.dingTalk.common.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class DingTalkConfiguration {
	
	public static String corpid ="ding47827e5a5b1ed1dd35c2f4657eb6378f";
	public static String corpsecret = "zVMLlkxI70ZNqepMlWBkVnOd1bBX9yErGmlP2q-Lh7MzVzOms2hfnLA62omtK8vV";
	public static Integer agentid = 121833395;
	
	public DingTalkConfiguration() {
	}

	public static String getCorpid() {
		return corpid;
	}
	
	@Value("${dingtalk.corpid}")
	public void setCorpid(String corpid) {
		DingTalkConfiguration.corpid = corpid;
	}

	public static String getCorpsecret() {
		return corpsecret;
	}
	
	@Value("${dingtalk.corpsecret}")
	public  void setCorpsecret(String corpsecret) {
		DingTalkConfiguration.corpsecret = corpsecret;
	}

	public static Integer getAgentid() {
		return agentid;
	}
	
	@Value("${dingtalk.agentid}")
	public void setAgentid(Integer agentid) {
		DingTalkConfiguration.agentid = agentid;
	}

	
}

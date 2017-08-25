package com.yeehaw.message.common.util;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {

	private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	private static final String DATE_TIME_PATTERN_NOSPLIT = "yyyyMMddHHmmss";
	public static final Gson gson = new Gson();
	/**
	 * 能将json中的日期相关的数据进行转换
	 */
	public static final Gson gsonDate = new GsonBuilder().setDateFormat(DATE_TIME_PATTERN).disableHtmlEscaping().create();

	public static final Gson gsonDateNoSplit = new GsonBuilder().setDateFormat(DATE_TIME_PATTERN_NOSPLIT).disableHtmlEscaping().create();
	/**
	 * 避免Gson使用时将一些字符自动转换为Unicode转义字符
	 */
	// public static final Gson gsonUnicode = new
	// GsonBuilder().disableHtmlEscaping().create();

	/**
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T from(String json, Class<T> clazz) {
		return gsonDate.fromJson(json, clazz);
	}

	public static <T> String to(T t) {
		return gsonDate.toJson(t);
	}

	/**
	 * 解析Json字符串成对象
	 * 
	 * @param json
	 *            Json字符串， NoSplit 指Date格式为yyyyMMddHHmmss
	 * @param clazz
	 * @return
	 */
	public static <T> T fromNoSplit(String json, Class<T> clazz) {
		return gsonDateNoSplit.fromJson(json, clazz);
	}

	public static <T> String toNoSplit(T t) {
		return gsonDateNoSplit.toJson(t);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, String> toMap(String jsonString) {
		Map<String, String> data = new HashMap<String, String>();

		return gsonDate.fromJson(jsonString, data.getClass());
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> toObjectMap(String jsonString) {
		Map<String, Object> data = new HashMap<String, Object>();

		return gsonDate.fromJson(jsonString, data.getClass());
	}
	
}

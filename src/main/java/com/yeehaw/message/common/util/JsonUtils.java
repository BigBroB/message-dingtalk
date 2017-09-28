package com.yeehaw.message.common.util;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonUtils {

	private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	private static final String DATE_TIME_PATTERN_NOSPLIT = "yyyyMMddHHmmss";
	public static final Gson gson = new Gson();
	/**
	 * 能将json中的日期相关的数据进行转�?
	 */
	public static final Gson gsonDate = new GsonBuilder().setDateFormat(DATE_TIME_PATTERN).disableHtmlEscaping()
			.create();

	public static final Gson gsonDateNoSplit = new GsonBuilder().setDateFormat(DATE_TIME_PATTERN_NOSPLIT)
			.disableHtmlEscaping().create();

	public static final Gson gsonDateAll = new GsonBuilder()
			.registerTypeAdapter(Date.class, new ImprovedDateTypeAdapter()).create();
	/**
	 * Gson gson = new GsonBuilder() //序列化null .serializeNulls() //
	 * 设置日期时间格式，另有2个重载方法 // 在序列化和反序化时均生效 .setDateFormat("yyyy-MM-dd") // 禁此序列化内部类
	 * .disableInnerClassSerialization() //生成不可执行的Json（多了 )]}' 这4个字符）
	 * .generateNonExecutableJson() //禁止转义html标签 .disableHtmlEscaping() //格式化输出
	 * .setPrettyPrinting() .create();
	 */
	/**
	 * 避免Gson使用时将�?些字符自动转换为Unicode转义字符
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

	public static Map<String, String> toMap(String jsonString) {
		return gsonDate.fromJson(jsonString, new TypeToken<Map<String, String>>() {
		}.getType());
	}

	public static Map<String, Object> toMapObject(String jsonString) {
		return gsonDate.fromJson(jsonString, new TypeToken<Map<String, Object>>() {}.getType());
	}

	public static Map<String, Object> toObjectMap(String jsonString) {
		return gsonDate.fromJson(jsonString, new TypeToken<Map<String, Object>>() {}.getType());
	}

	public static <T> RestResult<T> fromJsonObject(String jsonString, Class<T> clazz) {
		Type type = new ParameterizedTypeImpl(RestResult.class, new Class[] { clazz });
		return gsonDate.fromJson(jsonString, type);
	}

	public static <T> RestResult<List<T>> fromJsonArray(String jsonString, Class<T> clazz) {
	    Type listType = new ParameterizedTypeImpl(List.class, new Class[]{clazz});
	    Type type = new ParameterizedTypeImpl(RestResult.class, new Type[]{listType});
	    return gsonDate.fromJson(jsonString, type);
	}

	
}

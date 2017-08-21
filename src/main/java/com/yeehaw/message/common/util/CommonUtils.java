package com.yeehaw.message.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {
	/**
	 * 检查对象是否为空
	 * 
	 * @param obj
	 *            java任意类型
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;

		} else if (obj instanceof String && (obj.toString().trim().equals(""))) {
			return true;

		} else if (obj instanceof Number && ((Number) obj).doubleValue() < 0) {
			return true;

		} else if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
			return true;

		} else if (obj instanceof Map && ((Map) obj).isEmpty()) {
			return true;

		} else if (obj instanceof Object[] && ((Object[]) obj).length == 0) {
			return true;

		}
		return false;
	}

	/**
	 * 检查n个对象是否为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object... obj) {
		boolean res = false;
		for (Object o : obj) {
			if (isEmpty(o)) {
				res = true;
				break;
			}
		}
		return res;
	}

	/**
	 * 
	 * 
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean hasLength(Object obj, int length) {

		if (obj == null) {
			return false;

		} else if (obj instanceof String) {
			return obj.toString().trim().length() == length;

		} else if (obj instanceof Collection) {
			return ((Collection) obj).size() == length;

		} else if (obj instanceof Map) {
			return ((Map) obj).size() == length;

		} else if (obj instanceof Object[]) {
			return ((Object[]) obj).length == length;

		}

		return false;

	}

	/**
	 * 检查对象是否不为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

	/**
	 * 检查对象是否不为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNotEmpty(Object... obj) {
		boolean res = true;
		for (Object o : obj) {
			if (isEmpty(o)) {
				res = false;
			}
		}
		return res;
	}

	/**
	 * 克隆一个对象
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static Object cloneObject(Object obj) throws Exception {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(byteOut);
		out.writeObject(obj);
		ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
		ObjectInputStream in = new ObjectInputStream(byteIn);
		return in.readObject();
	}

	/**
	 * 判断是否为中文
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}

	public static boolean isChinese(String str) {
		if (null != str && str.length() > 0) {
			char[] chares = str.toCharArray();
			for (char c : chares) {
				if (isChinese(c))
					return true;
			}
		} else
			return false;

		return false;
	}

	/**
	 * 判断是否为中文乱码
	 * 
	 * @param strName
	 * @return
	 */
	public static boolean hasMessyCode(String target) {
		Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
		Matcher m = p.matcher(target);
		String after = m.replaceAll("");
		String temp = after.replaceAll("}", "");
		char[] ch = temp.trim().toCharArray();
		float chLength = ch.length;
		float count = 0;
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (!Character.isLetterOrDigit(c)) {

				if (!isChinese(c)) {
					count = count + 1;
				}
			}
		}
		float result = count / chLength;
		if (result > 0.4) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 生成N位随机数
	 * 
	 * @return
	 */
	public static String getRandom(int N) {
		int[] rand = new int[N];
		StringBuffer numString = new StringBuffer();
		for (int i = 0; i < rand.length; i++) {
			rand[i] = (Integer) new Random().nextInt(9);
			numString.append(rand[i]);
		}
		return numString.toString();
	}

	/**
	 * 同类对象属性复制(private,public) 复制出来的为新对象
	 * 
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public static Object copyThisToNewOne(Object object) throws Exception {
		Class<?> classType = object.getClass();
		Object obj = classType.getConstructor(new Class[] {}).newInstance(new Object[] {});
		Field[] fields = classType.getDeclaredFields();
		for (Field field : fields) {
			if (Modifier.isPrivate(field.getModifiers())) {// 只需要私有字段
				String name = field.getName();
				String firstLetter = name.substring(0, 1).toUpperCase();
				String getMethodName = "get" + firstLetter + name.substring(1);
				String setMethodName = "set" + firstLetter + name.substring(1);
				Method getMethod = classType.getMethod(getMethodName, new Class[] {});
				Method setMethod = classType.getMethod(setMethodName, new Class[] { field.getType() });
				Object value = getMethod.invoke(object, new Object[] {});
				if (value != null) {
					setMethod.invoke(obj, new Object[] { value });
				}
			} else {
				System.out.println(field.get(object));
				obj.getClass().getField(field.getName()).set((Object) obj, field.get(object));
			}
		}
		return obj;
	}

	/**
	 * 同类对象属性复制(private,public) 把2个已有的对象属性进行复制 此方法src代表来源数据对象，
	 * result代表要把src中的属性复制到的对象
	 * 
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public static Object copyThisToAnother(Object src, Object result) throws Exception {
		Class<?> classType = src.getClass();
		Object obj = classType.getConstructor(new Class[] {}).newInstance(new Object[] {});
		Field[] fields = classType.getDeclaredFields();
		for (Field field : fields) {
			if (Modifier.isPrivate(field.getModifiers())) {// 只需要私有字段
				String name = field.getName();
				String firstLetter = name.substring(0, 1).toUpperCase();
				String getMethodName = "get" + firstLetter + name.substring(1);
				String setMethodName = "set" + firstLetter + name.substring(1);
				Method getMethod = classType.getMethod(getMethodName, new Class[] {});
				Method setMethod = classType.getMethod(setMethodName, new Class[] { field.getType() });
				Object value = getMethod.invoke(src, new Object[] {});
				if (value != null) {
					setMethod.invoke(result, new Object[] { value });
				}
			} else {
				System.out.println(field.get(src));
				obj.getClass().getField(field.getName()).set(result, field.get(src));
			}
		}
		return result;
	}

	public static String getRandomString(int length) { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public static String getUpperStringRandom(int length) { // length表示生成字符串的长度

		return getRandomString(length).toUpperCase();
	}

	/**
	 * 数字随机码码
	 * 
	 * @param length
	 * @return
	 */
	public static String getDigitRandom(int length) { // length表示生成字符串的长度
		String base = "0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public static String getFormatParam(Object... obj) { // length表示生成字符串的长度

		StringBuffer sb = new StringBuffer();
		for (Object o : obj) {
			if (CommonUtils.isEmpty(sb.toString()))
				sb.append(o.toString());
			else
				sb.append("," + o.toString());

		}
		return sb.toString();
	}

	/**
	 * 获取一个时间格式的编号
	 * 
	 * @param random
	 * @return yyyyMMddHHmmss + random(bit)
	 */
	public static String getIdentityByTime(int random) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		return dateFormat.format(date) + getDigitRandom(random);
	}

	public static String getUUID(boolean hasSplit) {
		UUID uuid = UUID.randomUUID();
		return hasSplit ? uuid.toString() : uuid.toString().replace("-", "");
	}

}

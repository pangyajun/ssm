package com.utils.json;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


import com.oaec.entity.Price;
import com.oaec.entity.SaleConfig;
import com.oaec.entity.Spec;
import com.oaec.entity.SpecValue;
import com.oaec.entity.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * @author Mr.pang
 *
 * @date 2018年3月6日 下午1:56:13
 */
public class JesonUtils {

	/**
	 * JSON转对象
	 * @param str 字符串格式json
	 * @param clazz 类对象
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T jsonToObject(String str,Class<T> clazz) {
		JSONObject jsonObject=JSONObject.fromObject(str);
		T t = (T) JSONObject.toBean(jsonObject, clazz);	
		return  t;
	}

	/**
	 * 把json格式数据转化成对象
	 * 属性为集合的属性名必须是(list+class名)
	 * @param str
	 * @param clazz 主类
	 * @param classes 属性为集合的所有类数组
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T jsonToObject(String str,Class<T> clazz,Class<T> ...classes) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		JSONObject jsonObject=JSONObject.fromObject(str);
		T t = (T) JSONObject.toBean(jsonObject, clazz);				
		Method[] methods = t.getClass().getMethods();
		List<Method> listMethod=new ArrayList<>();
		for (Method method : methods) {
			if(method.getName().startsWith("List",3))listMethod.add(method);
		}
		if(listMethod.size()==0)return t;	
		for (Method method : listMethod) {
			for (Class<T> class1:classes) {				
				if(method.getName().equals("getList"+class1.getSimpleName())) {
					Object invoke = method.invoke(t);
					List<T> list=new ArrayList<>();
					 for (Object object :(List<T>)invoke) {	
						 T bean = (T) JSONObject.toBean(JSONObject.fromObject(object),class1);
						 T bean1 = (T) jsonToObject(JSONObject.fromObject(bean).toString(),(Class<T>) bean.getClass(),classes);
						 list.add(bean1);						 	
					}
					for (Method method1 : listMethod) {						
						if(method1.getName().equals("setList"+class1.getSimpleName()))
							method1.invoke(t, list);
					}					
				}
			}			
		}		
		return  t;
	}
	/**
	 * JSON转map
	 * @param str
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<Object,Object>  jsonToMap(String str) {
		Map<Object,Object> map= JSONObject.fromObject( JSONObject.fromObject(str));
			return map;
		}
     	
	
	/**
	 * JSON转List
	 * @param str
	 * @param clazz 类对象
	 * @return list
	 */
	@SuppressWarnings("unchecked")
	public static    <T> T  jsonToList(String str,Class<T> clazz){
		JSONArray jsonArray=JSONArray.fromObject(str);
		 List<T> array = (List<T>) JSONArray.toCollection(jsonArray, clazz);
		return (T) array ;
	}
	
	/**
	 *JSON转数组
	 * @param str
	 * @param clazz 类对象
	 * @return list
	 */
	@SuppressWarnings("unchecked")
	public static  <T> T[]  JsonToArray(String str,Class<T> clazz) {
		JSONArray jsonArray=JSONArray.fromObject(str);
		T[] array = (T[]) JSONArray.toArray(jsonArray,clazz);
		return  (T[]) array ;

	}
	
	/**
	 * @param object 
	 * @return
	 */
	public static String ObjectToJson(Object object) {	

		if (object instanceof List||object instanceof Map||object instanceof Set||object.getClass().isArray()) {
				return JSONArray.fromObject(object).toString();
		}else {
				return JSONObject.fromObject(object).toString();
		}
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String str="{\"listPrice\":[{\"bonus_percent\":5,\"max_number\":99,\"min_number\":50,\"origin_price\":3.12,\"sell_price\":3.28},{\"bonus_percent\":5,\"max_number\":999,\"min_number\":100,\"origin_price\":3,\"sell_price\":3.15},{\"bonus_percent\":5,\"max_number\":0,\"min_number\":1000,\"origin_price\":2.4,\"sell_price\":2.52}],\"listSpec\":[{\"listSpecValue\":[{\"name\":\"颜色\",\"value\":\"白色\"},{\"name\":\"颜色\",\"value\":\"白色\"},{\"name\":\"颜色\",\"value\":\"白色\"}]}],\"moq\":50}";		
		String str1="{\"listPrice\":[{\"bonus_percent\":5,\"max_number\":99,\"min_number\":50,\"origin_price\":3.12,\"sell_price\":3.28},{\"bonus_percent\":5,\"max_number\":0,\"min_number\":1000,\"origin_price\":2.4,\"sell_price\":2.52}],\"listSpec\":[{\"listSpecValue\":[{\"listUser\":[{\"name\":\"小明\",\"age\":18},{\"name\":\"小花\",\"age\":18}],\"name\":\"颜色\",\"value\":\"白色\"},{\"listUser\":[{\"name\":\"小明\",\"age\":18},{\"name\":\"小花\",\"age\":18}],\"name\":\"颜色\",\"value\":\"白色\"}]}],\"moq\":50}"; 
		Class[] clazz= {Price.class,Spec.class,SpecValue.class,User.class};
		 SaleConfig jsonToObject1 = jsonToObject(str1, SaleConfig.class, clazz);
		 System.out.println(jsonToObject1.getListPrice());
		//System.out.println(str1);
		
	}
}

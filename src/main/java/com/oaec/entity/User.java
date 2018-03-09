/**
 * @data 2018年3月8日下午4:58:35
 */
package com.oaec.entity;
/**
*@author Mr.Pang
*
*@version 2018年3月8日 下午4:58:35
*/

import java.util.List;

/**
 * @author Mr.pang
 *
 * @date 2018年3月8日 下午4:58:35
 */
public class User {
	private String name;
	private Integer age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
}

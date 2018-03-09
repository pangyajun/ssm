/**
 * @data 2018年3月8日上午11:25:59
 */
package com.oaec.entity;

import java.util.List;

/**
*@author Mr.Pang
*
*@version 2018年3月8日 上午11:25:59
*/

/**
 * @author Mr.pang
 *
 * @date 2018年3月8日 上午11:25:59
 */
public class SpecValue {
	private String name;
	private String value;
	private List<User> listUser;
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
	
	public List<User> getListUser() {
		return listUser;
	}
	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}
	@Override
	public String toString() {
		return "SpecValue [name=" + name + ", value=" + value + ", listUser=" + listUser + "]";
	}
	
	
}

/**
 * @data 2018年3月7日上午11:24:12
 */
package com.oaec.entity;
/**
*@author Mr.Pang
*
*@version 2018年3月7日 上午11:24:12
*/

import java.util.List;

/**
 * @author Mr.pang
 *
 * @date 2018年3月7日 上午11:24:12
 */
public class Spec {
	
	private List<SpecValue> listSpecValue;

	public List<SpecValue> getListSpecValue() {
		return listSpecValue;
	}

	public void setListSpecValue(List<SpecValue> listSpecValue) {
		this.listSpecValue = listSpecValue;
	}

	@Override
	public String toString() {
		return "Spec [listSpecValue=" + listSpecValue + "]";
	}
	
	
}

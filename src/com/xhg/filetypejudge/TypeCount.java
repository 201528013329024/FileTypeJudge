/**
 * @author Haoguang Xu
 * 
 * Copyright (c) 2016, UCAS
 * All rights reserved. 
 * 
 * TypeCount Class {@link TypeCount}:����ͳ�Ƹ��ļ����ͳ��ֵ���Ŀ
 */

package com.xhg.filetypejudge;

public class TypeCount {
	String typename; // �ļ�����
	int count; // ���ִ���

	public TypeCount(String typename, int count) {
		this.typename = typename;
		this.count = count;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}

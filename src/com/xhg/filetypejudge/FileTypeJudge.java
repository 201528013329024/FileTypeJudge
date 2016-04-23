/**
 * @author Haoguang Xu
 * 
 * Copyright (c) 2016, UCAS
 * All rights reserved. 
 * 
 * FileTypeJudge Class {@link FileTypeJudge}���ж��ļ����� 
 */

package com.xhg.filetypejudge;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileTypeJudge {

	private FileTypeJudge() {

	}

	/**
	 * ���ļ�ͷת����16�����ַ���
	 * 
	 * @param ԭ��byte
	 * @return 16�����ַ���
	 */

	private static String bytesToHexString(byte[] src) {

		StringBuilder stringBuilder = new StringBuilder();

		if (src == null || src.length <= 0) {
			return null;
		}

		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	/**
	 * �õ��ļ�ͷ
	 * 
	 * @param filePath
	 *            �ļ�·��
	 * @return �ļ�ͷ
	 * @throws IOException
	 */
	private static String getFileContent(String filePath) throws IOException {

		byte[] b = new byte[15];

		InputStream inputStream = null;

		try {
			inputStream = new FileInputStream(filePath);
			inputStream.read(b, 0, b.length);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw e;
				}
			}
		}
		return bytesToHexString(b);
	}

	/**
	 * �ж��ļ�����
	 * 
	 * @param filePath
	 *            �ļ�·��
	 * @return �ļ�����
	 */
	public static FileType getType(String filePath) throws IOException {

		String fileHead = getFileContent(filePath);

		if (fileHead == null || fileHead.length() == 0) {
			return null;
		}

		fileHead = fileHead.toLowerCase(); // ��ΪFileType.java��ÿ�����͵��ļ�ͷ��Ϣȫ������Сд��ע

		FileType[] fileTypes = FileType.values();

		for (FileType type : fileTypes) {
			if (fileHead.startsWith(type.getValue())
					|| type.getValue().startsWith(fileHead)) {
				return type;
			}
		}

		return null;
	}
}
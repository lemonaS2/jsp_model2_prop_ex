package org.smart.control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExam {
	/*
	 * ��� : Properties������ ������ Properties��ü ����
	 * �Ķ���� : ��ũ���� ���
	 * ���� �� : Properties ��ü
	 */ 
	public static Properties loadProperties(String path){
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
			prop.load(fis); 
		
		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}
}

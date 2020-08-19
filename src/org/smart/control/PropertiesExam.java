package org.smart.control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExam {
	/*
	 * 기능 : Properties파일을 읽은후 Properties객체 생성
	 * 파라미터 : 디스크상의 경로
	 * 리턴 값 : Properties 객체
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

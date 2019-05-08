package com.joe.md5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Md5Tset {
//C:\\Users\\Superred\\Desktop\\vpn.png
	public static void main(String[] args) {
		while (true) {
			try {
				Scanner s = new Scanner(System.in);
				System.out.print("�����ļ�·����");
				String path = s.nextLine();

				File file = new File(path);
				FileInputStream fis = new FileInputStream(file);
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] buffer = new byte[1024];
				int length = -1;
				while ((length = fis.read(buffer, 0, 1024)) != -1) {
					md.update(buffer, 0, length);
				}
				BigInteger bigInt = new BigInteger(1, md.digest());
				String fileName = file.getName();
				System.out.println("�ļ����ǣ�" + fileName);
				System.out.println("�ļ�md5ֵ�ǣ�" + bigInt.toString(16));
				getFileSize1(file);
				
				System.out.println("�Ƿ����(q�س��˳�)......");
				Scanner t=new Scanner(System.in);
				String go=t.nextLine();
				if(go.equals("q")) {
					break;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * ��ȡ�ļ�����
	 * 
	 * @param file
	 */
	public static void getFileSize1(File file) {
		if (file.exists() && file.isFile()) {

			System.out.println("�ļ��Ĵ�С�ǣ�" + file.length() + " byte");
		}
	}
	

}
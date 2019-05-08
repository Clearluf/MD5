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
				System.out.print("输入文件路径：");
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
				System.out.println("文件名是：" + fileName);
				System.out.println("文件md5值是：" + bigInt.toString(16));
				getFileSize1(file);
				
				System.out.println("是否继续(q回车退出)......");
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
	 * 获取文件长度
	 * 
	 * @param file
	 */
	public static void getFileSize1(File file) {
		if (file.exists() && file.isFile()) {

			System.out.println("文件的大小是：" + file.length() + " byte");
		}
	}
	

}
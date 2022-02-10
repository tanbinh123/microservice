package com.javaweb.util.help.statistics;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Objects;

import com.javaweb.constant.CommonConstant;

public class CodeLineCount {
	
	//E:\\A.java或E:\\a
	public int codeCount(String filePath) throws Exception{
		if(!Objects.equals(CommonConstant.NULL_VALUE,filePath)){//过滤null传参
			File file = new File(filePath);
			if(file.exists()){//过滤文件不存在
				listFile(file);//递归列出文件
			}
		}
		return this.total;
	}
	
	private int total = 0;
	private void listFile(File file) throws Exception{
		if(file.isDirectory()){
			File files[] = file.listFiles();
			for(File each:files){
				listFile(each);
			}
		}else{
			if(file.getName().endsWith(".java")){
				this.total+=getLineNumber(file);
			}
		}
	}
	
	private int getLineNumber(File file) throws Exception{
		InputStream inputStream = new FileInputStream(file);
		LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream,"UTF-8"));
		String line = null;
		int count = 0; 
		boolean multiLine = false;
		while((line=lineNumberReader.readLine())!=null){
			if(Objects.equals(line.trim(),CommonConstant.EMPTY_VALUE)){
				//do nothing
			}else if(line.trim().startsWith("/*")&&line.trim().endsWith("*/")){
				//do nothing
			}else if(line.trim().startsWith("//")){
				//do nothing
			}else if(line.trim().startsWith("/*")){
				multiLine = true;
			}else if(line.trim().endsWith("*/")){
				multiLine = false;
			}else{
				if(!multiLine){
					count+=1;
				}
			}
		}
		lineNumberReader.close();
		inputStream.close();
		return count;
	}

}

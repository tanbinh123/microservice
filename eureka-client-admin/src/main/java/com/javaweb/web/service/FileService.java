package com.javaweb.web.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.file.FileContentListRequest;
import com.javaweb.web.eo.file.FileListRequest;
import com.javaweb.web.po.User;

public interface FileService {
	
	List<String> uploadFile(MultipartFile multipartFile[],String rootPath,User user) throws Exception;
	
	Page list(FileListRequest fileListRequest);

	Page contentList(FileContentListRequest fileContentListRequest);
	
	com.javaweb.web.po.File fileDetail(String id);
	
	void fileDelete(String id);
	
}

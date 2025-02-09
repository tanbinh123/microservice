package com.javaweb.web.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.javaweb.base.BaseDao;
import com.javaweb.base.BaseInject;
import com.javaweb.constant.CommonConstant;
import com.javaweb.constant.SystemConstant;
import com.javaweb.db.query.QueryWapper;
import com.javaweb.util.core.FileUtil;
import com.javaweb.util.core.NumberFormatUtil;
import com.javaweb.util.core.ObjectOperateUtil;
import com.javaweb.util.core.PageUtil;
import com.javaweb.util.core.SystemUtil;
import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.file.FileContentListRequest;
import com.javaweb.web.eo.file.FileContentListResponse;
import com.javaweb.web.eo.file.FileListRequest;
import com.javaweb.web.eo.file.FileListResponse;
import com.javaweb.web.po.User;
import com.javaweb.web.service.FileService;

@Service("fileServiceImpl")
public class FileServiceImpl extends BaseDao implements FileService {

	@Transactional
	@Override
	public List<String> uploadFile(MultipartFile multipartFile[],String rootPath,User user) throws Exception {
		final String fileSerNo = UUID.randomUUID().toString();//文件批次号（同一批次上传的多个文件的批次号应该相同）
		List<String> list = new ArrayList<>();
		if(multipartFile!=null&&multipartFile.length>0){
    		for(int i=0;i<multipartFile.length;i++){
    			String id = idGenerator.idCreate();//文件唯一ID
    			String originFileName = multipartFile[i].getOriginalFilename();//原上传文件名称
    			String newFileName = UUID.randomUUID().toString()+"_"+originFileName;//新文件名称
    			String filePath = rootPath+newFileName;//文件全路径
    			FileUtil.writeFile(multipartFile[i].getInputStream(),new byte[1024],new File(filePath));
    			com.javaweb.web.po.File fileEntity = new com.javaweb.web.po.File();
    			fileEntity.setId(id);
    			fileEntity.setSystemId(SystemConstant.SYSTEM_NO);
    			fileEntity.setFileUniqueIndex(UUID.randomUUID().toString());
    			fileEntity.setOriginFileName(originFileName);
    			fileEntity.setCurrentFileName(newFileName);
    			fileEntity.setFilePath(rootPath);
    			fileEntity.setFileFullPath(filePath);
    			fileEntity.setFileSuffix(fileEntity.getOriginFileName().split("\\.")[fileEntity.getOriginFileName().split("\\.").length-1]);
    			fileEntity.setFileSize(multipartFile[i].getSize());
    			fileEntity.setFileUnit("byte");
    			fileEntity.setFileSerNo(fileSerNo);
    			fileEntity.setFileUseType(2);
    			fileEntity.setCreator(user.getCreator());
    			fileEntity.setCreateDate(new Date());
    			fileDao.insert(fileEntity);
    			list.add(id);
    		}
    	}
		return list;
	}

	@Override
	public Page list(FileListRequest fileListRequest) {
		QueryWapper<com.javaweb.web.po.File> queryWapper = new QueryWapper<>();
		queryWapper.like(com.javaweb.web.po.File.originFileNameColumn,fileListRequest.getFileName());
		queryWapper.page(fileListRequest.getCurrentPage(),fileListRequest.getPageSize());
		List<com.javaweb.web.po.File> list = fileDao.selectList(queryWapper);
		Long count = fileDao.selectListCount(queryWapper);
		List<FileListResponse> fileListResponseList = ObjectOperateUtil.copyListProperties(list,FileListResponse.class);
		fileListResponseList.stream().forEach(e->e.setFileSizeAndFileUnit(NumberFormatUtil.getdefaultFormatCapacity(new BigDecimal(e.getFileSize()))));
		Page page = new Page(fileListRequest,fileListResponseList,count);
		return page;
	}
	
	@Override
	public Page contentList(FileContentListRequest fileContentListRequest) {
		String fileFolderPath = fileContentListRequest.getFolderPath();
		if(fileFolderPath==null||CommonConstant.EMPTY_VALUE.equals(fileFolderPath)){//默认根路径
			if(SystemUtil.isLinux()){
				fileFolderPath = "/";
			}else{
				fileFolderPath = BaseInject.getFileRootPath().split(":\\\\")[0]+":\\";
			}
		}
		List<File> fileList = FileUtil.getAllFilesName(new File(fileFolderPath),new ArrayList<>(),false,false);
		long count = (fileList==null?0L:fileList.size());
		List<FileContentListResponse> responseList = new ArrayList<>(); 
		fileList = PageUtil.getSubList(fileList,fileContentListRequest.getPageSize(),fileContentListRequest.getCurrentPage());
		if(fileList!=null){
			for(int i=0;i<fileList.size();i++){
				FileContentListResponse fileContentListResponse = new FileContentListResponse();
				File eachFile = fileList.get(i);
				if(eachFile.isFile()){//文件
					String tempPath = fileFolderPath.replaceAll("\\\\","\\\\\\\\");
					if(!tempPath.endsWith("\\\\")){
						tempPath += "\\\\"; 
					}
					QueryWapper<com.javaweb.web.po.File> queryWapper = new QueryWapper<>();
					queryWapper.eq(com.javaweb.web.po.File.currentFileNameColumn,eachFile.getName());
					queryWapper.eq(com.javaweb.web.po.File.fileFullPathColumn,(tempPath+eachFile.getName()));
					com.javaweb.web.po.File fileDetail = fileDao.selectOne(queryWapper);
					if(fileDetail!=null){
						fileContentListResponse.setId(fileDetail.getId());
						fileContentListResponse.setCreateDate(fileDetail.getCreateDate());
						fileContentListResponse.setFileSizeAndFileUnit(NumberFormatUtil.getdefaultFormatCapacity(new BigDecimal(fileDetail.getFileSize())));
						fileContentListResponse.setFilePath(fileDetail.getFileFullPath());
						fileContentListResponse.setOriginFileName(fileDetail.getOriginFileName());
					}
				}
				fileContentListResponse.setFile(eachFile.isFile());//是否是文件
				fileContentListResponse.setName(eachFile.getName());//文件或目录名称
				fileContentListResponse.setFileAbsolutePath(eachFile.getAbsolutePath());//文件绝对路径
				responseList.add(fileContentListResponse);
			}
		}
		Page page = new Page(fileContentListRequest,responseList,count);
		return page;
	}

	@Override
	public com.javaweb.web.po.File fileDetail(String id) {
		return fileDao.selectByPk(id);
	}
	
	@Transactional
	@Override
	public void fileDelete(String id){
		String ids[] = id.split(CommonConstant.COMMA);
		for(String eachId:ids){
			com.javaweb.web.po.File file = fileDao.selectByPk(eachId);
			if(file.getFileFullPath()!=null){
				new File(file.getFileFullPath()).delete();//文件不存在也不会报错的
			}
			fileDao.delete(eachId);
		}
	}

}

package com.javaweb.util.core;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.ClientAnchor.AnchorType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.javaweb.constant.CommonConstant;

//使用对象封装，对象的属性需要为封装类型
public class PoiXssfExcelUtil {
	
	//遍历所有sheet
	public static Object[] readAllExcelSheet(InputStream inputStream,int skipLines) throws IOException {
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
		int sheets = xssfWorkbook.getNumberOfSheets();
		Object[] objects = new Object[sheets];
		for(int i=0;i<sheets;i++){
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(i);
			objects[i] = readSheet(xssfSheet,skipLines);
		}
		xssfWorkbook.close();
		return objects;
	}
	
	//根据sheet名字遍历单个sheet
	public static List<List<String>> readSingleExcelSheet(InputStream inputStream,int skipLines,String sheetName) throws IOException {
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);
		List<List<String>> list = readSheet(xssfSheet,skipLines);
		xssfWorkbook.close();
		return list;
	}
	
	//根据sheet名字遍历单个sheet
	public static <T> List<T> readSingleExcelSheet(InputStream inputStream,String sheetName,int skipLines,Map<Integer,String> map,Class<T> objectClass) throws Exception {
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);
		List<T> list = readSheet(xssfSheet,skipLines,map,objectClass);
		xssfWorkbook.close();
		return list;
	}
	
	//根据sheet序号遍历单个sheet
	public static List<List<String>> readSingleExcelSheet(InputStream inputStream,int sheetIndex,int skipLines) throws IOException {
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheetIndex);
		List<List<String>> list = readSheet(xssfSheet,skipLines);
		xssfWorkbook.close();
		return list;
	}
	
	//根据sheet序号遍历单个sheet
	public static <T> List<T> readSingleExcelSheet(InputStream inputStream,int sheetIndex,int skipLines,Map<Integer,String> map,Class<T> objectClass) throws Exception {
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheetIndex);
		List<T> list = readSheet(xssfSheet,skipLines,map,objectClass);
		xssfWorkbook.close();
		return list;
	}
	
	//写入Excel
	public static void writeExcelData(OutputStream outputStream,List<List<String>> data,String sheetName) throws IOException{
		XSSFWorkbook xssfWorkbook = writeSheetData(data,sheetName);
		xssfWorkbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
		xssfWorkbook.close();
	}
	
	//写入Excel
	public static void writeExcelData(HttpServletResponse response,List<List<String>> data,String sheetName,String fileName) throws IOException{
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition","attachment;filename="+fileName+".xlsx");
		ServletOutputStream outputStream = response.getOutputStream();
		XSSFWorkbook xssfWorkbook = writeSheetData(data,sheetName);
		xssfWorkbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
		response.flushBuffer();
		xssfWorkbook.close();
	}
	
	//写入Excel
	public static void writeExcelObject(OutputStream outputStream,List<Object> data,List<String> headers,String sheetName) throws Exception{
		XSSFWorkbook xssfWorkbook = writeSheetObject(data,headers,sheetName);
		xssfWorkbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
		xssfWorkbook.close();
	}
	
	//写入Excel
	public static void writeExcelObject(HttpServletResponse response,List<Object> data,List<String> headers,String sheetName,String fileName) throws Exception{
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition","attachment;filename="+fileName+".xlsx");
		ServletOutputStream outputStream = response.getOutputStream();
		XSSFWorkbook xssfWorkbook = writeSheetObject(data,headers,sheetName);
		xssfWorkbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
		response.flushBuffer();
		xssfWorkbook.close();
	}
	
	//读取每个sheet里的数据
	public static List<List<String>> readSheet(XSSFSheet xssfSheet,int skipLines){
		int rows = xssfSheet.getPhysicalNumberOfRows();
		List<List<String>> rowList = new ArrayList<>();
		for(int i=0+skipLines;i<rows;i++){//遍历每一行
			XSSFRow row = xssfSheet.getRow(i);
			if(row==null){
				continue;
			}
			int cells = row.getPhysicalNumberOfCells();
			List<String> cellList = new ArrayList<>();
			for(int j=0;j<cells;j++){//遍历每一列
				//处理合并单元格
				//if(isMergedRegion(xssfSheet,i,j)){
				//	cellList.add(getMergedRegionValue(xssfSheet,i,j));
				//}else{
					XSSFCell cell = row.getCell(j);
					if(cell==null){
						cellList.add(CommonConstant.EMPTY_VALUE);
					}else{
						cell.setCellType(CellType.STRING);
						String cellValue = cell.getStringCellValue();
						cellList.add(cellValue);
					}
				//}
			}
			rowList.add(cellList);
		}
		return rowList;
	}
	
	//读取每个sheet里的数据
	public static <T> List<T> readSheet(XSSFSheet xssfSheet,int skipLines,Map<Integer,String> map,Class<T> objectClass) throws Exception{
		int rows = xssfSheet.getPhysicalNumberOfRows();
		List<T> rowList = new ArrayList<>();
		for(int i=0+skipLines;i<rows;i++){//遍历每一行
			T target = objectClass.newInstance();
			XSSFRow row = xssfSheet.getRow(i);
			if(row==null){
				continue;
			}
			Set<Integer> set = map.keySet();
			for(Integer each:set){
				XSSFCell cell = row.getCell(each);
				if(cell==null){
					continue;
				}
				cell.setCellType(CellType.STRING);//无论什么类型都先转为String
				String fieldName = map.get(each);
				Class<?> fieldType = objectClass.getDeclaredField(fieldName).getType();
				fieldName = fieldName.substring(0,1).toUpperCase()+fieldName.substring(1,fieldName.length());
				Method method = target.getClass().getDeclaredMethod("set"+fieldName,fieldType);
				if("java.lang.Integer".equals(fieldType.getName())){
					method.invoke(target,Integer.parseInt(cell.toString()));
				}else if("java.lang.Long".equals(fieldType.getName())){
					method.invoke(target,Long.parseLong(cell.toString()));
				}else if("java.lang.Float".equals(fieldType.getName())){
					method.invoke(target,Float.parseFloat(cell.toString()));
				}else if("java.lang.Double".equals(fieldType.getName())){
					method.invoke(target,Double.parseDouble(cell.toString()));
				}else{
					method.invoke(target,cell.toString());
				}
			}
			rowList.add(target);
		}
		return rowList;
	}
	
	//写入每个sheet里的数据
	public static XSSFWorkbook writeSheetData(List<List<String>> data,String sheetName){
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		XSSFSheet xssfSheet = xssfWorkbook.createSheet(sheetName);
		//xssfSheet.setDefaultRowHeightInPoints(20);//行高（一般设置了内容自动换行，不建议设置行高）
		xssfSheet.setDefaultColumnWidth(20);//列宽
		//xssfSheet.addMergedRegion(new CellRangeAddress(0,0,0,8));//合并单元格：起始行,截至行,起始列,截至列
		//XSSFDrawing drawingPatriarch = xssfSheet.createDrawingPatriarch();//画图的顶级管理器，一个sheet只能获取一个
		XSSFCellStyle xssfCellStyle = xssfWorkbook.createCellStyle();
		xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);//左右居中
		xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//上下居中
		xssfCellStyle.setWrapText(true);//设置内容自动换行
		XSSFRow[] rows = new XSSFRow[data.size()];
		for(int i=0;i<data.size();i++){
			List<String> columns = data.get(i);
			rows[i] = xssfSheet.createRow(i);
			//xssfSheet.setDefaultColumnWidth(columnWidth);//设置列的长度
			XSSFCell[] cells = new XSSFCell[columns.size()];
			for(int j=0;j<columns.size();j++){
				cells[j] = rows[i].createCell(j);
				//cells[j].setCellStyle(XSSFCellStyle);
				cells[j].setCellValue(columns.get(j));
			}
		}
		return xssfWorkbook;
	}
	
	//写入每个sheet里的数据
	public static XSSFWorkbook writeSheetObject(List<Object> data,List<String> headers,String sheetName) throws Exception {
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		XSSFSheet xssfSheet = xssfWorkbook.createSheet(sheetName);
		//xssfSheet.setDefaultRowHeightInPoints(20);//行高（一般设置了内容自动换行，不建议设置行高）
		xssfSheet.setDefaultColumnWidth(20);//列宽
		//xssfSheet.addMergedRegion(new CellRangeAddress(0,0,0,8));//合并单元格：起始行,截至行,起始列,截至列
		//XSSFDrawing drawingPatriarch = xssfSheet.createDrawingPatriarch();//画图的顶级管理器，一个sheet只能获取一个
		XSSFCellStyle xssfCellStyle = xssfWorkbook.createCellStyle();
		xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);//左右居中
		xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//上下居中
		xssfCellStyle.setWrapText(true);//设置内容自动换行
		XSSFRow[] rows = new XSSFRow[headers==null?data.size():data.size()+1];
		int count = 0;
		if(headers!=null){
			XSSFCell[] cells = new XSSFCell[headers.size()];
			rows[count] = xssfSheet.createRow(count);
			for(int m=0;m<headers.size();m++){
				cells[m] = rows[count].createCell(m);
				cells[m].setCellValue(headers.get(m));
				cells[m].setCellStyle(getXssfCellStyle(xssfWorkbook,xssfCellStyle,false,new XSSFFont()));
			}
			count++;
		}
		for(int i=0;i<data.size();i++,count++){
			Object classes = data.get(i);
			Object target = classes.getClass().newInstance();
			Field[] fields = target.getClass().getDeclaredFields();
			rows[count] = xssfSheet.createRow(count);
			//xssfSheet.setDefaultColumnWidth(columnWidth);//设置列的长度
			XSSFCell[] cells = new XSSFCell[fields.length];
			for(int j=0;j<fields.length;j++){
				String fieldName = fields[j].getName();
				fieldName = fieldName.substring(0,1).toUpperCase()+fieldName.substring(1,fieldName.length());
				Method method = target.getClass().getDeclaredMethod("get"+fieldName,new Class[]{});
				cells[j] = rows[count].createCell(j);
				Object value = method.invoke(classes,new Object[]{});
				if(value instanceof Double){
					cells[j].setCellValue(new Double(value.toString()));
				}else if(value instanceof Integer){
					cells[j].setCellValue(new Integer(value.toString()));
				}else if(value instanceof Float){
					cells[j].setCellValue(new Float(value.toString()));
				}else if(value instanceof Date){
					cells[j].setCellValue(DateUtil.dateToLocalDateTime((Date)value).format(DateTimeFormatter.ofPattern(DateUtil.DEFAULT_DATETIME_PATTERN)));
				}else{
					cells[j].setCellValue(value.toString());
				}
			}
		}
		return xssfWorkbook;
	}
	
	/**
	 * 插入行
	 * @param xssfSheet XSSFSheet对象，可以通过xssfWorkbook.getSheet(sheetName)获取
	 * @param startRow 从第几行开始（下标0开始，如要插入第一行startRow=0，如要插入末尾startRow=xssfSheet.getLastRowNum()+1）
	 * @param expandRowNum 要扩展的行数
	 * @return XSSFRow[] 扩展的行对象
	 */
	/** 使用示例
	XSSFRow[] r1 = expandRow(xssfSheet,0,1);//头部插入1行
	for(int i=0;i<r1.length;i++){
		XSSFCell[] cells = new XSSFCell[headers.size()];
		for(int m=0;m<headers.size();m++){
			cells[m] = r1[i].createCell(m);
			cells[m].setCellValue("head");
		}
	}
	XSSFRow[] r2 = expandRow(xssfSheet,xssfSheet.getLastRowNum()+1,2);//尾部插入2行
	for(int i=0;i<r2.length;i++){
		XSSFCell[] cells = new XSSFCell[headers.size()];
		for(int m=0;m<headers.size();m++){
			cells[m] = r2[i].createCell(m);
			cells[m].setCellValue("tail");
		}
	}
	XSSFRow[] r3 = expandRow(xssfSheet,1,3);//中间（比如第2行）插入3行，此时下标应该是2-1=1
	for(int i=0;i<r3.length;i++){
		XSSFCell[] cells = new XSSFCell[headers.size()];
		for(int m=0;m<headers.size();m++){
			cells[m] = r3[i].createCell(m);
			cells[m].setCellValue("middle");
		}
	}
	*/
	public static XSSFRow[] expandRow(XSSFSheet xssfSheet,int startRow,int expandRowNum){
		XSSFRow[] rows = new XSSFRow[expandRowNum];
		xssfSheet.shiftRows(startRow,expandRowNum+xssfSheet.getLastRowNum()-1,expandRowNum,true,false);
		for(int i=0;i<expandRowNum;i++){
			rows[i] = xssfSheet.createRow(startRow+i);
		}
		return rows;
	}
	
	//判断指定的单元格是否是合并单元格
	public static boolean isMergedRegion(Sheet sheet,int row,int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if(row >= firstRow && row <= lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    return true;
                }
            }
        }
        return false;
    }
	
	//获取合并单元格的值
	public static String getMergedRegionValue(Sheet sheet,int row,int column){
        int sheetMergeCount = sheet.getNumMergedRegions();
        for(int i = 0 ; i < sheetMergeCount ; i++){
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();
            if(row >= firstRow && row <= lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    if(fCell == null){
                    	return CommonConstant.EMPTY_VALUE;
                    }
                    return fCell.getStringCellValue();
                }
            }
        }
        return null;
    }
	
	//自定义样式
    public static XSSFCellStyle getXssfCellStyle(XSSFWorkbook xssfWorkbook,XSSFCellStyle xssfCellStyle,boolean title,XSSFFont xssfFont) {
        if(title){
        	xssfCellStyle = xssfWorkbook.createCellStyle();
        	xssfFont = xssfWorkbook.createFont();
        }
        xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//单元格-垂直居中
        xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);//单元格-水平居中
        xssfCellStyle.setBorderBottom(BorderStyle.THIN);//设置单元格的下边框为粗体
        xssfCellStyle.setBorderLeft(BorderStyle.THIN);//设置单元格的左边框为粗体
        xssfCellStyle.setBorderRight(BorderStyle.THIN);//设置单元格的右边框为粗体
        xssfCellStyle.setBorderTop(BorderStyle.THIN);//设置单元格的上边框为粗体
        //xssfCellStyle.setWrapText(true);//设置自动换行
        xssfFont.setFontName("微软雅黑");//名称-微软雅黑
        if(title){
        	xssfFont.setBold(true);
        	xssfFont.setFontHeightInPoints((short)13);//字体高度13
        }else{
        	xssfFont.setBold(false);
        	xssfFont.setFontHeightInPoints((short)10);//字体高度10
        }
        xssfCellStyle.setFont(xssfFont);//设置字体
        xssfCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        xssfCellStyle.setFillForegroundColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
        return xssfCellStyle;
    }
    
    /**
     * 获取图片
     * @param xssfWorkbook XSSFWorkbook
     * @param pictureUrlPath 图片链接
     * @param imageType 图片类型（如：png）
     * @param pictureIndexInExcelCell 图片在excel的第几个单元格（下标从0开始）
     * @param pictureIndexSelf 第几张图片（下标从0开始）
     * @param startRow 从第几行开始（下标从1开始）
     * @throws Exception 异常
     */
    public static void setPicture(XSSFWorkbook xssfWorkbook,XSSFDrawing drawingPatriarch,String pictureUrlPath,String imageType,short pictureIndexInExcelCell,short pictureIndexSelf,int startRow) throws Exception {
    	URL url = new URL(pictureUrlPath);
    	DataInputStream dataInputStream = new DataInputStream(url.openStream());
    	BufferedImage bufferedImage = ImageIO.read(dataInputStream);
    	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    	ImageIO.write(bufferedImage,imageType,byteArrayOutputStream);
    	XSSFClientAnchor anchor = new XSSFClientAnchor(0,0,1023,255,(short)(pictureIndexInExcelCell+pictureIndexSelf),startRow,(short)(pictureIndexInExcelCell+pictureIndexSelf),startRow);
        anchor.setAnchorType(AnchorType.DONT_MOVE_DO_RESIZE);
        drawingPatriarch.createPicture(anchor,xssfWorkbook.addPicture(byteArrayOutputStream.toByteArray(),XSSFWorkbook.PICTURE_TYPE_PNG));
        dataInputStream.close();
    }

}

//package support.yz.data.mvc.service.impl;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.commons.lang3.StringEscapeUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.poi.ss.usermodel.*;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.util.ResourceUtils;
//
//import lombok.extern.slf4j.Slf4j;
//import support.yz.data.mvc.service.inter.ITextDataSourceService;
//
//@Service
//@Slf4j
//public class TextDataSourceService implements ITextDataSourceService {
//
//	@Value("${spring.datasource.busi.url}")
//	private String url;
//
//	@Value("${spring.datasource.busi.username}")
//	private String username;
//
//	@Value("${spring.datasource.busi.password}")
//	private String password;
//	/**
//	 * 上传文件
//	 */
//	@Override
//	public TextDataPreview upload(File file,String suffixName) throws Exception {
//		if(!suffixName.equals(".csv")){ // 判断文件类型
//			FileInputStream in = new FileInputStream(file);
//			Workbook workbook = WorkbookFactory.create(in);
//			Sheet sheet = workbook.getSheetAt(0);
//			List<List<Object>> excelPreview = new ArrayList<List<Object>>(); // excel文件预览数据
//			List<String> typePreview = new ArrayList<String>(); // csv每列数值类型
//			List<String> head = new ArrayList<String>(); // 表头数据
//			int i = 0;
//			for(Row row : sheet){
//				int j = 0;
//				if(isRowEmpty(row))
//					continue;
//				List<Object> col = new ArrayList<Object>(typePreview.size()); // 每一行的数据
//				for(Cell cell : row){
//					int type = cell.getCellType(); // 每个单元格的数据类型
//					if(cellIsEmpty(cell))
//						continue;
//	                if(i!=0){ // 表头不计算类型
//	                	if(!typePreview.get(j).equals("string")){
//	                		switch (type) {
//		        	        case Cell.CELL_TYPE_NUMERIC:
//		        	        	SimpleDateFormat sdf = null;
//		        	        	if(cell.getCellStyle().getDataFormat() == 180 || cell.getCellStyle().getDataFormat() == 176){
//		        	        		sdf = new SimpleDateFormat("yyyy-MM-dd");
//		        	        		Date date = cell.getDateCellValue();
//		        	        		col.add(sdf.format(date));
//		        	        		typePreview.set(j, "date");
//		        	        	} else if(cell.getCellStyle().getDataFormat() == 181|| cell.getCellStyle().getDataFormat() == 177){
//		        	        		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		        	        		Date date = cell.getDateCellValue();
//		        	        		col.add(sdf.format(date));
//		        	        		typePreview.set(j, "date");
//		        	        	} else {
//		        	        		typePreview.set(j, "number");
//		        	        		col.add(cell.getNumericCellValue());
//		        	        	}
//		        	            break;
//	        	            default:
//	        	            	if(regDate(cell.getStringCellValue())){
//	        	            		typePreview.set(j, "date");
//	        	            	} else {
//	        	            		typePreview.set(j, "string");
//	        	            	}
//	        	            	col.add(cell.getStringCellValue());
//	        	            	break;
//		                	}
//	                	} else {
//	                		switch (type) {
//		        	        case Cell.CELL_TYPE_NUMERIC:
//		        	        	col.add(String.valueOf(cell.getNumericCellValue()));
//		        	            break;
//	        	            default:
//	        	            	col.add(cell.getStringCellValue());
//	        	            	break;
//		                	}
//	                	}
//	                } else {
//	                	switch (type) {
//	        	        case Cell.CELL_TYPE_NUMERIC:
//	        	        	typePreview.add("number");
//	        	        	head.add(String.valueOf(cell.getNumericCellValue()));
//	        	            break;
//        	            default:
//    	            		typePreview.add("number");
//    	            		head.add(cell.getStringCellValue());
//        	            	break;
//	                	}
//	                }
//					j ++ ;
//				}
//				if(i!=0){
//					excelPreview.add(col);
//				}
//				if(i >= 98){
//					break;
//				}
//				i ++;
//			}
//			in.close();
//			workbook.close();
//			TextDataPreview preview = new TextDataPreview();
//			preview.setFileId(file.getName());
//			preview.setPreview(excelPreview);
//			preview.setHead(head);
//			removeEmpty(typePreview);
//			preview.setType(typePreview);
//			return preview;
//		} else {
//			BufferedReader reader = null;
//			try {
//				List<List<Object>> csvPreview = new ArrayList<List<Object>>();// csv文件预览数据
//				List<String> typePreview = new ArrayList<String>();// csv每列数值类型
//				List<String> head = null; // 表头数据
//				InputStreamReader inStream = new InputStreamReader(new FileInputStream(file), resolveCode(file));
//	            reader = new BufferedReader(inStream);
//	            String line = null;
//	            int i = 0;
//	            while((line=reader.readLine())!=null){
//	                String item[] = line.split(",");
//	                if(StringUtils.isBlank(StringUtils.join(item, ""))){
//	                	continue;
//	                }
//	                if(i!=0){ // 表头不计算类型
//	                	for(int j=0;j<item.length;j++){
//	                		if(!typePreview.get(j).equals("string")){
//	                			if(isNumeric(item[j])){
//	                				typePreview.set(j, "number");
//			                	} else if(regDate(item[j])){
//			                		typePreview.set(j, "date");
//			                	} else {
//			                		typePreview.set(j, "string");
//			                	}
//	                		}
//		                }
//	                } else {
//	                	String[] array=new String[line.split(",").length];
//	            		Arrays.fill(array, "number");
//	                	head = Arrays.asList(line.split(","));
//	                	typePreview = Arrays.asList(array);
//	                }
//	                if(i!=0){
//	                	csvPreview.add(Arrays.asList(item));
//					}
//	                i++;
//	            }
//	            reader.close();
//	            TextDataPreview preview = new TextDataPreview();
//				preview.setFileId(file.getName());
//				preview.setHead(head);
//				preview.setPreview(csvPreview);
//				preview.setType(typePreview);
//	            return preview;
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//			return null;
//		}
//	}
//
//	/**
//	 * 删除上传文件方法
//	 */
//	@Override
//	public String delete(String path,int operation,String accId) throws Exception {
//		File file = new File(path);
//		String resultInfo = null;
//		if(operation == 0){
//			delFilesByPath(path,accId);
//		} else {
//			if (file.exists()) {
//				if (file.delete()) {
//					resultInfo =  "1-删除成功";
//				} else {
//					resultInfo =  "0-删除失败";
//				}
//			} else {
//				resultInfo = "文件不存在！";
//			}
//		}
//		return resultInfo;
//	}
//
//	/**
//	 * 上传文本数据到数据库
//	 * @throws Exception
//	 */
//	@Override
//	public void save(List<String[]> columns,String[] paths,AccInfoModel.DetailAccount accInfo,int[] rows,String fileType,List<String[]> comments) throws Exception {
//		String pathPrefix = ResourceUtils.getURL("classpath:").getPath() + "template";
//		// 为每个集团创建单独的库
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection conn = DriverManager.getConnection(url, username, password);
//		Statement stat = conn.createStatement();
//		stat.executeUpdate("CREATE DATABASE IF NOT EXISTS "+"db_yqs_p_"+accInfo.getDomainId()+ " DEFAULT CHARSET utf8 COLLATE utf8_general_ci;");
//		log.info("创建库成功：{}","CREATE DATABASE IF NOT EXISTS "+"db_yqs_p_"+accInfo.getDomainId()+ " DEFAULT CHARSET utf8 COLLATE utf8_general_ci;");
//		stat.close();
//        conn.close();
//        for(int number=0;number<paths.length;number++){
//        	Map<String,Object> map = new HashMap<String,Object>();// 用于过滤重复数据
//        	// 对用户上传的文件单独建表
//            String newUrl = url.split("db_yaoqianshu")[0]  + "db_yqs_p_"+accInfo.getDomainId();
//            Connection newConn = DriverManager.getConnection(newUrl, username, password);
//            Statement newStat = newConn.createStatement();
//            String createTable = "";
//            String colStr = "";
//            for(int i=1;i<=columns.get(number).length;i++){
//            	createTable = createTable + "`col_" + i + "`";
//            	colStr = colStr + "col_" + i;
//            	if(columns.get(number)[i-1].equals("number")){
//            		createTable = createTable + " bigint(20) COMMENT '" + comments.get(number)[i-1]+"',";
//            	} else if(columns.get(number)[i-1].equals("date")){
//            		createTable = createTable + " datetime COMMENT '" + comments.get(number)[i-1]+"',";
//            	} else if(columns.get(number)[i-1].equals("string")){
//            		createTable = createTable + " varchar(255) COMMENT '" + comments.get(number)[i-1]+"',";
//            	}
//            	if(i!=columns.get(number).length){
//            		colStr = colStr + ",";
//            	}
//            }
//            long time = convertTimeToLong();
//            createTable = "create table `tbl_p_"+accInfo.getAccId()+"_" +time+"` (`id` int AUTO_INCREMENT," + createTable + "PRIMARY KEY (`id`))";
//            newStat.executeUpdate("DROP TABLE IF EXISTS `tbl_p_"+accInfo.getAccId()+"_" +time+"`");
//            newStat.executeUpdate(createTable);
//            log.info("创建表成功:{}" ,createTable);
//            // 如果是excel文件
//            if(!fileType.equals("csv")){
//            	FileInputStream in = new FileInputStream(pathPrefix+"/"+paths[number]);
//            	Workbook workbook = WorkbookFactory.create(in);
//        		Sheet sheet = workbook.getSheetAt(0);
//        		int i = 0;
//        		for(Row row : sheet){
//        			if(isRowEmpty(row))
//        				continue;
//        			String key = "";
//        			if(i>rows[number]){
//        				String insertStr = "insert into tbl_p_"+accInfo.getAccId()+"_" +time +"(" + colStr + ") values(";
//        				for(Cell cell : row){
//        					int type = cell.getCellType();
//        					switch (type) {
//        					case Cell.CELL_TYPE_NUMERIC:
//        						SimpleDateFormat sdf = null;
//                	        	if(cell.getCellStyle().getDataFormat() == 180 || cell.getCellStyle().getDataFormat() == 176){
//                	        		sdf = new SimpleDateFormat("yyyy-MM-dd");
//                	        		Date date = cell.getDateCellValue();
//                	        		insertStr = insertStr + "'" + sdf.format(date) + "',";
//                	        		key = key + sdf.format(date);
//                	        	} else if(cell.getCellStyle().getDataFormat() == 181 || cell.getCellStyle().getDataFormat() == 177){
//                	        		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                	        		Date date = cell.getDateCellValue();
//                	        		insertStr = insertStr + "'" + sdf.format(date) + "',";
//                	        		key = key + sdf.format(date);
//                	        	} else {
//                	        		insertStr = insertStr + String.valueOf(cell.getNumericCellValue()) + ",";
//                	        		key = key + cell.getNumericCellValue();
//                	        	}
//        						break;
//        					default:
//        						if(StringUtils.isNotBlank(cell.getStringCellValue())){
//        							insertStr = insertStr + "'" + cell.getStringCellValue() + "',";
//        							key = key + cell.getStringCellValue();
//        						}
//        						break;
//        					}
//        				}
//        				if(!map.containsKey(key)){
//        					map.put(key, 1);
//        					insertStr = insertStr.substring(0,insertStr.length()-1);
//            				insertStr = insertStr + ")";
//            				insertStr = StringEscapeUtils.unescapeHtml4(insertStr);
//            				log.info("插入数据:{}",insertStr);
//            				newStat.executeUpdate(insertStr);
//        				}
//        			}
//        			i ++;
//        		}
//        		//workingTableService.insertWtInfo();
//        		workbook.close();
//            } else {
//            	BufferedReader reader = null;
//    			try {
//    				InputStreamReader inStream = new InputStreamReader(new FileInputStream(pathPrefix+"/"+paths[number]), resolveCode(new File(pathPrefix+"/"+paths[number])));
//    	            reader = new BufferedReader(inStream);
//    	            String line = null;
//    	            int i = 0;
//    	            while((line=reader.readLine())!=null){
//    	                if(i>rows[number]){ // 表头不计算类型
//    	                	String insertStr = "insert into tbl_p_"+accInfo.getAccId()+"_" +time +"(" + colStr + ") values(";
//    	                	String item[] = line.split(",");
//    	                	for(int j=0;j<item.length;j++){
//    	                		insertStr = insertStr + "'" + item[j] + "',";
//    		                }
//    	                	insertStr = insertStr.substring(0,insertStr.length()-1);
//            				insertStr = insertStr + ")";
//            				log.info("插入数据:{}",insertStr);
//            				newStat.executeUpdate(insertStr);
//    	                }
//    	                i++;
//    	            }
//    	            reader.close();
//    	        } catch (Exception e) {
//    	            e.printStackTrace();
//    	        }
//            }
//            newConn.setAutoCommit(false);
//            newConn.commit();
//    		newStat.close();
//            newConn.close();
//        }
//	}
//
//	/**
//	 * 判断字符串是否为数值方法
//	 * @param str
//	 * @return
//	 */
//	public static boolean isNumeric(String str){
//		String reg = "^[0-9]+(.[0-9]+)?$";
//		return str.matches(reg);
//	}
//
//	/**
//	 * 判断字符串是否为日期方法
//	 * @param date
//	 * @return
//	 */
//	public static boolean regDate(String date) {
//		if(date == null){
//			return false;
//		}
//		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			if(formatter1.format(formatter1.parse(date)).equals(date) || formatter2.format(formatter2.parse(date)).equals(date)){
//				return true;
//			} else {
//				return false;
//			}
//		} catch (Exception e) {
//			return false;
//		}
//	}
//
//	/**
//	 * 剔除空列的表头
//	 * @param list
//	 * @return
//	 */
//	public void removeEmpty(List<String> list){
//		Iterator<String> it = list.iterator();
//		while(it.hasNext()){
//		    String x = it.next();
//		    if(x.equals("empty")){
//		        it.remove();
//		    }
//		}
//	}
//
//	/**
//	 * 判断excel某一行是否全为空
//	 * @param row
//	 * @return
//	 */
//	public boolean isRowEmpty(Row row){
//		for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
//	        Cell cell = row.getCell(c);
//	        if(!cellIsEmpty(cell)){
//	        	return false;
//	        }
//		}
//		return true;
//	}
//
//	/**
//	 * 判断cell是否为空值
//	 * @param cell
//	 * @return
//	 */
//	public boolean cellIsEmpty(Cell cell){
//		String cellValue = "";
//		DecimalFormat df = new DecimalFormat("#");
//		switch (cell.getCellType()) {
//        case HSSFCell.CELL_TYPE_STRING:
//            cellValue = cell.getRichStringCellValue().getString().trim();
//            break;
//        case HSSFCell.CELL_TYPE_NUMERIC:
//            cellValue = df.format(cell.getNumericCellValue()).toString();
//            break;
//        case HSSFCell.CELL_TYPE_BOOLEAN:
//            cellValue = String.valueOf(cell.getBooleanCellValue()).trim();
//            break;
//        case HSSFCell.CELL_TYPE_FORMULA:
//            cellValue = cell.getCellFormula();
//            break;
//        default:
//            cellValue = "";
//        }
//		if(StringUtils.isNotBlank(cellValue)){
//        	return false;
//        }
//		return true;
//	}
//
//	/**
//	 * 获取文件的编码格式
//	 * @param path
//	 * @return
//	 * @throws Exception
//	 */
//	public static String resolveCode(File file) throws Exception {
//        InputStream inputStream = new FileInputStream(file);
//        byte[] head = new byte[3];
//        inputStream.read(head);
//        String code = "gb2312";  //或GBK
//        if (head[0] == -1 && head[1] == -2 )
//            code = "UTF-16";
//        else if (head[0] == -2 && head[1] == -1 )
//            code = "Unicode";
//        else if(head[0]==-17 && head[1]==-69 && head[2] ==-65)
//            code = "UTF-8";
//        inputStream.close();
//        return code;
//    }
//
//	/**
//	  * @Description: 批量删除
//	  * @param args
//	  * @return void
//	  * @author lisr
//	  * @date Mar 7, 2012 5:36:04 PM
//	  * @throws
//	  */
//	public static boolean delFilesByPath(String path,String str){
//		boolean b=false;
//		File file = new File(path);
//		File[] tempFile = file.listFiles();
//		for(int i = 0; i < tempFile.length; i++){
//			if(tempFile[i].getName().startsWith(str)||tempFile[i].getName().endsWith(str)){
//				boolean del=tempFile[i].delete();
//				if(del){
//					b=true;
//				} else {
//					b=false;
//				}
//			}
//		}
//		return b;
//	}
//
//	/**
//     * 将字符串转日期成Long类型的时间戳，格式为：yyyy-MM-dd HH:mm:ss
//     */
//    public static Long convertTimeToLong() {
//    	Date dt = new Date();
//    	System.out.println(dt.toString());   //java.util.Date的含义
//    	return dt.getTime() / 1000;   //得到秒数，Date类型的getTime()返回毫秒数
//    }
//}

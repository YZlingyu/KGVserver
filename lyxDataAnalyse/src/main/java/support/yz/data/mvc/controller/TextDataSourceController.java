//package support.yz.data.mvc.controller;
//
//import java.io.File;
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.DigestUtils;
//import org.springframework.util.ResourceUtils;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import lombok.extern.slf4j.Slf4j;
//import support.yz.data.mvc.service.inter.ITextDataSourceService;
//
///**
// * @Author: liang
// * @Description: 文本数据源管理
// * @Date: 2018/11/13
// */
//@Slf4j
//@RestController
//@RequestMapping("/text_data_source/")
//public class TextDataSourceController {
//
//	@Autowired
//	private ITextDataSourceService textDataSßourceService;
//
//	@RequestMapping(value = "/upload",method = RequestMethod.POST)
//    @ResponseBody
//	public Object upload(@RequestParam("file") MultipartFile file) throws Exception {
//		String pathPrefix = ResourceUtils.getURL("classpath:").getPath() + "template";
//		//AccInfoModel.DetailAccount accInfo = AccInfoManager.get();
//		if (file.isEmpty()) {
//            return null;
//        } else {
//        	String fileName = file.getOriginalFilename();
//        	String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        	if(!suffixName.equals(".xlsx") && !suffixName.equals(".xls") && !suffixName.equals(".csv")){
//        		return null;
//        	}
//        	String MD5Name = DigestUtils.md5DigestAsHex(file.getOriginalFilename().getBytes());
//        	Date date=new Date();
//        	File uploadFile = new File(pathPrefix + "/" + /*accInfo.getAccId()*/1006 + "_" + date.getTime() + "_" + MD5Name + suffixName);
//        	file.transferTo(uploadFile);
//        	//TextDataPreview preview = textDataSourceService.upload(uploadFile,suffixName);
//        	//preview.setFileName(fileName);
//        	return null;
//        }
//	}
//
//	@RequestMapping(value = "/delete/{file_id:.*}/",method = RequestMethod.DELETE)
//	@ResponseBody
//	public Object delete(@PathVariable("file_id") String fileId) throws Exception {
//		//AccInfoModel.DetailAccount accInfo = AccInfoManager.get();
//		String info = null;
//		if(fileId.equals("all")){
//			//info = textDataSourceService.delete(ResourceUtils.getURL("classpath:").getPath() + "template",0,/*accInfo.getAccId().toString()*/"1006");
//		} else {
//			String pathPrefix = ResourceUtils.getURL("classpath:").getPath() + "template" + "/" + fileId;
//			//info = textDataSourceService.delete(pathPrefix,1,null);
//		}
//		return null;
//	}
//
//	@RequestMapping(value = "/save",method = RequestMethod.POST)
//	public Object save(/*@RequestBody TextDataSource textDataSource*/) throws Exception{
//		//AccInfoModel.DetailAccount accInfo = AccInfoManager.get();
//		//AccInfoModel.DetailAccount accInfo = new AccInfoModel.DetailAccount();
//		//accInfo.setAccId((long)10016);
//		//accInfo.setDomainId((long)505);
//		//textDataSourceService.save(textDataSource.getColumns(),textDataSource.getFileIds(),accInfo,textDataSource.getRow(),textDataSource.getType(),textDataSource.getComments());
//		return null;
//	}
//}

//package support.yz.data.mvc.service.inter;
//
//import java.io.File;
//import java.util.List;
//
//import com.yaoqianshu.data.model.domain.busi.AccInfoModel;
//import com.yaoqianshu.developer.model.TextDataPreview;
//
//public interface ITextDataSourceService {
//
//	/**
//	 * 文件上传到项目本地
//	 * @param file
//	 * @return
//	 * @throws Exception
//	 */
//	public TextDataPreview upload(File file, String suffixName) throws Exception;
//
//	/**
//	 * 删除本地指定文件
//	 * @param path
//	 * @param operation
//	 * @return
//	 * @throws Exception
//	 */
//	public String delete(String path, int operation, String accId) throws Exception;
//
//	/**
//	 * 将文本数据上传到数据库中
//	 * @param fileIds
//	 * @param columns
//	 * @param row
//	 */
//	public void save(List<String[]> columns, String[] paths, AccInfoModel.DetailAccount accInfo, int[] row, String fileType, List<String[]> comments) throws Exception;
//
//}

package support.yz.data.entity.response;

/**
 * @Author: yangzhuo
 * @Description: 返回参数
 * @Date: 2018/7/22
 */

public class DataResponse {

	public String code;
    public String msg;
    public Object data;

    public DataResponse() {
    }

    public DataResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public DataResponse(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    /**
     * @Author: yangzhuo
     * @Descriptor: 执行成功
     * @Date: 12:34 2018/7/23
     */
    public static DataResponse buildSuccessResponse(Object data) {
        return new DataResponse("200", "success!", data);
    }


    /**
     * @Author: yangzhuo
     * @Descriptor: 执行失败 -- 参数异常
     * @Date: 12:34 2018/7/23
     */
    public static DataResponse buildParamErrorResponse() {
        return new DataResponse("400", "failed!");
    }

    /**
     * @Author: yangzhuo
     * @Descriptor: 执行失败 -- 系统异常
     * @Date: 12:34 2018/7/23
     */
    public static DataResponse buildErrorResponse() {
        return new DataResponse("500", "failed!");
    }
}

package support.yz.data.entity.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DataResponse {

    private String errMes;
    private String errCode;
    private Object data;

    public DataResponse(String errMes,String errCode){
        this.errMes = errMes;
        this.errCode = errCode;
    }

    public DataResponse(String errMes,String errCode,Object data){
        this.errMes = errMes;
        this.errCode = errCode;
        this.data = data;
    }

    public static DataResponse getErrDataResponse(){
        return new DataResponse("服务器内部错误","500");
    }
}

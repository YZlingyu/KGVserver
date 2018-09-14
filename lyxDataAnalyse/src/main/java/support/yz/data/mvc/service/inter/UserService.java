package support.yz.data.mvc.service.inter;

/**
 * 用户登录服务接口
 */
public interface UserService {

	/**
     * @Author: yangzhuo
     * @Descriptor: 获取用户信息
     * @Date: 15:26 2018/9/14
     */
	public boolean getUser(String userName, String password) throws Exception;
}

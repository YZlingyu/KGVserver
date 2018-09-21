package support.yz.data.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import support.yz.data.entity.response.DataResponse;
import support.yz.data.entity.user.User;
import support.yz.data.mvc.service.inter.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: yangzhuo
 * @Description: 登录接口
 * @Date: 2018/9/14
 */
@CrossOrigin // 请求跨域处理
@RestController
@RequestMapping(value = "/KGV/user/")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	/**
     * @Author: yangzhuo
     * @Descriptor: 获取用户信息
     * @Date: 15:26 2018/9/14
     */
	@RequestMapping(value = "getUser", method = RequestMethod.GET)
	public DataResponse getUser(String userName, String password,HttpServletRequest request){
		try{
            Boolean result = userService.getUser(userName, password);
            if(result) {
				HttpSession session = request.getSession();
				User user = new User();
				user.setUserName(userName);
				user.setPassword(password);
				session.setAttribute("user", user);
				return new DataResponse("success","200",session.getId());
			}
            return DataResponse.buildErrorResponse();
        } catch (Exception e){
        	logger.error("failed to UserController.saveChart", e);
            return DataResponse.buildErrorResponse();
        }
	}

}

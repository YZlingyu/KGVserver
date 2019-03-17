package support.yz.data.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import support.yz.data.mvc.mapper.UserMapper;
import support.yz.data.mvc.service.inter.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserMapper userMapper;
	
	@Override
	public boolean getUser(String userName, String password) throws Exception {
		if(userMapper.getUser(userName, password) != null)
			return true;
		return false;
	}

}

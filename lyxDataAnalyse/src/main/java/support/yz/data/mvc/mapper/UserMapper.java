package support.yz.data.mvc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import support.yz.data.entity.user.User;

@Mapper
public interface UserMapper {

	@Select("SELECT * FROM user WHERE userName = #{userName} AND password = #{password}")
    @Results({
		@Result(id=true,property="userId",column="userId"),
		@Result(property="userName",column="userName"),
		@Result(property="password",column="password")
	})
	User getUser(@Param("userName") String userName, @Param("password") String password);
}

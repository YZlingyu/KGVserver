package support.yz.data.mvc.mapper;

import org.apache.ibatis.annotations.*;
import support.yz.data.entity.entityInfo.EnterprisePatent;

@Mapper
public interface PatentMapper {
    /**
     *
     * @Descriptor 查专利信息
     */
    @Select("SELECT * FROM company_patent WHERE patent_name = #{patentName}")
    @Results({
            @Result(id=true,property="id",column="id"),
            @Result(property="patentName",column="patent_name"),
            @Result(property="publishTime",column="publish_time"),
            @Result(property="patentDomain",column="patent_domain"),
            @Result(property="companyId",column="company_id"),
            @Result(property="patentDetail",column="patent_detail"),
            @Result(property="createTime",column="create_time"),
            @Result(property="actionTime",column="action_time")
    })
    EnterprisePatent getPatentByName(@Param("patentName") String patentName);
}

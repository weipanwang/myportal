package my.portal.dao;

import java.util.List;
import my.portal.pojo.Blogger;
import my.portal.pojo.BloggerExample;
import org.apache.ibatis.annotations.Param;

public interface BloggerMapper {
    int countByExample(BloggerExample example);

    int deleteByExample(BloggerExample example);

    int deleteByPrimaryKey(Long bloggerId);

    int insert(Blogger record);

    int insertSelective(Blogger record);

    List<Blogger> selectByExample(BloggerExample example);

    Blogger selectByPrimaryKey(Long bloggerId);

    int updateByExampleSelective(@Param("record") Blogger record, @Param("example") BloggerExample example);

    int updateByExample(@Param("record") Blogger record, @Param("example") BloggerExample example);

    int updateByPrimaryKeySelective(Blogger record);

    int updateByPrimaryKey(Blogger record);
}
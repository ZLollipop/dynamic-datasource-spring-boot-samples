package work.lollipops.mapper.db1;


import com.baomidou.dynamic.datasource.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import work.lollipops.model.Tb1;

import javax.websocket.server.PathParam;

/**
 * @author zhaohaoren
 */
@Repository
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public interface TB1Mapper extends BaseMapper<Tb1> {
    /**
     * 主键key查询
     *
     * @param id 主键key
     * @return ignore
     */
    Tb1 selectByPrimaryKey(@PathParam("id") Integer id);

    /**
     * 清空表
     */
    @Update("truncate table TB1")
    void truncate();
}
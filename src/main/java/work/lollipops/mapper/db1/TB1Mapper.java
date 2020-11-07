package work.lollipops.mapper.db1;


import com.baomidou.dynamic.datasource.MyBaseMapper;
import work.lollipops.model.Tb1;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author zhaohaoren
 */
@Repository
public interface TB1Mapper extends MyBaseMapper<Tb1> {
    List<Tb1> selectByPrimaryKey(@PathParam("id") Integer id);
}
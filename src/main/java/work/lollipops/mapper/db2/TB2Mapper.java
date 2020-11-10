package work.lollipops.mapper.db2;

import com.baomidou.dynamic.datasource.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import work.lollipops.model.Tb2;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author zhaohaoren
 */
@Repository
public interface TB2Mapper extends BaseMapper<Tb2> {
    List<Tb2> selectByPrimaryKey(@PathParam("id") Integer id);
}
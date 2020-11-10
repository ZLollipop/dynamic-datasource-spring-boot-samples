package work.lollipops.mapper.db3;

import com.baomidou.dynamic.datasource.mapper.MyBaseMapper;
import org.springframework.stereotype.Repository;
import work.lollipops.model.Tb3;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author zhaohaoren
 */
@Repository
public interface TB3Mapper extends MyBaseMapper<Tb3> {
    List<Tb3> selectByPrimaryKey(@PathParam("id") Integer id);
}
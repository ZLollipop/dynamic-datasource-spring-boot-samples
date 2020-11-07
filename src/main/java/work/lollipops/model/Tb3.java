package work.lollipops.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

/**
 * @author zhaohaoren
 */
@Data
@ToString
public class Tb3 {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Object f1;
    private Integer f2;
    private Integer f3;
}

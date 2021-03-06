package work.lollipops.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Random;

/**
 * @author zhaohaoren
 */
@Data
@Builder
@ToString
public class Tb3 {

//    @TableLogic
    @TableId(type = IdType.INPUT)
    private Integer id;
    private Object f1;
    private Integer f2;
    private Integer f3;

    public static Tb3 getRandom(Integer id) {
        Random random = new Random();
        return Tb3.builder()
                .id(id)
                .f1(random.nextInt(100))
                .f2(random.nextInt(100))
                .f3(random.nextInt(100))
                .build();
    }
}

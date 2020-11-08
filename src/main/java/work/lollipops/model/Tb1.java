package work.lollipops.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Random;
import java.util.UUID;

/**
 * @author zhaohaoren
 */
@Data
@Builder
@ToString
public class Tb1 {

    // TODO: 2020/11/8 不灵活
//    @TableId(type = IdType.AUTO)
    private Integer id;
    private Object f1;
    private Integer f2;
    private Integer f3;

    public static Tb1 getRandom(Integer id) {
        Random random = new Random();
        return Tb1.builder()
                .id(id)
                .f1(random.nextInt(100))
                .f2(random.nextInt(100))
                .f3(random.nextInt(100))
                .build();
    }
}

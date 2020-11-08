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
public class Tb2 {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer f1;
    private Integer f2;
    private Integer f3;

    public static Tb2 getRandom(Integer id) {
        Random random = new Random();
        return Tb2.builder()
                .id(id)
                .f1(random.nextInt(100))
                .f2(random.nextInt(100))
                .f3(random.nextInt(100))
                .build();
    }
}

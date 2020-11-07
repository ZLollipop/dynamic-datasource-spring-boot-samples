package work.lollipops;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import work.lollipops.mapper.db1.TB1Mapper;
import work.lollipops.mapper.db2.TB2Mapper;
import work.lollipops.mapper.db3.TB3Mapper;
import work.lollipops.model.Tb3;
import work.lollipops.service.DynamicService;

import java.util.ArrayList;
import java.util.Collections;

@Slf4j
@SpringBootTest
public class MultiDatasourceTest {

    @Autowired
    TB1Mapper tb1Mapper;
    @Autowired
    TB2Mapper tb2Mapper;
    @Autowired
    TB3Mapper tb3Mapper;
    @Autowired
    DynamicService dynamicService;

    @Test
    public void test() {
        ArrayList<Tb3> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Tb3 tb3 = new Tb3();
            tb3.setF1(i);
            tb3.setF2(i);
            tb3.setF3(i);
            objects.add(tb3);
        }
        objects.get(5).setF1(1);
        tb3Mapper.saveBatch(objects);
        log.info("From Database DB1 Result: {}", tb1Mapper.selectByPrimaryKey(1));
        log.info("From Database DB1 Result: {}", tb1Mapper.selectById(1));
        log.info("From Database DB2 Result: {}", tb2Mapper.selectByPrimaryKey(1));
        log.info("From Database DB2 Result: {}", tb2Mapper.selectById(1));
        log.info("From Database DB3 Result: {}", tb3Mapper.selectByPrimaryKey(1));
        log.info("From Database DB3 Result: {}", tb3Mapper.saveBatch(Collections.emptyList(), 1000));
        System.out.println(dynamicService.list());
    }


}
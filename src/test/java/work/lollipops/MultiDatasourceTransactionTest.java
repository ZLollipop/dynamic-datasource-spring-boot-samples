package work.lollipops;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import work.lollipops.mapper.db1.TB1Mapper;
import work.lollipops.model.Tb1;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MultiDatasourceTransactionTest {

    @Autowired
    private TB1Mapper tb1Mapper;

    @Test
    @Order(1)
    public void testInsertOne() {
        tb1Mapper.truncate();
        Tb1 tb1 = Tb1.getRandom(1);
        assertEquals(1, tb1Mapper.insert(tb1));
    }

    @Test
    @Order(2)
    @Transactional(rollbackFor = Exception.class)
    public void testInsertTransaction() {
        tb1Mapper.insert(Tb1.getRandom(2));
        int i = 1 / 0;
        tb1Mapper.insert(Tb1.getRandom(3));
    }


    @Test
    @Order(3)
    public void badTransactionInsert() {
        // 如果去除Transactional注解应当为false
        assertNotNull(tb1Mapper.getById(1));
        assertNull(tb1Mapper.getById(2));
        assertNull(tb1Mapper.getById(3));
    }

}

package work.lollipops;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import work.lollipops.mapper.db1.TB1Mapper;
import work.lollipops.mapper.db2.TB2Mapper;
import work.lollipops.mapper.db3.TB3Mapper;
import work.lollipops.model.Tb1;
import work.lollipops.model.Tb2;
import work.lollipops.model.Tb3;
import work.lollipops.service.DynamicService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
public class MultiDatasourceInsertTest {

    @Autowired
    TB1Mapper tb1Mapper;
    @Autowired
    TB2Mapper tb2Mapper;
    @Autowired
    TB3Mapper tb3Mapper;
    @Autowired
    DynamicService dynamicService;

    @BeforeEach
    public void clear() {
        tb1Mapper.truncate();
        log.info("clear table.......");
    }

    @Test
    public void testInsertOne() {
        Tb1 tb1 = Tb1.getRandom(1);
        assertEquals(1, tb1Mapper.insert(tb1));
        assertNotNull(tb1Mapper.selectById(1));
        Tb2 tb2 = Tb2.getRandom(1);
        assertEquals(1, tb2Mapper.insert(tb2));
        assertNotNull(tb2Mapper.selectById(1));
    }

    @Test
    public void testInsertBatch() {
        List<Tb1> tb1List = IntStream.rangeClosed(1, 100).mapToObj(Tb1::getRandom).collect(Collectors.toList());
        assertTrue(tb1Mapper.saveBatch(tb1List));
        assertNotNull(tb1Mapper.getById(100));
    }

    @Test
    public void testInsertBatchTransaction() {
        List<Tb1> tb1List = IntStream.rangeClosed(1, 100).mapToObj(Tb1::getRandom).collect(Collectors.toList());
        tb1List.get(50).setF1("testFail");
        try {
            tb1Mapper.saveBatch(tb1List);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNull(tb1Mapper.getById(100));
    }

    @Test
    public void testttt() {
        List<Tb3> collect = IntStream.rangeClosed(1, 100).mapToObj(Tb3::getRandom).collect(Collectors.toList());
        tb3Mapper.saveBatch(collect);
    }
}
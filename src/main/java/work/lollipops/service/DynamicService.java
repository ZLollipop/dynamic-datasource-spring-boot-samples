package work.lollipops.service;

import work.lollipops.mapper.db1.TB1Mapper;
import work.lollipops.model.Tb1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaohaoren
 */
@Service
public class DynamicService {

    @Autowired
    private TB1Mapper tb1Mapper;

    public List<Tb1> list() {
        return tb1Mapper.list();
    }
}

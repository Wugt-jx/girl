package spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.domain.Girl;

import java.util.List;


/**
 * Created by wgt on 2017/3/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void getAll() throws Exception {
        List<Girl> girls=girlService.getAll();
    }

}
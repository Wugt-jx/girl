package spring.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * Created by wgt on 2017/3/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc   //测试Controller需要添加的注解
public class GirlControllerTest {

    @Autowired
    private MockMvc mvc;    //使用该对象进行Controller的测试

   // @Test
    public void getAll() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/add?name=ccc&age=21&password=12345667"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("abc"));
    }

    @Test
    public void update() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/update").param("id","1")
                                                                        .param("name","www")
                                                                        .param("password","wgt192334")
                                                                        .param("age","17"));
    }
}
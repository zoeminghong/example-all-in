package com.zerostech.example;

import com.ecfront.dew.common.$;
import com.ecfront.dew.common.Resp;
import com.zerostech.example.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created on 2020-03-18.
 *
 * @author 迹_Jason
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestDB {

    @Test
    public void test001() {
        Resp<List<User>> resp = Resp.genericList($.http.get("http://localhost:7786/user"), User.class);
        Assert.assertTrue(resp.ok()&&resp.getBody().size()>0);
    }
}

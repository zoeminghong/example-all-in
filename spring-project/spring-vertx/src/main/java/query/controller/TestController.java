package query.controller;

import com.ecfront.dew.common.Resp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2020-03-16.
 *
 * @author 迹_Jason
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public Resp<String> test(){
        return Resp.success(null);
    }
}

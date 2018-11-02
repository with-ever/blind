package kr.withever.withcash.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author youngjin.kim@nhnent.com
 * @since 2018-11-02
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", "Hello world");
        return "index";
    }
}

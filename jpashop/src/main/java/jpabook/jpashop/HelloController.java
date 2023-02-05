package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        // 키"data"에 "hello!!!"라는 value를 넣어서 넘김
        model.addAttribute("data", "hello!!!");
        return "hello";  // hello.html
    }

}

package cn.mmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author NicholasLD
 * @createTime 2023/4/13 21:33
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

        @RequestMapping("/404")
        public String error404() {
            return "error/404";
        }
}

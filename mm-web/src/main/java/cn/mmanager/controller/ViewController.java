package cn.mmanager.controller;

import cn.mmanager.common.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import oshi.PlatformEnum;
import oshi.SystemInfo;

/**
 * @author NicholasLD
 * @createTime 2023/4/13 14:49
 */
@Controller
public class ViewController extends BaseController {
    @GetMapping("/")
    public String index(Model model) {
        PlatformEnum currentPlatform = SystemInfo.getCurrentPlatform();
        model.addAttribute("platform", currentPlatform);
        return "index";
    }

    @GetMapping("/customers")
    public String customer() {
        return "customers";
    }

    @GetMapping("/pages")
    public String page() {
        return "pages";
    }

    @GetMapping("/tokens")
    public String nmqs() {
        return "nmqs";
    }
}

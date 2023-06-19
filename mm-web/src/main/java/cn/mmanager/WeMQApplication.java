package cn.mmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author NicholasLD
 * @createTime 2023/6/18 23:31
 */
@SpringBootApplication
@MapperScan("cn.mmanager.dao")
public class WeMQApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeMQApplication.class, args);
        System.out.println(
                "WeMQ启动成功！\n" +
                "██╗    ██╗███████╗███╗   ███╗ ██████╗\n" +
                "██║    ██║██╔════╝████╗ ████║██╔═══██╗\n" +
                "██║ █╗ ██║█████╗  ██╔████╔██║██║   ██║\n" +
                "██║███╗██║██╔══╝  ██║╚██╔╝██║██║▄▄ ██║\n" +
                "╚███╔███╔╝███████╗██║ ╚═╝ ██║╚██████╔╝\n" +
                " ╚══╝╚══╝ ╚══════╝╚═╝     ╚═╝ ╚══▀▀═╝");
    }
}

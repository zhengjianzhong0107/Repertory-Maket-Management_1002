package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.core.SpringVersion;


@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, MongoAutoConfiguration.class, MongoDataAutoConfiguration.class},scanBasePackages = {"com.ruoyi","org.jeecg.modules.jmreport"})
public class RuoYiApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);
        /**
         * 获取对应的Spring 版本
         *
         */
        String version = SpringVersion.getVersion();
        System.out.println("version is :"+version);
        System.out.println(
                "           ___           ___           ___           ___           ___     \n" +
                "          |\\__\\         /\\  \\         /\\  \\         /\\  \\         /\\__\\    \n" +
                "   _      |:|  |       /::\\  \\       /::\\  \\       /::\\  \\       /:/  /    \n" +
                "  / \\     |:|  |      /:/\\:\\  \\     /:/\\:\\  \\     /:/\\:\\  \\     /:/__/     \n" +
                " ( 3 ) -- |:|__|__   /::\\~\\:\\  \\   /:/  \\:\\  \\   /::\\~\\:\\  \\   /::\\__\\____ \n" +
                "  \\_/     /::::\\__\\ /:/\\:\\ \\:\\__\\ /:/__/ \\:\\__\\ /:/\\:\\ \\:\\__\\ /:/\\:::::\\__\\\n" +
                "         /:/~~/~    \\/__\\:\\/:/  / \\:\\  \\  \\/__/ \\/_|::\\/:/  / \\/_|:|~~|~   \n" +
                "        /:/  /           \\::/  /   \\:\\  \\          |:|::/  /     |:|  |    \n" +
                "        \\/__/             \\/__/     \\:\\  \\         |:|\\/__/      |:|  |    \n" +
                "                                     \\:\\__\\        |:|  |        |:|  |    \n" +
                "                                      \\/__/         \\|__|         \\|__|    ");


        System.out.println("基于JavaWeb胡家铺子库存管理系统的设计与实现-启动成功");
    }
}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
//        // 指定禁用内置命令列表
//        String[] disableCmds = new String[]{
//                "--spring.shell.command.script.enabled=false",
//                "--spring.shell.command.stacktrace.enabled=false"
//        };
//
//        // 重新拼接启动参数
//        String[] fullArgs = StringUtils.concatenateStringArrays(args, disableCmds);

        // 启动应用
        SpringApplication.run(DemoApplication.class, args);
    }

}

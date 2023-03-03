package com.example.demo.commands;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.jline.terminal.Terminal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author Ayuan
 * @Description: 新增内置命令
 * 只需将命令所属组设置为内置命令组"Built-In Commands"即可
 * @date 2023/3/3 16:43
 */
@ShellComponent
@ShellCommandGroup("Built-In Commands")
public class MyEcho {

    // 使用延迟注入终端
    @Lazy
    @Autowired
    private Terminal terminal;

    @ShellMethod("print line")
    public String echo(String line) {
        return line;
    }
}
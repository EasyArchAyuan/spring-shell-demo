package com.example.demo.commands;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.jline.terminal.Terminal;
import org.jline.utils.InfoCmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.commands.Clear;

/**
 * @author Ayuan
 * @Description: 重写clear命令
 * @date 2023/3/3 16:45
 */
@ShellComponent
@ShellCommandGroup("Built-In Commands")
public class MyClear implements Clear.Command {

    // 使用延迟加载方式注入终端组件
    @Autowired
    @Lazy
    private Terminal terminal;

    @ShellMethod("my clear")
    public void clear(){
        this.terminal.puts(InfoCmp.Capability.clear_screen);
        this.terminal.writer().write("clean done...\n");
    }
}

package com.example.demo.commands;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

/**
 * @author Ayuan
 * @Description: 命令限制可用
 * @date 2023/3/3 16:34
 */
@ShellComponent
public class AvailabilityCommands {
    private boolean connected;

    @ShellMethod("Connect to the server.")
    public void connect(String user, String password) {
        connected = true;
    }

    @ShellMethod("Download the nuclear codes.")
    @ShellMethodAvailability({"checkAuth"})
    public String download() {
        return "execute downloading ...";
    }

    /**
     * 方法名必须为 "命令名Availability", 一个方法只能限制一条命令
     * 只能限制download 命令
     */
    public Availability downloadAvailability() {
        String message = "Sorry! You are not connected";
        return connected ? Availability.available() : Availability.unavailable(message);
    }

    /**
     * @ShellMethodAvailability({"xxx"}) 指定该命令是否可用的校验方法, 可指定多个校验方法
     */
    @ShellMethodAvailability({"download"})
    public Availability checkAuth() {
        String message = "Sorry! You are not connected";
        return connected ? Availability.available() : Availability.unavailable(message);
    }

}

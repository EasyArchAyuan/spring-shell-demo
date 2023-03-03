package com.example.demo.commands;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Ayuan
 * @Description: 自定义命令提示符
 * @date 2023/3/3 16:55
 */
@Component
public class CustomPromptProvider implements PromptProvider {

    @Override
    public AttributedString getPrompt() {
        // 获取主机名称
        String hostName = getHostName();
        // 设置命令提示符文字
        String promot = "spring@" + hostName + "> ";
        // 设置命令提示符字体样式
        AttributedStyle promotStyle = AttributedStyle.BOLD.foreground(AttributedStyle.GREEN);
        // 返回命令提示符
        return new AttributedString(promot, promotStyle);
    }

    /**
     * 获取主机名称
     */
    private String getHostName() {
        String hostName = "";
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            hostName = inetAddress.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return hostName;
    }
}

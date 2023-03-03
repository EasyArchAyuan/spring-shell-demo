package com.example.demo.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/3/3 15:10
 */
@ShellComponent
public class MyCommands {

    @ShellMethod(value = "Add two integers together.",key = "add")
    public int sum(int a, int b) {
        return a + b;
    }

    @ShellMethod(value = "Change password.")
    public String changePassword(@Size(min = 8, max = 40) String password) {
        return "Password successfully set to " + password;
    }

    @ShellMethod("add three numbers")
    public String multiSum(@ShellOption(arity = 3) int[] numbers) {
        int sum = numbers[0] + numbers[1] +numbers[2];

        return numbers[0] + "+" + numbers[1] + "+" + numbers[2] + "=" + sum;
    }

    @ShellMethod("multiply three numbers")
    public String multiply(@ShellOption(arity = 3) List<Integer> numbers) {
        int result = numbers.get(0) * numbers.get(1) * numbers.get(2);
        return numbers.get(0) + "x" + numbers.get(1) + "x" + numbers.get(2) + "=" + result;
    }

    @ShellMethod("shutdown")
    public String shutdown(boolean force, int seconds) {
        return "force: " + force + ", seconds:" + seconds;
    }
}

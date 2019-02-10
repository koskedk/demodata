package com.afyahmis.demo.core.commands;

import com.afyahmis.demo.core.interfaces.ICommand;
import com.afyahmis.demo.core.model.LiveResponse;

public class RegisterCommand implements ICommand {
    private long code;
    private String name;

    public long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public RegisterCommand(long code, String name) {
        this.code = code;
        this.name = name;
    }
}

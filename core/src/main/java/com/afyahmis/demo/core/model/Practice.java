package com.afyahmis.demo.core.model;

public class Practice {
    private long code;
    private String name;

    public long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    protected Practice() {
    }

    public Practice(long code, String name) {
        this.code = code;
        this.name = name;
    }

    public void changeName(String name) {
        this.name=name;
    }

    @Override
    public String toString() {
        return code + "," + name;
    }
}

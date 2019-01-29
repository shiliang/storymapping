package com.nju.storymapping.utility.constant;

public enum Status {
    NEW("新建",1),
    DEVELOPING("开发中",2),
    VERIFY("验证中",3),
    COMPLETED("已完成",4);

    private String name;
    private int index;

    private Status(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (Status status : Status.values()) {
            if (status.getIndex() == index) {
                return status.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

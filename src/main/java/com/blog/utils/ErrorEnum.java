package com.blog.utils;

public enum ErrorEnum {
    WARN("警告", 1), ERROR("错误", 2);
    private String name;
    private int index;

    ErrorEnum(String name, int index){
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "ErrorEnum{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }

    public static void getAll(){
        for (ErrorEnum errorEnum:ErrorEnum.values())
            System.out.println("name:"+errorEnum.getName()+" index:"+errorEnum.getIndex());

    }
}

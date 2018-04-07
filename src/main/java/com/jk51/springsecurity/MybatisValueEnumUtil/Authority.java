package com.jk51.springsecurity.MybatisValueEnumUtil;

public enum Authority implements IEnum {
    ROLE_USER(1,"USER"),ROLE_ADMIN(2,"ADMIN");


    private int key;
    private String value;

    private Authority(int key,String value){
        this.key = key;
        this.value = value;
    }
    @Override
    public int getKey() {
        return key;
    }

    @Override
    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}

package com.zp.designpatern.create.Builder;

/**
 * Created by Zhang Peng on 2016/7/25.
 */
public class MyContact {
    private int    age;
    private int    safeID;
    private String name;
    private String address;

    public static class Builder{
        private int    age = 0;
        private int    safeID = 0;
        private String name = null;
        private String address = null;

        public Builder(String name){
            this.name = name;
        }

        public Builder age(int val){
            this.age = val;
            return this;
        }

        public Builder safeID(int val){
            this.safeID = val;
            return this;
        }

//        public Builder name(String val){
//            this.name = val;
//            return this;
//        }

        public Builder address(String val){
            this.address = val;
            return this;
        }

        public MyContact build(){
            return new MyContact(this);
        }
    }

    private MyContact(Builder builder){
        age         = builder.age;
        safeID      = builder.safeID;
        name        = builder.name;
        address     = builder.address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSafeID() {
        return safeID;
    }

    public void setSafeID(int safeID) {
        this.safeID = safeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

package com.zp.jvm;

/**
 * Created by Zhang Peng on 2016/10/14.
 */
public class StaticDispatch {
    public static void main(String[] args) {
        // Human 为man/woman 的静态类型（Static Type）,或者叫外观类型（Apparent Type）
        // Man/Woman 为 man/woman 的实际类型（Actual Type）
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
        sr.sayHello((Man) man);
        sr.sayHello((Woman) woman);

        Fruits apple = new Apple();
        Fruits banner = new Banner();
        sr.sayHello(apple);
        sr.sayHello(banner);

        sr.sayHello(new Factory().create("apple"));
        sr.sayHello(new Factory().create("banner"));

        //动态分派
        apple.sayName();
        banner.sayName();
    }

    class A {

    }

    static abstract class Human{
    }

    static class Man extends Human{
    }

    static class Woman extends Human{
    }

    public void sayHello(Human people){
        System.out.println("hello, people!");
    }

    public void sayHello(Man people){
        System.out.println("hello, gentleman!");
    }

    public void sayHello(Woman people){
        System.out.println("hello, lady!");
    }

    public void sayHello(Fruits fruits){
        System.out.println("hello, fruits!");
    }

    public void sayHello(Apple fruits){
        System.out.println("hello, apple!");
    }

    public void sayHello(Banner fruits){
        System.out.println("hello, banner!");
    }
}

abstract class Fruits{
    public abstract void sayName();
}

class Apple extends Fruits{
    @Override
    public void sayName() {
        System.out.println("my name is apple!");
    }
}

class Banner extends Fruits{
    @Override
    public void sayName() {
        System.out.println("my name is banner!");
    }
}

class Factory{
    public Fruits create(String fruitName){
        if(fruitName.equals("apple")){
            return new Apple();
        }
        if(fruitName.equals("banner")){
            return new Banner();
        }
        return null;
    }
}

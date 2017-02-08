package com.zp.designpatern.create.prototype;

import java.io.*;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class Prototype implements Cloneable, Serializable {

    private static final long serialVersionUID = 2482706142607625738L;

    private String str;

    private SerializableObject obj;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Prototype proto = (Prototype) super.clone();
        return proto;
    }

    public Object deepClone() throws IOException, ClassNotFoundException{
        /**
         * 写入当前对象的二进制流
         */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /**
         * 读出二进制流产生的对象
         */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public SerializableObject getObj() {
        return obj;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }
}
class SerializableObject implements Serializable {
    private static final long serialVersionUID = -2045015892860188950L;
}
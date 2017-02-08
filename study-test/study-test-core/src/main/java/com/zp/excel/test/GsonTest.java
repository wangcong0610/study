package com.zp.excel.test;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Author: Zhang Peng
 * Date: 2017/1/18 0018
 * Description:
 */
public class GsonTest {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Integer.class, new TypeAdapter<Integer>() {
                    public void write(JsonWriter out, Integer value) throws IOException {
                        out.value(String.valueOf(value));
                    }
                    public Integer read(JsonReader in) throws IOException {
                        try {
                            return Integer.parseInt(in.nextString());
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                            return -1;
                        }
                    }
                })
                .create();
        System.out.println(gson.fromJson("\"100.00\"",Integer.class));
//        JsonSerializer<Number> numberJsonSerializer = new JsonSerializer<Number>() {
//            public JsonElement serialize(Number src, Type typeOfSrc, JsonSerializationContext context) {
//                return new JsonPrimitive(String.valueOf(src));
//            }
//        };
//        JsonSerializer<Number> doubleJsonSerializer = new JsonSerializer<Number>() {
//            public JsonElement serialize(Number src, Type typeOfSrc, JsonSerializationContext context) {
//                double a = src.doubleValue() - src.intValue();
//                if(a == 0){
//                    return new JsonPrimitive(String.valueOf(src.intValue()));
//                }
//                return new JsonPrimitive(String.valueOf(src));
//            }
//        };
//        Gson gson = new GsonBuilder()
//                .registerTypeAdapter(Integer.class, numberJsonSerializer)
//                .registerTypeAdapter(Long.class, numberJsonSerializer)
//                .registerTypeAdapter(Float.class, numberJsonSerializer)
//                .registerTypeAdapter(Double.class, doubleJsonSerializer)
//                .create();
//        System.out.println(gson.toJson(100.0f));//结果："100.0"
//        System.out.println(gson.toJson(100.00));//结果："100.0"
//        System.out.println(gson.toJson(new Integer("100")));//结果："100.0"
    }
}

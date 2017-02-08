package com.pengzhangg.study.cache.redis;

import redis.clients.jedis.Jedis;

/**
 * Author: Zhang Peng
 * Date: 2016/12/28 0028
 * Description:
 */
public class RedisTest {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("10.239.11.19");
        System.out.println("Connection to server sucessfully");
        //查看服务是否运行
        System.out.println("Server is running: " + jedis.ping());
    }
}

package com.pengzhangg.study.cache.redis;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

/**
 * Author: Zhang Peng
 * Date: 2016/12/28 0028
 * Description:
 */
public class RedisKeyTest {
    private static final Logger logger = Logger.getLogger(RedisListTest.class);

    public static void main(String[] args) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("10.239.11.19");
            if ("PONG".equals(jedis.ping())) {
                logger.info("redis is connected!");
                // 获取数据并输出
                Set<String> set = jedis.keys("*");
                Iterator iterator = set.iterator();
                while (iterator.hasNext()){
                    logger.info("redis key : " + iterator.next());
                }
            } else {
                logger.info("redis isn`t connect!");
            }
        } catch (Exception e) {
            logger.info("visit redis error:", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}

package com.pengzhangg.study.cache.redis;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

/**
 * Author: Zhang Peng
 * Date: 2016/12/28 0028
 * Description:
 */
public class RedisStringTest {

    private static final Logger logger = Logger.getLogger(RedisStringTest.class);

    public static void main(String[] args) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("10.239.11.19");
            if ("PONG".equals(jedis.ping())) {
                logger.info("redis is connected!");
                jedis.set("user_name", "pengzhangg");
                String userName = jedis.get("user_name");
                logger.info("user_name = " + userName);
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

package com.pengzhangg.study.cache.redis;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Author: Zhang Peng
 * Date: 2016/12/28 0028
 * Description:
 */
public class RedisListTest {
    private static final Logger logger = Logger.getLogger(RedisListTest.class);

    public static void main(String[] args) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("10.239.11.19");
            if ("PONG".equals(jedis.ping())) {
                logger.info("redis is connected!");
                //存储数据到列表中
                jedis.lpush("test_list", "Redis");
                jedis.lpush("test_list", "Mongodb");
                jedis.lpush("test_list", "Mysql");
                // 获取存储的数据并输出
//                jedis.sort("test_list");
                List<String> list = jedis.lrange("test_list", 0 ,5);
                for(int i=0; i<list.size(); i++) {
                    logger.info("Stored string in redis:: "+list.get(i));
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

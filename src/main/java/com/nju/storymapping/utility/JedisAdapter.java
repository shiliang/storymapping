package com.nju.storymapping.utility;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;

@Service
public class JedisAdapter implements InitializingBean {

    private JedisPool pool;
    public static void print(int index, Object obj) {
        System.out.println(String.format("%d, %s", index, obj.toString()));
    }

    public static void main(String[] argv) {
        Jedis jedis = new Jedis("redis://47.101.197.161:6379/9");
        jedis.flushDB();

        String listName = "list";
        jedis.del(listName);

        for (int i = 0; i < 10; i++) {
            jedis.lpush(listName, "a" + String.valueOf(i));
        }

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        pool = new JedisPool("redis://47.101.197.161:6379/10");
    }

    public long sadd(String key, String value) {
        Jedis jedis = null;
        jedis = pool.getResource();
        //加入事务
        String watch = jedis.watch(key);
        Transaction multi = jedis.multi();
        try {

            multi.sadd(key, value);
            //jedis.sadd(key, value);
            List<Object> exec = multi.exec();
        } catch (Exception e) {
            e.printStackTrace();
            //只是终止队列中的事务没有回滚操作
            multi.discard();
        } finally {
                jedis.unwatch();
                jedis.close();

        }

        return 0;
    }

    public long srem(String key, String value) {
        Jedis jedis = null;
        jedis = pool.getResource();
        String watch = jedis.watch(key);
        Transaction multi = jedis.multi();
        try {

            multi.srem(key, value);
            List<Object> exec = multi.exec();
            //jedis.srem(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            multi.discard();
        } finally {
                jedis.unwatch();
                jedis.close();
        }

        return 0;
    }

    public long scard(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.scard(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

        return 0;
    }

    public boolean sismember(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.sismember(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

        return true;
    }
}

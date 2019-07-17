package RedisOp;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Slf4j
public class JedisPoolDAO {

    public static JedisPool pool=null;
    static
    {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(30);
        poolConfig.setMinIdle(10);
        poolConfig.setMaxIdle(20);
        //获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
        poolConfig.setMaxWaitMillis(10000);
        //最好设置最大连接时间
        pool = new JedisPool(poolConfig, "101.132.187.128", 6379);
    }
    public static Jedis getJedis()  {
        try{
            Jedis jedis = pool.getResource();
            jedis.auth("root");
            return jedis;
        }catch (Exception e)  //根据不同的异常类型 确定错误
        {
            log.error("超时");
            log.error(e.getMessage());
        }
        return null;
    }

}

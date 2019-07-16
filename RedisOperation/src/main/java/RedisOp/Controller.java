package RedisOp;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
@Scope("prototype") //声明Scope为Prototype
public class Controller {
    int i=1;
   /* @Autowired
    private RedisTemplate<String, String> redisTemplate;*/

    @RequestMapping("/hello")
    public String name(String name) throws Exception
    {
        Jedis jedis= JedisPoolDAO.getJedis();
        if(jedis!=null)
        {
            try{
                Category category=new Category(1,"da");
                jedis.set("hello", JSON.toJSONString(category));
                Category category1=JSON.parseObject(jedis.get("hello"),Category.class);
                i++;
                System.out.println(i);
                System.out.println(name);
            }
            finally {
                jedis.close();  //关闭资源
            }

        }
        return "hello";

    }

}
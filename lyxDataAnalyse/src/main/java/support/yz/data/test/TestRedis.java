package support.yz.data.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import support.yz.data.configure.RedisUtil;

public class TestRedis {
    @Autowired
    private RedisUtil redisUtil;
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        RedisUtil redisUtil=(RedisUtil)ctx.getBean("redisManager");
        redisUtil.getJedis();
        redisUtil.getObject("name");
        redisUtil.setObject("name","人工智能",1);

//        redisManager.flushDB();
//        redisManager.set("string_test", "string_test");
//        System.out.println("===string类型====："+redisManager.get("string_test"));
//
//        redisManager.sadd("set_test", "set_1");
//        redisManager.sadd("set_test", "set_2");
//        redisManager.sadd("set_test", "set_3");
//        System.out.println("===set类型====："+redisManager.smembers("set_test"));
//
//        redisManager.hset("Hash_test", "name", "kxl");
//        redisManager.hset("Hash_test", "age", "25");
//        redisManager.hset("Hash_test", "sex", "male");
//        System.out.println("===hash类型====："+redisManager.hget("Hash_test", "name"));
//
//        Map<String, String>maps=new HashMap<String, String>();
//        maps.put("name", "xiaohong");
//        maps.put("age", "20");
//        maps.put("sex", "female");
//        redisManager.hmset("Hash_test2", maps);
//        System.out.println("===hash类型测试2====："+redisManager.hmget("Hash_test2","name","age"));
//
//        redisManager.lpush("List", "3");
//        redisManager.lpush("List", "7");
//        redisManager.lpush("List", "1");
//        System.out.println("===List类型====："+redisManager.lrange("List", 0, -1));
//
//        redisManager.zadd("sorted set", 10, "set1");
//        redisManager.zadd("sorted set", 2, "set2");
//        redisManager.zadd("sorted set", 3, "set3");
//        System.out.println("==sorted sett类型====："+redisManager.zrevrangeByScore("sorted set", 10, 0));

    }
}

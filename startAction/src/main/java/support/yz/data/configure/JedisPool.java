package support.yz.data.configure;

public class JedisPool {
    public JedisPool(JedisPoolConfig config, String addr, int port, int timeout, String auth) {
    }

    public Jedis getResource() {
        return null;
    }

    public void returnResource(Jedis jedis) {
    }
}

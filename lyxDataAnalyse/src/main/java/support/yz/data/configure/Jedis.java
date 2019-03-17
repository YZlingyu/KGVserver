package support.yz.data.configure;

public class Jedis {

    public byte[] get(byte[] bytes) {
        return bytes;
    }

    public void close() {
    }

    public String set(byte[] bytes, Object serializable) {
        return "yes";
    }

    public void expire(byte[] bytes, int expiretime) {
    }

    public Long del(byte[] bytes) {

        return null;
    }

    public Boolean exists(byte[] bytes) {
        return true;
    }
}

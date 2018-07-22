package support.yz.data;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @Author yangzhou
 * @Description: 数据分析系统后台启动类
 * @Date: 2018/7/17
 */
@SpringBootApplication
public class KGVApp {
	public static void main(String[] args){
		ApplicationContext ctx = SpringApplication.run(KGVApp.class, args);
	}
}

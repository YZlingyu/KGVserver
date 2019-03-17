package support.yz.data;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

/**
 * @Author yangzhuo
 * @Description: 数据分析系统后台启动类
 * @Date: 2018/7/17
 */
@SpringBootApplication
@ServletComponentScan
public class KGVApp {
	public static void main(String[] args){

		//ApplicationContext ctx = SpringApplication.run(KGVApp.class, args);
		System.out.print("redis的key值是：KGV_admin_knowledgeGraph,value值是：\"data\": [\n" +
				"        {\n" +
				"            \"id\": 195,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"神经网络\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 94,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"人工智能技术\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 93,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"计算机科学\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 134,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"知识表示\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 92,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"社交智能\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 133,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"规范化和稳定\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 132,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"方法\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 131,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"应用\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 130,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"大数\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 129,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"数据库\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 3,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"计算机性能分析\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 41,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"程序\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 40,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"信息化和编码理论\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 20,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"计算理论\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 2,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"平台\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 0,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"统计学习方法\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 128,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"逻辑\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 125,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"自然语言\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 124,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"优化算法\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 123,\n" +
				"            \"techno\": \"\",\n" +
				"            \"name\": \"算法\",\n" +
				"            \"level\": null,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 1174,\n" +
				"            \"techno\": null,\n" +
				"            \"name\": \"社交智能\",\n" +
				"            \"level\": 2,\n" +
				"            \"拥有\": null\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 1173,\n" +
				"            \"techno\": null,\n" +
				"            \"name\": \"遗传算法\",\n" +
				"            \"level\": 2,\n" +
				"            \"拥有\": null\n" +
				"        }\n" +
				"    ]");
	}
}

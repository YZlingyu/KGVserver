package support.yz.data.entity.node;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewsBaseOriginal {
	private String news_id;
	private List<String> ner_nos;
	private List<String> ner_names = new ArrayList<String>(); //一篇新闻中提取的企业实体
	private String keywords;
	private int state;
	private String time;
	private String database_time;
	private String title;  //新闻标题（周康）
	private String abstractt;  //新闻摘要（周康）
}

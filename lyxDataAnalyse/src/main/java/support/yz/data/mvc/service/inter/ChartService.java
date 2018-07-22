package support.yz.data.mvc.service.inter;

import support.yz.data.entity.Chart;

/*
 * 生成图表服务接口
 */
public interface ChartService {

    /*
     * 保存图表方法
     */
    public boolean saveChart(Chart chart) throws Exception;
}

package support.yz.data.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import support.yz.data.entity.Chart;
import support.yz.data.entity.response.DataResponse;
import support.yz.data.mvc.service.inter.ChartService;

@RestController
@RequestMapping(value = "/KGV/chart/")
public class CharController {

    private ChartService chartService;

    @RequestMapping(value = "saveChart", method = RequestMethod.POST)
    public DataResponse saveChart(Chart chart){
        try{
            Boolean result = chartService.saveChart(chart);
            return new DataResponse("success","200",result);
        } catch (Exception e){
            return DataResponse.getErrDataResponse();
        }
    }
}

package support.yz.data.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangzhuo
 * @Description: 实体信息接口
 * @Date: 2018/10/23
 */
@CrossOrigin
@RestController
@RequestMapping(value="/KGV/entityInfo/")
public class EntityInfoController {

    private final static Logger logger = LoggerFactory.getLogger(EntityInfoController.class);

}

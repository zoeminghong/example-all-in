package query.controller;

import com.ecfront.dew.common.Resp;
import query.entity.Rds;
import query.service.RdsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/rds")
public class RdsController {
    private final static Logger logger = LoggerFactory.getLogger(OdpsController.class);
    @Autowired
    private RdsService rdsService;

    @GetMapping
    public Resp<List<Rds>> getValue(
            @RequestParam(value = "werks", required = false) String werks,
            @RequestParam(value = "posid", required = false) String posid,
            @RequestParam(value = "matkl1", required = false) String matkl1,
            @RequestParam(value = "matkl2", required = false) String matkl2,
            @RequestParam(value = "matkl3", required = false) String matkl3,
            @RequestParam(value = "matnr", required = false) String matnr
    ) {
        Rds rds = new Rds();
        try {
            rds.setWerks(werks);
            rds.setPosid(posid);
            rds.setMatkl1(matkl1);
            rds.setMatkl2(matkl2);
            rds.setMatkl3(matkl3);
            rds.setMatnr(matnr);
            return Resp.success(rdsService.queryRdsValue(rds));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询RDS数据失败：{}", e.getMessage());
            return Resp.badRequest(e.getMessage());
        }
    }

    @GetMapping(value = "/xtyy/mbew")
    public Resp<List<Map<String, Object>>> getRdsXtyyMbew(
            @RequestParam(value = "dmdatauptime", required = false) String dmdatauptime) {
        try {
            Rds rds = new Rds();
            rds.setDmdatauptime(dmdatauptime);
            return Resp.success(rdsService.queryRdsXtyyMbew(rds));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询RDS数据失败：{}", e.getMessage());
            return Resp.badRequest(e.getMessage());
        }
    }

}


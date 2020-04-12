package com.zerostech.stock.broadcast.service;

import com.ecfront.dew.common.$;
import com.fasterxml.jackson.databind.JsonNode;
import com.zerostech.stock.broadcast.CommonConstants;
import com.zerostech.stock.broadcast.dto.CurrentStockDTO;
import com.zerostech.stock.broadcast.entity.StockInfo;
import com.zerostech.stock.broadcast.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2020-03-19.
 *
 * @author 迹_Jason
 */
@Service
public class SelectStockTimerBroadcast {

    private final static Logger logger = LoggerFactory.getLogger(SelectStockTimerBroadcast.class);

    private final static String STOCK_URL = "https://gw.datayes.com/rrp_adventure/web/search/stockInfo?ticker=";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private StockInfoService stockInfoService;

    //    @Scheduled(cron = "0 0/1 * * * ?")
    @Scheduled(cron = "0 35 9,10,11,12,13,14 * * ?")
    public void query() {
        List<StockInfo> stockInfos = stockInfoService.getStockInfo();
        if (stockInfos != null) {
            Map<String, String> header = new HashMap<>();
            if (redisTemplate.hasKey(CommonConstants.RedisKey.TOKEN_KEY)) {
                header.put("cookie", StringUtils.patternText("cloud-sso-token={};",
                        redisTemplate.opsForValue().get(CommonConstants.RedisKey.TOKEN_KEY)));
            } else {
                logger.error("cloud-sso-token 不存在");
                $.http.get(StringUtils.patternText("https://api.day.app/GkYbxKAZe3x9L4JJ5YQJcM/{}/{}", "cloud-sso-token 不存在"));
            }
            logger.info("开始执行...");
            for (StockInfo s : stockInfos) {
                JsonNode requestResult = $.json.toJson($.http.get(STOCK_URL + s.getCode(), header));
                String status = requestResult.get("message").asText();
                if ("success".equalsIgnoreCase(status)) {
                    CurrentStockDTO currentStock = $.json.toObject(requestResult.get("data"), CurrentStockDTO.class);
                    // 最新价格
                    double lastPrice = currentStock.getLastPrice();
                    // 涨跌幅度
                    double valueDelta = currentStock.getValueDelta();
                    // 涨跌价格
                    double priceDelta = currentStock.getPriceDelta();
                    // 股票名称
                    String shortNM = currentStock.getShortNM();
                    logger.debug(lastPrice + "");
                    logger.debug(valueDelta + "");
                    logger.debug(priceDelta + "");
                    logger.debug(shortNM);
                    String textMessage = null;
                    try {
                        textMessage = URLEncoder.encode(StringUtils.patternText("当前幅度已经达到{}【{}】，最新报价为{}", valueDelta, priceDelta * 100 + "%", lastPrice), "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    $.http.get(StringUtils.patternText("https://api.day.app/GkYbxKAZe3x9L4JJ5YQJcM/{}/{}", shortNM, textMessage));

                    if (s.getGoalPrice() != null && currentStock.getLastPrice() > s.getGoalPrice().doubleValue()) {
                        $.http.get(StringUtils.patternText("https://api.day.app/GkYbxKAZe3x9L4JJ5YQJcM/{}/{}", shortNM + "到达目标值了，可以准备卖了！！"));
                    }
                }
            }
        }


    }
}

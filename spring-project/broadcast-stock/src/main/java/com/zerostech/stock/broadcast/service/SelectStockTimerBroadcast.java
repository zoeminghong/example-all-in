package com.zerostech.stock.broadcast.service;

import com.ecfront.dew.common.$;
import com.fasterxml.jackson.databind.JsonNode;
import com.zerostech.stock.broadcast.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2020-03-19.
 *
 * @author 迹_Jason
 */
@Service
public class SelectStockTimerBroadcast {

    private final static Logger logger = LoggerFactory.getLogger(SelectStockTimerBroadcast.class);

    private final static String[] STOCK = new String[]{"000629","600664","512720","000671"};
    private final static String STOCK_URL = "https://gw.datayes.com/rrp_adventure/web/search/stockInfo?ticker=";

//    @Scheduled(cron = "0 0/5 * * * ?")
    @Scheduled(cron = "0 5 10,11,12,14,15 * * ?")
    public void query() {

        Map<String, String> header = new HashMap<>();
        header.put("cookie", "cloud-sso-token=B617218007C0CC4D57FD2A26125F7425;");

        logger.info("开始执行...");
        for (String s : STOCK) {
            JsonNode requestResult = $.json.toJson($.http.get(STOCK_URL + s, header));
            String status = requestResult.get("message").asText();
            if ("success".equalsIgnoreCase(status)) {
                JsonNode data = requestResult.get("data");
                // 最后价格
                double lastPrice = data.get("lastPrice").asDouble();
                // 涨跌幅度
                double valueDelta = data.get("valueDelta").asDouble();
                // 涨跌价格
                double priceDelta = data.get("priceDelta").asDouble();
                // 股票名称
                String shortNM = data.get("shortNM").asText();
//                System.out.println(lastPrice);
//                System.out.println(valueDelta);
//                System.out.println(priceDelta);
//                System.out.println(shortNM);
                String textMessage = null;
                try {
                    textMessage = URLEncoder.encode(StringUtils.patternText("当前幅度已经达到{}【{}】，最新报价为{}", valueDelta, priceDelta, lastPrice), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                $.http.get(StringUtils.patternText("https://api.day.app/GkYbxKAZe3x9L4JJ5YQJcM/{}/{}", shortNM, textMessage));
            }
        }

    }
}

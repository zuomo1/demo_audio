package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

@Slf4j
public class ReptileUtil {

    private static String url = "https://ting55.com/book/655-";
    private static String setNumber = "844";

    //爬虫爬取网页的mp3音频
    public static String getMp3(String number) {
        //mp3音频的地址
        String novelUrl = "";
        if (!StringUtil.isBlank(number)){
            setNumber = number;
        }
        Document doc;
        try {
            doc = Jsoup.connect(url + setNumber).get();
            Element element = doc.getElementsByAttributeValue("class", "h-play").first();
            Elements h1s = element.getElementsByTag("h1");
            Element element1 = h1s.get(0);
            System.out.println("正在播放的小说是:  "+element1.text());
            Elements ele = doc.select("audio");
            //获取http开头的位置
            int http = ele.toString().lastIndexOf("http");
            //获取mp3结尾的位置
            int mp3 = ele.toString().lastIndexOf("mp3") + 3;
            //获取播放地址
            novelUrl = ele.toString().substring(http, mp3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return novelUrl;
    }
}

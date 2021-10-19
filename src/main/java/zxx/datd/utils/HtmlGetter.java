package zxx.datd.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zxx.datd.MainClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2021/9/23 16:15
 * @Author yc
 * @Version 1.0
 **/
public class HtmlGetter {
    private static Logger logger= LoggerFactory.getLogger(MainClass.class);

    public static List<Map> htmpGet(String domain) {
        List<Map>result=new ArrayList<>();
//        String html = RestTemplateUtil.getInstance().getForObject("https://"+domain, String.class);
        try {
            String html2 = RestTemplateUtil.getInstance().getForObject("http://"+domain, String.class);
//            Map httpsmap = map(html);
            Map httpmap=map(html2);
//            result.add(httpsmap);
            result.add(httpmap);
        } catch (Exception e) {
            Map<String,String>paramMap=new HashMap<>();
            paramMap.put("error",e.getMessage());
            result.add(paramMap);
            logger.debug("httpget:"+e.getMessage());
        }
        return result;
    }


    public static Map map(String html) throws IOException {

        Map res = new HashMap();
        String bodyText = new String();
        String title = new String();
        String description = new String();
        String keywords = new String();
        Document doc = null;
        try {
            //使用Jsoup解析html
            doc = Jsoup.parse(html);
            //去除隐藏的html标签
            doc.select("*[style*=display:none]").remove();
            //获取title文本
            Elements titles = doc.select("title");
            for (Element element : titles) {
                title = title + element.text();
            }
            //获取keywords文本
            Elements metaKey = doc.select("meta[name=keywords]");
            for (Element element : metaKey) {
                keywords = keywords + element.attr("content");
            }
            //获取description文本
            Elements metaDes = doc.select("meta[name=description]");
            for (Element element : metaDes) {
                description = description + element.attr("content");
            }
            //获取body文本
            Elements body = doc.select("body");
            for (Element element : body) {
                bodyText = bodyText + element.text();
            }
            //仅保留数字、字母、中文、常用的标点符号
            res.put("title",title.replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.，、,。？“”]+", ""));
            res.put("keywords",keywords.replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.，、,。？“”]+", ""));
            res.put("description",description.replaceAll( "[^0-9a-zA-Z\u4e00-\u9fa5.，、,。？“”]+", ""));
            res.put("bodyText",bodyText.replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.，、,。？“”]+", ""));
        } catch (Exception e) {
            bodyText = "";
        }
        return res;
    }
}

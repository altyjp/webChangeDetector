/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.altyjp.webChangeDetector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


/**
 *
 * @author satouryou
 */
public class MaskXml {
    /**
     * xmlをマスクする
     * @param str_xml
     * @return
     * @throws Exception 
     */
    public String xmlMasks(String str_xml) throws Exception {

        System.out.println("Start xmlMasks");
        
        Document doc = Jsoup.parse(str_xml);
        Elements topicTables = doc.getElementsByClass("topic_table");
        String textData = topicTables.text();
        
        System.out.println("DATA:" + textData);
        
        System.out.println("END xmlMasks");
        
        return textData;
    }
}

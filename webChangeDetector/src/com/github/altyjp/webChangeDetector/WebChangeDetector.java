/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.altyjp.webChangeDetector;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author satouryou
 */
public class WebChangeDetector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            //HTTP通信でデータを取得する。
            HtmlGetter htmlGetter
                    = new HtmlGetter("http://littlebullet.webdeki-bbs.com");
            String str_xml = HtmlGetter.executeGet();

            //取得した部分に対してマスクし、注目する部分を作成する。
            MaskXml maskXml = new MaskXml();
            String str_newData = maskXml.xmlMasks(str_xml);

            //セーブデータを取得する。
            CompareAndFiles comp = new CompareAndFiles();
            //セーブデータを作成する。
            //新規の場合はデータを更新して終了。
            if (comp.createSaveData()) {
                comp.wirteSaveData(str_newData);
                System.out.println("INFO:SaveData not found");
                return;
            }

            //前の情報を取得する。
            String str_oldData = comp.readSaveData();

            //比較する
            boolean isUpdate = !str_oldData.equals(str_newData);

            if (isUpdate) {
                System.out.println("INFO:Web page has been updated");
                //ツイッターへのアクセス準備
                TweetStrings tweetStr = new TweetStrings();
                //ツイートを行う。
                tweetStr.tweetString("LBの掲示板が更新されました！チェックしてくださいね！ http://bit.ly/2hzo0Xz");
                //セーブデータを更新する。
                comp.wirteSaveData(str_newData);
            }else{
                System.out.println("INFO:No Changes");
            }

        } catch (Exception ex) {
            Logger.getLogger(WebChangeDetector.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

package com.example.demo.util;

import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.Header;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author: Wenqi.Tai
 * @Description: //https://blog.csdn.net/xiliangdjw/article/details/86131741  java通过url播放远程mp3及获取播放时长
 * @Date:Create：in 2019/4/27 6:07
 * @Modified By：
 */
public class MediaPlayUtil {

    //java通过url播放远程mp3及获取播放时长
    public static Integer ReadMp3(String songName, Integer type) throws IOException, Exception {
//        _songName = songName;
        URL url = new URL(ReptileUtil.getMp3(""));
        URLConnection con = null;
        try {
            con = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
        Bitstream bt = new Bitstream(bis);

        //获取mp3时间长度
        Header header = bt.readFrame();
        int mp3Length = con.getContentLength();
        int time = (int) header.total_ms(mp3Length);
        System.out.println(time / 1000);

        Player player = new Player(bis);
        if (type == 1) {
            player.play();
        } else {
            player.close();
        }
        return time;
    }

    //播放本地音频文件
    public static void PlayLocalMp3(String songName) throws IOException, Exception {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(songName)));
        Player player = new Player(bis);
        player.play();
    }

}

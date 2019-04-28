package com.example.demo.util;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.io.FileInputStream;

/**
 * @Author: Wenqi.Tai
 * @Description: 播放音频工具类
 * @Date:Create：in 2019/4/27 5:38
 * @Modified By：
 */
public class AudioPlayUtil extends JApplet {

    /**
     * Create the applet.
     */
    public static void play(String mediaUrl) {
        try {
            FileInputStream fileau = new FileInputStream(mediaUrl);
            AudioStream as = new AudioStream(fileau);
            AudioPlayer.player.start(as);
        } catch (Exception e) {
        }
    }
}

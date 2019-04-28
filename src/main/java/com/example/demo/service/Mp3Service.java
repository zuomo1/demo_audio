package com.example.demo.service;

import com.example.demo.play.Sound;
import com.example.demo.util.ReptileUtil;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.stereotype.Service;

/**
 * @Author: Wenqi.Tai
 * @Description:
 * @Date:Create：in 2019/4/27 5:07
 * @Modified By：
 */
@Service
public class Mp3Service extends Application {
    private Sound sound;// 注意，我这里是为了防止被JVM的垃圾回收给回收掉

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(primaryStage);
        //获取想要要播放的mp3的音频地址
        String mp3 = ReptileUtil.getMp3("");
        // 直接复制下来没效果可能是因为连接地址失效了
        sound = new Sound(mp3, false);
        sound.loop();// 循环播放
    }

    public void launch() {
        launch("");// 初始化
    }
}

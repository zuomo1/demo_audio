package com.example.demo.controller;

import com.example.demo.play.Sound;
import com.example.demo.service.Mp3Service;
import com.example.demo.util.AudioPlayUtil;
import com.example.demo.util.MediaPlayUtil;
import com.example.demo.util.ReptileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Wenqi.Tai
 * @Description: 构建一个api接口 供前端调用 实现 爬取网页音频 自动播放 播放结束后 自动播放下一集
 * @Date:Create：in 2019/4/27 4:09
 * @Modified By：
 */
@RestController
@RequestMapping("/")
public class Mp3Controller {

    private Sound sound;// 注意，我这里是为了防止被JVM的垃圾回收给回收掉
    @Autowired
    private Mp3Service service;

    @RequestMapping("/play/{number}")
    public void playMp3ByNumber(@PathVariable String number/*@RequestBody Mp3Req req*/) throws Exception {
        //获取要播放的集数
//        String number = req.getNumber();
        //获取待播放的音频地址
        String mp3Url = ReptileUtil.getMp3(number);
        //播放音频
//        service.launch();
//        AudioPlayUtil.play(mp3Url);
        //播放远程音频
        MediaPlayUtil.ReadMp3(mp3Url,1);
    }
}

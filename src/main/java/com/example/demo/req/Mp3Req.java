package com.example.demo.req;

import lombok.*;

import java.io.Serializable;

/**
 * @Author: Wenqi.Tai
 * @Description: mp3播放请求类
 * @Date:Create：in 2019/4/27 4:21
 * @Modified By：
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mp3Req implements Serializable{
    //播放的集数
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

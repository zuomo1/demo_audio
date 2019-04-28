package com.example.demo.musicPlayer;

import com.example.demo.util.MediaPlayUtil;
import com.example.demo.util.ReptileUtil;

import java.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.*;
import javax.swing.table.*;
import java.net.*;

public class t3 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JTextField filePath = null;
    private JButton openFile = null;
    private JButton playButton = null;
    private JButton autoUrlButton = null;
    private File selectedFile;
    private AudioClip audioClip;

    //显示选择的音频文件
    private JTextField getJTextField() {

        if (filePath == null) {
            filePath = new JTextField();
            filePath.setPreferredSize(new Dimension(200, 20));//设置文本框的大小
            filePath.setBackground(Color.WHITE);
            filePath.setEditable(false);//设置文本框不能进行编辑
        }
        return filePath;
    }

    // 获取选择音频文件按钮
    private JButton getOpenFile() {

        if (openFile == null) {
            openFile = new JButton();
            openFile.setText("选择音频");
            openFile.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();//文件选择器
                    fileChooser.setFileFilter(new FileNameExtensionFilter("支持的音频文件（*.MP3、*.WAV）", "wav", "WAV", "mp3", "MP3"));//设置支持选择的音频文件格式
                    fileChooser.showOpenDialog(t3.this);
                    selectedFile = fileChooser.getSelectedFile();//获取选择的音频文件
                    filePath.setText(selectedFile.getAbsolutePath());//文本框显示选择的音频文件
                }
            });
        }
        return openFile;
    }

    // 获取自动获取音频的地址url
    private JButton getAutoUrlButton() {

        if (autoUrlButton == null) {
            autoUrlButton = new JButton();
            autoUrlButton.setText("自动获取音频地址");
            autoUrlButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    //根据爬虫获取的地址设置
                    filePath.setText(ReptileUtil.getMp3(""));//文本框显示选择的音频文件
                }
            });
        }
        return autoUrlButton;
    }

    // 获取播放按钮
    private JButton getPlayButton() {
        if (playButton == null) {
            playButton = new JButton();
            playButton.setText("播放音频");
            playButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                    if (selectedFile != null) {

                        try {

                            //判断 在目前播放的音频是 远程的链接 还是 本地的音频文件
                            int http = filePath.getText().lastIndexOf("http");
                            System.out.println(http);
                            //说明是播放的远程音频
                            if (http != -1) {
//                                MediaPlayUtil.ReadMp3(filePath.getText(),2);
                                MediaPlayUtil.ReadMp3(filePath.getText(),1);
                            }else{
                                if (audioClip != null) {//如果有音频在播放
                                    audioClip.stop();//停止当前音频的播放
                                }
                                audioClip = Applet.newAudioClip(selectedFile.toURI().toURL());//获取选择的音频
                                audioClip.play();//播放音频
                            }
                        } catch (MalformedURLException e1) {
                            e1.printStackTrace();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });
        }
        return playButton;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        t3 test = new t3();
        test.setVisible(true);

    }

    public t3() {
        super();
        setTitle("Hern");
        setBounds(400, 400, 400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(getJContentPane());

    }


    // 初始化内容面板的方法
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new FlowLayout());
            jContentPane.add(getJTextField(), null);
            jContentPane.add(getOpenFile(), null);
            jContentPane.add(getPlayButton(), null);
            jContentPane.add(getAutoUrlButton(), null);
        }
        return jContentPane;
    }

}
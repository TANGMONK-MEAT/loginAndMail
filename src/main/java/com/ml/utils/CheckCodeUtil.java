package com.ml.utils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author ZWL
 * @version : 1.0
 * @date : 2020/2/14 13:27
 */
public class CheckCodeUtil {

    public static void getCheckCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int width = 130;
        int height = 45;
        // 1,创建一个对象，在内存中代表一个图片（验证码图片对象）
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        // 2，美化图片
        // 2.1,填充背景色
        // 获取图片对象的画笔
        Graphics g = image.getGraphics();
        // 设置画笔颜色
        g.setColor(Color.GRAY);
        // 填充图片
        g.fillRect(0, 0, width, height);
        // 2.2,画边框
        g.setColor(Color.yellow);
        g.drawRect(0, 0, width - 1, height - 1);
        // 2.3,写验证码
        String str = "ABCDEFGHIJKLMOPQESTUVWXYZabcdefghijklmopqrstuvwxya0123456789";
        // 随机对象
        Random random = new Random();
        g.setFont(new Font("黑体", Font.BOLD, 25));
        char ch = ' ';
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            // 随机字符
            ch = str.charAt(random.nextInt(str.length()));
            g.drawString(ch + "", width / 5 * i, height / 2);
            strBuilder.append(ch);
        }
        //四位字符的验证码
        String checkCode = strBuilder.toString();
        //获取Session
        request.getSession().setAttribute("checkCode", checkCode);
        // 2.4,绘制干扰线
        g.setColor(Color.green);
        // 随机生成坐标点
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }
        // 3，将图片输出到页面展示
        ImageIO.write(image, "jpeg", response.getOutputStream());
    }
}

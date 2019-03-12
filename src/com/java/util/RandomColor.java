package com.java.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

/**
 * 随机颜色
 * @author Moe
 * 2019.3.12
 */

public class RandomColor {

   public static void main(String[] args) throws IOException {
    //随机种子
    Random random = new Random();
    //生成RadRandom
    int red = random.nextInt(256);
    //生成GreenRandom
    int green = random.nextInt(256);
    //生成BlueRandom
    int blue = random.nextInt(256);
    System.out.println("R:"+red+",G:"+green+",B:"+blue);
    //开始用随机颜色绘制图片
    //在图片缓冲区生成一个图片对象,指定图片大小和类型
    BufferedImage bufferedImage = new BufferedImage(120,40,BufferedImage.TYPE_INT_RGB);

    //获取画笔
    Graphics g = bufferedImage.getGraphics();
    //设置字体
    Font font = new Font("微软雅黑",Font.BOLD,16);
    g.setFont(font);
    //设置画笔颜色
    Color color1 = new Color(red,green,blue);
    g.setColor(color1);
    //开始绘制,充满图片缓存区
    g.fillRect(0,0,120,40);
     String vliCode="";
     while(vliCode.length()<4){
       g.setColor(new Color(random.nextInt(255)+1,random.nextInt(255)+1,random.nextInt(255)+1));		//随机得到颜色用于绘制内容
       String tmp="";
       //the style of the code
       switch(random.nextInt(3)){
         case 0:
           tmp=(char)(random.nextInt(26)+65)+"";				//得到a-z的26字母
           break;
         case 1:
           tmp=(char)(random.nextInt(26)+97)+"";				//得到A-Z的26字母
           break;
         default:
           tmp=random.nextInt(10)+"";								//得到数字0-9
           break;
       }
       g.drawString(tmp,10+vliCode.length()*20,20);		//此步为在x坐标为（10+vliCode.length()*20）y坐标为20的地方绘制内容为tmp的字符图。
       vliCode+=tmp;
     }
     //绘制干扰线
     for(int i=0;i<(random.nextInt(110)+10);i++){
       g.setColor(new Color(random.nextInt(255)+1,random.nextInt(255)+1,random.nextInt(255)+1));	//设置干扰线的颜色
       g.drawLine(random.nextInt(100),random.nextInt(30),random.nextInt(100),random.nextInt(30));				//设置干扰线的坐标
     }
    //输出图片
    //指定文件路径
    File file = new File("D:/code.jpg");
    //获取输出流
    OutputStream outputStream = new FileOutputStream(file);
    //将图片从缓存区通过字节流输出图片
    ImageIO.write(bufferedImage,"jpg",outputStream);
  }
}

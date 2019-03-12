package com.java.util;

import java.util.Random;

public class RandomDemo {
  public static void main(String[] args) {
    //随机生成5以内的随机数，包括5
    Random random = new Random();
    //[0,bound)
    int num = random.nextInt(6);
    System.out.println(num);
  }
}

package com.bones.test02;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author : bones
 * @version : 1.0
 */
public class Year_Month_Query_2 {
    private int year;
    private int month;
    private Date date;
    private int maxDay;
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final Scanner sc = new Scanner(System.in);

    public int getDays(){
        try {
            for (int i = 28; i <= 32; i++) {
                //天数从28开始依次加1
                Date d = dateFormat.parse(year + "-" + month+"-"+i);
                //如果月份变化，判断为下个月，则当月天数就统计出来了
                if (d.getMonth()!=date.getMonth()){
                    return maxDay = i-1;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void showCal(){
        System.out.println("日\t一\t二\t三\t四\t五\t六\t");
        try {
            //获取这个一号是本周的第几天
            int num = dateFormat.parse(year + "-" + month + "-01").getDay();
            //前面空出来的天数为：
            int day = num;
            //引入一个计数器：
            int count = 0;//计数器最开始值为0
            //在日期前将空格打印出来：
            for (int i = 1; i <= day; i++) {
                System.out.print("\t");
            }
            //空出来的日子也要放入计数器：
            count = count + day;
            //遍历：从1号开始到maxDay号进行遍历：
            for (int i = 1; i <= maxDay ; i++) {
                System.out.print(i+"\t");
                count++;//每在控制台输出一个数字，计数器做加1操作
                if(count%7 == 0){//当计数器的个数是7的倍数的时候，就换行操作
                    System.out.println();
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setUserDate(int year,int month){
        try {
            date = dateFormat.parse(year + "-" + month+"-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public  void getUserYear(){
        //获取用户输入的年份：
        while(true){
            year = 0;
            System.out.println("请输入您想查询的年份：（范围1600-2200）");
            try {
                year = sc.nextInt();
                //校验范围1600-2200
                if (year < 1600 || year > 2200){
                    System.out.println("输入范围有误！请重新输入：");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("输入内容包含非法字符，请重新输入：");
                sc.next();
                continue;
            }
            if (year != 0){
                break;
            }
        }
    }

    /**
     * 获取用户输入的月份并校验
     */
    public  void getUserMonth(){
        //获取用户输入的月份：
        while(true){
            month = 0;
            System.out.println("请输入您想查询的月份：");
            try {
                month = sc.nextInt();
                //校验月份
                if (month < 1|| month > 12){
                    System.out.println("输入范围有误！请重新输入：");
                    continue;
                }
                setUserDate(year,month);
            } catch (InputMismatchException e) {
                System.out.println("输入内容包含非法字符，请重新输入：");
                sc.next();
                continue;
            }
            if (month != 0){
                break;
            }
        }
    }



    public Integer getYear() {
        return year;
    }

    public Integer getMonth() {
        return month;
    }
}

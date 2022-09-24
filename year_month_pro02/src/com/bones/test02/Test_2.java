package com.bones.test02;

/**
 * @author : bones
 * @version : 1.0
 */
public class Test_2 {
    public static void main(String[] args) {
        Year_Month_Query_2 query2 = new Year_Month_Query_2();
        query2.getUserYear();
        query2.getUserMonth();
        System.out.println("感谢查询！在"+query2.getYear()+"年"+query2.getMonth()+"月中，共有"+
                query2.getDays()+"天");
        query2.showCal();


    }
}

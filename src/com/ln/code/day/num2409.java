package com.ln.code.day;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class num2409 {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        String arriveAlice = in.next();
        String leaveAlice = in.next();
        String arriveBob = in.next();
        String leaveBob = in.next();
        long sum = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
        List<Date> Bob = new ArrayList<>();
        List<Date> Alice = new ArrayList<>();
        Alice.add(dateFormat.parse(arriveAlice));
        Alice.add(dateFormat.parse(leaveAlice));
        Bob.add(dateFormat.parse(arriveBob));
        Bob.add(dateFormat.parse(leaveBob));
        int[] date = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(Alice.get(0).compareTo(Bob.get(0)) > 0){
            List<Date> temp = new ArrayList<>();
            temp = Bob;
            Bob = Alice;
            Alice = temp;
        }
        if(Alice.get(1).compareTo(Bob.get(1)) > 0){
            sum = dif(Bob.get(0),Bob.get(1));
        }
        else if(Alice.get(1).compareTo(Bob.get(0)) > 0){
            sum = dif(Bob.get(0),Alice.get(1)) + 1;
        }
        System.out.println(sum);
    }

    public static long dif(Date d1, Date d2){
        long diff = d2.getTime() - d1.getTime();  // 计算毫秒数差异
        long days = diff / (1000 * 60 * 60 * 24);  // 将毫秒数转换为天数
        return days;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        long sum = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
        List<Date> Bob = new ArrayList<>();
        List<Date> Alice = new ArrayList<>();
        try {
            Alice.add(dateFormat.parse(arriveAlice));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            Alice.add(dateFormat.parse(leaveAlice));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            Bob.add(dateFormat.parse(arriveBob));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            Bob.add(dateFormat.parse(leaveBob));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(Alice.get(0).compareTo(Bob.get(0)) > 0){
            List<Date> temp = new ArrayList<>();
            temp = Bob;
            Bob = Alice;
            Alice = temp;
        }
        if(Alice.get(1).compareTo(Bob.get(1)) > 0){
            if (Alice.get(1).equals(Bob.get(1))){
                sum = 0;
            }
            else{
                sum = dif(Bob.get(0),Bob.get(1)) + 1;
            }
        }
        else if(Alice.get(1).compareTo(Bob.get(0)) > 0){
            if (Alice.get(1).equals(Bob.get(0))){
                sum = 0;
            }
            else {
                sum = dif(Bob.get(0),Alice.get(1)) + 1;
            }
        }
        return (int) sum;
    }
    @Test
    public void test() throws ParseException {
        System.out.println(countDaysTogether("09-01","10-19","06-20", "10-20"));
    }
}

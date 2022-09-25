import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author : bones
 * @version : 1.0
 */
public class Query {
    private final Scanner sc = new Scanner(System.in);
    private int year;
    private int month;
    private LocalDate date;
    private int maxDay;

    public void setUserDate() {
        date = LocalDate.of(year, month, 1);
    }

    public int getMaxDay(){
        for (int i = 28; i < 33 ; i++) {
            try {
                LocalDate.of(year,month,i).getMonth();
            } catch (DateTimeException e) {
                maxDay = i-1;
                break;
            }
        }
        return maxDay;
    }


    public void getUserYear() {
        //获取用户输入的年份：
        while (true) {
            year = 0;
            System.out.println("请输入您想查询的年份：（范围1600-2200）");
            try {
                year = sc.nextInt();
                //校验范围1600-2200
                if (year < 1600 || year > 2200) {
                    System.out.println("输入范围有误！请重新输入：");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("输入内容包含非法字符，请重新输入：");
                sc.next();
                continue;
            }
            if (year != 0) {
                break;
            }
        }
    }

    /**
     * 获取用户输入的月份并校验
     */
    public void getUserMonth() {
        //获取用户输入的月份：
        while (true) {
            month = 0;
            System.out.println("请输入您想查询的月份：");
            try {
                month = sc.nextInt();
                //校验月份
                if (month < 1 || month > 12) {
                    System.out.println("输入范围有误！请重新输入：");
                    continue;
                }
                setUserDate();
            } catch (InputMismatchException e) {
                System.out.println("输入内容包含非法字符，请重新输入：");
                sc.next();
                continue;
            }
            if (month != 0) {
                break;
            }
        }
    }
}

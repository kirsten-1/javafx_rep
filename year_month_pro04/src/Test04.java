/**
 * @author : bones
 * @version : 1.0
 */
public class Test04 {
    public static void main(String[] args) {
        Query query = new Query();
        query.getUserYear();
        query.getUserMonth();
        int maxDay = query.getMaxDay();
        System.out.println(maxDay);

    }
}

import java.util.Random;
import java.util.Scanner;

public class wsh20221188_Mid1 {

    public static String[] bot = {"묵", "찌", "빠"};


    public static void main(String[] args) {
        System.out.println("묵찌빠 입력할 것.");
        Scanner sc = new Scanner(System.in);
        String value = sc.next();
        Methodrun(value);
    }

    private static void Methodrun(String value) {
        switch (value) {
            case "묵", "빠", "찌":
                break;
            default:
                    System.out.println("알 수 없는 값.");
                    return;
        }
        Integer random = new Random().nextInt(0, 2);
        String gameValues = gameStrat(value, bot[random]);

        if(gameValues.equalsIgnoreCase("승리")){
            System.out.println("이겼습니다.");
            return;
        } else if(gameValues.equalsIgnoreCase("패배")){
            System.out.println("졌습니다.");
            return;
        } else {
            System.out.println("비겼습니다.");
            return;
        }

    }

    private static String gameStrat(String values, String bot) {
        if(values.equalsIgnoreCase(bot)){
            System.out.println( values + " : " + bot);
            return "비김";
        }
        if(values.equalsIgnoreCase("묵") && bot.equalsIgnoreCase("찌") ||
                values.equalsIgnoreCase("찌") && bot.equalsIgnoreCase("빠") ||
                values.equalsIgnoreCase("빠") && bot.equalsIgnoreCase("묵")){
            System.out.println( values + " : " + bot);
            return "승리";
        }
        System.out.println( values + " : " + bot);
        return "패배";
    }
}

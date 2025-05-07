import java.util.*;

public class wsh20221188_Mid2 {

    static int turn = 3;
    static int playersc = 0;
    static int botsc = 0;
    static boolean repeat = true;
    public static String[] bot = {"묵", "찌", "빠"};
    static String[] player = {"묵", "찌", "빠"};

    public static void main(String[] args) {
        String winner = "";
        while (repeat){
            System.out.println("묵 찌 빠 중 하나를 입력하세요.");
            if(turn <= 0){
                if(playersc >= 3){
                    winner = "플레이어";
                    break;
                } else if(botsc >= 3) {
                    winner = "봇";
                    break;
                }
                turn = 3;
                player = new String[]{"묵", "찌", "빠"};
                bot = new String[]{"묵", "찌", "빠"};
                playersc = 0;
                botsc = 0;
                System.out.println("승리가 나오질 못했습니다. 재시작 합니다.");
                continue;
            }
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            Methodrun(s);
        }
        if(winner.equalsIgnoreCase("플레이어")){
            System.out.println("게임 종료! 승리자 -> 플레이어");
        } else {
            System.out.println("게임 종료! 승리자 -> 봇");
        }
    }

    private static void Methodrun(String value) {
        String last = "";
        boolean found = false;
            for (int i = 0; i < player.length; i++) {
                if(player[i].equalsIgnoreCase(value)) {
                    last = player[i];
                    player[i] = "";
                    found = true;
                    break;
                } else if (player[i].equalsIgnoreCase("")) {
                    continue;
            } else if (!(player[i].equalsIgnoreCase("묵")) || !(player[i].equalsIgnoreCase("찌")) || !(player[i].equalsIgnoreCase("빠"))) {
                    found = false;
                }
            }
            if(!found){
                System.out.println("알 수 없는 값.");
                return;
            }
        turn--;
        String gameValues = gameStrat(last, bot);
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

    private static String gameStrat(String values, String[] bot) {
        String botvl = "";
        int ix = 0;
            while (true){
                int random = new Random().nextInt(1, 3);
                if(!bot[random].equalsIgnoreCase("")){
                    botvl = bot[random];
                    bot[random] = "";
                    break;
                }
                if(bot[ix].equalsIgnoreCase("")) {
                    ix++;
                    if(ix >= 2){
                        ix = 0;
                        break;
                    }
                } else{
                    botvl = bot[ix];
                    bot[ix] = "";
                    break;
                }
            }
        if(values.equalsIgnoreCase(botvl)){
            System.out.println( values + " : " + botvl);
            return "비김";
        }
        if(values.equalsIgnoreCase("묵") && botvl.equalsIgnoreCase("찌") ||
                values.equalsIgnoreCase("찌") && botvl.equalsIgnoreCase("빠") ||
                values.equalsIgnoreCase("빠") && botvl.equalsIgnoreCase("묵")){
            System.out.println( values + " : " + botvl);
            playersc++;
            return "승리";
        }
        System.out.println( values + " : " + botvl);
        botsc++;
        return "패배";
    }
}

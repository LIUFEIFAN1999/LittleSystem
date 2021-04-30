import java.util.Random;
import java.util.Scanner;

public class Game {
    //被加数
    private int byAdd;
    //加数
    private int add;
    //结果
    private int result;

    //随机生成两个整数
    public void createGame(){
        Random random = new Random();
        byAdd = random.nextInt(100);
        add = random.nextInt(100);
        result = byAdd + add;
    }

    //显示问题
    public void display(){
        System.out.print(byAdd +" + "+ add +"= ");
    }

    //验证答案
    public boolean verify(int answer){
        if(answer == result){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //答案
        int answer;
        //得分
        int score = 0;
        //声明一个数组，储存十道题
        Game[] games = new Game[]{
                new Game(),
                new Game(),
                new Game(),
                new Game(),
                new Game(),
                new Game(),
                new Game(),
                new Game(),
                new Game(),
                new Game(),
        };
        System.out.println("整数加法闯关游戏：100 = 10*10");
        //游戏开始
        for(int index = 0; index < 10; index++){
            System.out.print("Question"+(index+1)+ " ");  //显示题号
            games[index].createGame();
            games[index].display();
            answer = scanner.nextInt(); //读取答案
            if(games[index].verify(answer)){
                System.out.println("计算正确");
                score += 10;
                System.out.println("目前得分："+score);
            }
            else{
                System.out.println("计算错误！再来一次！");
                answer = scanner.nextInt();
                if(games[index].verify(answer)){
                    System.out.println("计算正确");
                    score += 10;
                    System.out.println("目前得分："+score);
                }
                else{
                    System.out.println("计算错误！");
                    System.out.println("目前得分："+score);
                }
            }
        }
        System.out.println("答题结束，你的最后得分为："+score);
    }
}

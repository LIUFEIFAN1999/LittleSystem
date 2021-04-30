package GuessNumber;

import java.util.Random;
import java.util.Scanner;

public class Guess {
    private int number;
    private int guessNUmber;
    public void setNumber(){
        Random random = new Random();
        number = random.nextInt(100);
    }

    public void guessN(int n){
        guessNUmber = n;
    }
    public int verifyNumber(){
        if(this.guessNUmber<number) {
            return 0;
        }
        else if (this.guessNUmber>number) {
            return 2;
        }
        else {
            return 1;
        }
    }
}

package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.util.Scanner;

public class HumanPlayer implements Player{
    Logger logger =  LoggerFactory.getLogger("player");

    @Override
    public long askNextGuess() {
        Scanner sc = new Scanner(System.in);
        System.out.println("what's your guess");
        return sc.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater)
            logger.log("Plus Grand");
        else
            logger.log("Plus Petit ");

    }
}

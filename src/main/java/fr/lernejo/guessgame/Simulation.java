package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess=numberToGuess;
    }

    private boolean nextRound() {
        Long number = player.askNextGuess();
        if(number.equals(numberToGuess))
        {
            logger.log("Felicitation Vous avez win Age du capitaine : "+numberToGuess);
            return true;
        }
        else
        {
            if (number > numberToGuess) {
                player.respond(false);
            } else
                player.respond(true);
            return false;
        }
    }

    public void loopUntilPlayerSucceed(long max) {
        logger.log("Debut de la partie");
        boolean test=nextRound();
        int i=0;
        long Start=System.currentTimeMillis();
        long End =0;
        while(!test && i<max )
        {
            test=nextRound();
            i++;
        }
        End=System.currentTimeMillis();
        long TimeTotal = End-Start;
        Timestamp timestamp=new Timestamp(TimeTotal);
        logger.log("Temps : "+new SimpleDateFormat("mm:ss.SSS").format(timestamp));


    }
}

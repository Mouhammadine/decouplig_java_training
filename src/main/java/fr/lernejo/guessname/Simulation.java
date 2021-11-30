package fr.lernejo.guessname;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;

        SecureRandom random = new SecureRandom();
        this.initialize(random.nextInt(100));
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long guess = this.player.askNextGuess();

        if (guess == numberToGuess) {
            this.logger.log("player win");
            return true;
        } else {
            this.player.respond(guess < this.numberToGuess);
            return false;
        }
    }

    public void loopUntilPlayerSucceed(long maxIter) {
        long iter = 0;
        long startTime = System.currentTimeMillis();

        for (; iter < maxIter; iter++) {
            if (this.nextRound())
                break;
        }

        long d = System.currentTimeMillis() - startTime;
        String durationStr = String.format("%d:%02d.%03d", d / 60000, (d / 1000) % 60, (d % 1000));

        if (iter == maxIter) {
            this.logger.log("Player lose in " + durationStr);
        } else {
            this.logger.log("Player win in " + durationStr);
        }
    }
}

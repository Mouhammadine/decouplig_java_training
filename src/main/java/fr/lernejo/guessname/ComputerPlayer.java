package fr.lernejo.guessname;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer  implements Player {
    private long a = 0;
    private long b = 99;

    private final Logger logger = LoggerFactory.getLogger("computer");

    @Override
    public long askNextGuess() {
        return this.a + (this.b - this.a) / 2;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        long mid = this.askNextGuess();

        if (lowerOrGreater) {
            this.a = mid;
        } else {
            this.b = mid;
        }

        logger.log("search in [" + this.a + "; " + this.b + "]");
    }
}

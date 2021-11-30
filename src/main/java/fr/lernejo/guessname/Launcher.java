package fr.lernejo.guessname;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Launcher {
    private static class BadArgumentException extends Exception {
    }

    public static void safeMain(String[] args) throws BadArgumentException {
        long max_iter = Long.MAX_VALUE;
        String initialize = null;
        Player player;

        if (args.length == 1 && args[0].equalsIgnoreCase("-interactive")) {
            player = new HumanPlayer();
        } else if (args.length == 2 && args[0].equalsIgnoreCase("-auto")) {
            initialize = args[1];
            max_iter = 1000;
            player = new ComputerPlayer();
        } else {
            throw new BadArgumentException();
        }

        Simulation sim = new Simulation(player);

        if (initialize != null) {
            try {
                sim.initialize(Long.parseLong(initialize));
            } catch (NumberFormatException e) {
                throw new BadArgumentException();
            }
        }

        sim.loopUntilPlayerSucceed(max_iter);
    }

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("help");

        try {
            safeMain(args);
        } catch (BadArgumentException e) {
            logger.log("Usages:");
            logger.log("-interactive");
            logger.log("-auto <value>");
        }
    }
}

package fr.lernejo.guessname;

public class Launcher {
    public static void main(String[] args) {
        Simulation sim = new Simulation(new HumanPlayer());
        sim.loopUntilPlayerSucceed();
    }
}

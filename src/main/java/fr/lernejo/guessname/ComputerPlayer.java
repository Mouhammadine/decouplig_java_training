package fr.lernejo.guessname;

public class ComputerPlayer  implements Player {
    private long a = 0;
    private long b = 99;

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
    }
}

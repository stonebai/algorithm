/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int hi = n, lo = 1;
        while (true) {
            int guess = (lo + hi) / 2;
            int res = guess(guess);
            switch (res) {
                case 1:
                    lo = guess + 1;
                    break;
                case -1:
                    hi = guess - 1;
                    break;
                case 0:
                    return guess;
            }
        }
    }
}
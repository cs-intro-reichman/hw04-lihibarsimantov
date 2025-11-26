public class Primes {
    public static void main(String[] args) {
        // Sieve of Eratosthenes algorithm
        final int N = Integer.parseInt(args[0]); // the upper limit
        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;// assume all numbers are prime from 2 to N
        }
        int p = 2;
        // find all primes up to N (we can stop at sqrt(N))
        while (p <= Math.sqrt(N)) {
            int multiple = 2 * p;
            while (multiple <= N) {
                isPrime[multiple] = false; // mark multiples of p as non-prime
                multiple += p;
            }
            p++;
        }
        System.out.println("Prime numbers up to " + N + ":");
        // print all prime numbers found
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                System.out.println(i);
                count++;
            }
        }
        int average = (int) (((double) count / (double) N) * 100.0);
        System.out.println("There are " + count + " primes between 2 and " + N + " (" + average + "% are primes)");

    }
}
package cz.valkova.darja;


import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new IllegalArgumentException("Please enter only one input parameter.");
            }

            PrimeNumberReader primeNumPrinter = new PrimeNumberReader(args[0]);
            List<Integer> primNumbers = primeNumPrinter.read();

            Main.print(primNumbers);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading input file path: " + args[0]);
        }
    }

    /**
     * Print prime number to the System output
     *
     * @param primNumbers
     */
    private static void print(List<Integer> primNumbers) {
        for (Integer prim : primNumbers) {
            System.out.println(prim);
        }
    }

}

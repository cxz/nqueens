import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;


public class QueensTest {
    /**
     * Solutions up to N=27 obtained from https://oeis.org/A000170/b000170.txt
     */
    private static final String SOLUTION_PATH = "b000170.txt";

    public static Map<Integer, Long> loadSolutions(String path) throws Exception {
        Map<Integer, Long> solution = new HashMap<>();
        File f = new File(QueensTest.class.getResource(path).getFile());
        Scanner scanner = new Scanner(f);
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.startsWith("#")) {
                continue;
            }
            String[] parts = line.split(" ");
            solution.put(Integer.valueOf(parts[0]), Long.valueOf(parts[1]));
        }
        return solution;
    }


    @Test
    public void run() throws Exception {
        final Map<Integer, Long> solutions = loadSolutions(SOLUTION_PATH);
        for (int size=1; size < 10; size++) {
            long queens = solutions.get(size);
            assertEquals(queens, new Queens().run(size).size());
        }
    }

}
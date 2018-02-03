import java.util.HashSet;
import java.util.Set;

public class Queens {

    public Set<Board> run(int size) { return generate(new Board(size), 0, new HashSet<>()); }

    private Set<Board> generate(Board board, int row, Set<Board> result) {
        final int size = board.getSize();
        // the search space is broken by rows
        // we try to place a queen on each column for the current row
        for (int c=0; c < size; c++) {
            if(board.tryPlace(row, c)) {
                if (row == size - 1) { result.add(new Board(board)); }
                generate(board, row + 1, result);
            }
        }
        return result;
    }
}

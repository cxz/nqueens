import java.util.Arrays;

public class Board {
    int[] rows;

    public Board(int size) {
        this.rows = new int[size];
        Arrays.fill(this.rows, -1);

    }

    public Board(Board board) {
        this.rows =  board.rows.clone();
    }

    public int getSize() {
        return rows.length;
    }

    public boolean tryPlace(int row, int column) {
        if (valid(row, column)) {
            rows[row] = column;
            return true;
        } else {
            return false;
        }
    }

    private boolean valid(int x2, int y2) {
        for (int x=0; x<x2; x++) {
            if (rows[x] == y2) {
                //same column
                return false;
            }

            if (Math.abs(x-x2) == Math.abs(rows[x] - y2)) {
                //cannot place same diagonal
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return Arrays.toString(rows);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Arrays.equals(rows, board.rows);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rows);
    }
}
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void sameColumnIsInvalid() {
        Board b = new Board(3);
        assertEquals(false, b.tryPlace(0, 0) && b.tryPlace(1, 0));

    }

    @Test
    public void diagonalisInvalid() {
        Board b = new Board(3);
        assertEquals(false, b.tryPlace(0 ,0) && b.tryPlace(1, 1));

    }

    @Test
    public void validMoves() {
        Board b = new Board(3);
        assertEquals(true, b.tryPlace(0, 0));
        assertEquals(true, b.tryPlace(1, 2));
        //note with N=3 we cannot place any queens on third row.
    }
}

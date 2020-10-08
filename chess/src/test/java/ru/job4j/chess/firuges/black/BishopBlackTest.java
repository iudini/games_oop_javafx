package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        Figure bishopBlack = new BishopBlack(Cell.B1);
        assertThat(bishopBlack.position(), is(Cell.B1));
    }

    @Test
    public void testWay() throws ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] rsl = bishopBlack.way(Cell.G5);
        Cell[] expect = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(rsl, is(expect));
    }

    @Test(expected = IllegalStateException.class)
    public void testWrongWay() throws ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.H5);
    }

    @Test
    public void testCopy() {
        Figure bishopBlack = new BishopBlack(Cell.B1);
        bishopBlack = bishopBlack.copy(Cell.C2);
        assertThat(bishopBlack.position(), is(Cell.C2));
    }
}
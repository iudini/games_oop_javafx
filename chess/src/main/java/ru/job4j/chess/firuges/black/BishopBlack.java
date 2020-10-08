package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(dest.getX() - position.getX());
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() - position.getX() < 0 ? -1 : 1;
        int deltaY = dest.getY() - position.getY() < 0 ? -1 : 1;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(this.position.getX() + deltaX * (index + 1), this.position.getY() + deltaY * (index + 1));
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int x1 = source.getX();
        int x2 = dest.getX();
        int y1 = source.getY();
        int y2 = dest.getY();
        if (
            Math.abs(x1 - x2) == Math.abs(y1 - y2) ||
            Math.abs(x1 - x2) == Math.abs(y1 + y2) ||
            Math.abs(x1 + x2) == Math.abs(y1 - y2) ||
            Math.abs(x1 + x2) == Math.abs(y1 + y2)
        ) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

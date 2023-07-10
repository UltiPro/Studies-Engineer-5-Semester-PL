package pl.wipb.ztp.chess;

import java.awt.*;

public abstract class Decorator implements InterfacePiece {
    protected InterfacePiece piece;

    protected Decorator(InterfacePiece piece) {
        this.piece = piece;
    }

    @Override
    public void draw(Graphics2D graphics2d) {
        piece.draw(graphics2d);
    }

    @Override
    public int getX() {
        return piece.getX();
    }

    @Override
    public int getY() {
        return piece.getY();
    }

    @Override
    public void moveTo(int x, int y) {
        piece.moveTo(x, y);
    }

    @Override
    public InterfacePiece getDecorated() {
        return piece;
    }
}
package pl.wipb.ztp.chess;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import static pl.wipb.ztp.chess.Chessboard.ZEROX;
import static pl.wipb.ztp.chess.Chessboard.ZEROY;
import static pl.wipb.ztp.chess.Piece.TILESIZE;

public class Decorator implements InterfacePiece {
    protected InterfacePiece pionek;

    public Decorator(InterfacePiece pionek) {
        this.pionek = pionek;
    }

    @Override
    public void draw(Graphics2D graphics2d, int x, int y) {
        AffineTransform affineTransform = new AffineTransform();
        AffineTransform g_save = graphics2d.getTransform();
        affineTransform.translate(ZEROX, ZEROY);
        affineTransform.scale(TILESIZE, TILESIZE);
        graphics2d.transform(affineTransform);
        pionek.draw(graphics2d, x, y);
        graphics2d.setTransform(g_save);
    }

    /*
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
    */

    public InterfacePiece getDecorated() {
        return this.pionek;
    }
}
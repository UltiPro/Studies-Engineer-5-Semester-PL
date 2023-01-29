package pl.wipb.ztp.chess;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class PieceDraw extends Decorator {
    public PieceDraw(InterfacePiece piece) {
        super(piece);
    }

    @Override
    public void draw(Graphics2D graphics2d) {
        AffineTransform tmp = graphics2d.getTransform();
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(Chessboard.ZEROX, Chessboard.ZEROY);
        affineTransform.scale(Piece.TILESIZE, Piece.TILESIZE);
        graphics2d.transform(affineTransform);
        super.draw(graphics2d);
        graphics2d.setTransform(tmp);
    }
}
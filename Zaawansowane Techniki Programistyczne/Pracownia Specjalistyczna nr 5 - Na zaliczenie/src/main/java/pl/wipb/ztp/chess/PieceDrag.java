package pl.wipb.ztp.chess;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class PieceDrag extends Decorator {
    private double x, y;

    protected PieceDrag(InterfacePiece piece) {
        super(piece);
    }

    @Override
    public void draw(Graphics2D graphics2d) {
        AffineTransform affineTransform = graphics2d.getTransform();
        AffineTransform tmp = new AffineTransform();
        tmp.setToTranslation(x, y);
        graphics2d.transform(tmp);
        super.draw(graphics2d);
        graphics2d.setTransform(affineTransform);
    }

    public void dragPiece(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
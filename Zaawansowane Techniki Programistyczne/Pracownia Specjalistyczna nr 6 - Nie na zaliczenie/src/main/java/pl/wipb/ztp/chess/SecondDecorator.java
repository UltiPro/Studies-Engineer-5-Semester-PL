package pl.wipb.ztp.chess;

import java.awt.*;
import java.awt.geom.AffineTransform;

class SecondDecorator extends Decorator { // do przenoszenia potrzebny :D
    private AffineTransform transform;

    public SecondDecorator(InterfacePiece interfacePiece, AffineTransform affineTransform) {
        super(interfacePiece);
        this.transform = affineTransform;
    }

    public void draw(Graphics2D graphics2d, int x, int y) {
        AffineTransform tmp = graphics2d.getTransform();
        graphics2d.transform(this.transform);
        this.pionek.draw(graphics2d, x, y);
        graphics2d.setTransform(tmp);
    }
}
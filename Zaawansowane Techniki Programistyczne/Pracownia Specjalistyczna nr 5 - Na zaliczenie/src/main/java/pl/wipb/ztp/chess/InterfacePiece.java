package pl.wipb.ztp.chess;

import java.awt.*;

public interface InterfacePiece {
    void draw(Graphics2D graphics2d);

    int getX();

    int getY();

    void moveTo(int xx, int yy);

    InterfacePiece getDecorated();
}
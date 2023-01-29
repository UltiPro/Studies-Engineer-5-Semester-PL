package pl.wipb.ztp.chess;

import java.awt.Graphics2D;

public interface InterfacePiece {
    void draw(Graphics2D g, int x, int y);

    /*
    int getX();

    int getY();

    void moveTo(int xx, int yy);
     */

    InterfacePiece getDecorated();
}
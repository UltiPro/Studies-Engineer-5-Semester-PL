package pl.wipb.ztp.ps3;

public class SegmentBuilderExtended extends SegmentBuilder {
    public void createC() {
        Segment s = new SegmentBlock(x, y, "block3.png");
        plansza.add(s);
        x += TILESIZE;
    }
}
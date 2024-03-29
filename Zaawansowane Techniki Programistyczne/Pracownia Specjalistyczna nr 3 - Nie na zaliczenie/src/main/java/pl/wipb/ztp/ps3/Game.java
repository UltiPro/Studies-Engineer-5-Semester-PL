package pl.wipb.ztp.ps3;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import javax.swing.JPanel;

class Game extends JPanel {
    // private final int TILESIZE = 32;
    private final List<Segment> plansza;
    private final Sprite sprite;
    private Builder builder;

    private List<Segment> stworzPlansze(String plik, Builder segmentBuilder) {
        BufferedReader br = null;
        try {
            InputStream pFile = getClass().getResourceAsStream(plik);
            br = new BufferedReader(new InputStreamReader(pFile));
            // List<Segment> plansza = new ArrayList<>();
            String linia;
            // int x;
            // int y = 4;
            int liczba;
            int znaki;
            char znak;
            char cyfra1;
            char cyfra2;
            while ((linia = br.readLine()) != null) {
                builder.setX(4);
                znaki = 0;
                while ((linia.length() - znaki) >= 3) {
                    znak = linia.charAt(znaki++);
                    cyfra1 = linia.charAt(znaki++);
                    cyfra2 = linia.charAt(znaki++);
                    liczba = (cyfra1 - '0') * 10 + (cyfra2 - '0');
                    switch (znak) {
                        case 'X':
                            builder.createX(liczba);
                            break;
                        case 'A':
                            for (int i = 0; i < liczba; ++i) {
                                builder.createA();
                            }
                            break;
                        case 'B':
                            for (int i = 0; i < liczba; ++i) {
                                builder.createB();
                            }
                            break;
                        case 'C':
                            for (int i = 0; i < liczba; ++i) {
                                builder.createC();
                            }
                            break;
                        case 'G':
                            for (int i = 0; i < liczba; ++i) {
                                builder.createG();
                            }
                            break;
                    }
                }
                // y += TILESIZE;
                builder.setY(builder.getY() + builder.getTILESIZE());
            }
            br.close();
            return plansza;
        } catch (IOException e) {
            System.out.println("Blad wczytania planszy");
            e.printStackTrace();
            return null;
        }
    }

    public Game(String plik) {
        setPreferredSize(new Dimension(424, 268));
        setFocusable(true);

        builder = new SegmentBuilderExtended();
        stworzPlansze(plik, builder);
        plansza = builder.getPlansza();
        sprite = new Sprite(plansza, "mario.png");

        // plansza = stworzPlansze(plik);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev) {
                switch (ev.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_RIGHT:
                        sprite.stop();
                        break;
                }
            }

            @Override
            public void keyPressed(KeyEvent ev) {
                switch (ev.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        sprite.left();
                        break;
                    case KeyEvent.VK_RIGHT:
                        sprite.right();
                        break;
                    case KeyEvent.VK_SPACE:
                    case KeyEvent.VK_UP:
                        sprite.jump();
                        break;
                }
            }
        });
        new Thread(new SpriteController(sprite, plansza, this)).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Segment s : plansza) {
            s.draw(g);
        }
        sprite.draw(g);
    }
}
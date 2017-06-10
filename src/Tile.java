import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile extends GameObject
{
    public Tile(int x, int y, ID id, BufferedImage sprite)
    {
        super(x, y, id);

        tileSprite = sprite;
    }

    public BufferedImage tileSprite;

    public void tick()
    {

    }

    public void render(Graphics g)
    {
        g.drawImage(tileSprite, x, y, 96, 96, null);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
import bagel.Image;
import bagel.util.Rectangle;

public class Wall extends Entity {

    public Wall(int x, int y, Rectangle hitbox){
        super(x,y,hitbox);
    }
    public void Draw(Image image)
    {
        image.drawFromTopLeft(x,y);
    }
}

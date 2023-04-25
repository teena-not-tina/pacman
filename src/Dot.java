import bagel.Image;
import bagel.util.Rectangle;

public class Dot extends Entity {
    public Dot(int x, int y, Rectangle hitbox){
        super(x,y,hitbox);
    }
    public void Draw(Image image)
    {
        image.drawFromTopLeft(x,y);
    }
    boolean eaten = false;
    //a boolean, to check if it has already been eaten
}

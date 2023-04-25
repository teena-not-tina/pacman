import bagel.Image;
import bagel.util.Rectangle;

public class Ghost extends Entity {

    public Ghost(int x, int y, Rectangle hitbox){
        super(x,y,hitbox);
    }
    //function to draw ghost
    public void Draw(Image image)
    {
        image.drawFromTopLeft(x,y);
    }
}

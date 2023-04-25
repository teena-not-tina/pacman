import bagel.Image;
import bagel.util.Rectangle;

public class Player extends Entity {
    public Player(int x, int y, Rectangle hitbox){
        super(x,y,hitbox);
    }
    public String direction = "Right";
    public void Draw(Image image)
    {
        image.drawFromTopLeft(x,y);
    }
    public Integer heart = 3;
    public Integer score = 0;
    public Integer frame = 0;
}

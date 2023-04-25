import bagel.util.Rectangle;

public class Entity {
    //Store x and y position of stuff
    int x;
    int y;
    Rectangle hitbox;
    public Entity(int x, int y, Rectangle hitbox) {
        this.x = x;
        this.y = y;
        this.hitbox = hitbox;
    }

    //store collision rectangles of stuff <- to check if u bumped into a ghost or wall
    //wall
    //ghost
    //dots
    //pacman
}

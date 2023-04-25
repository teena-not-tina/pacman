import bagel.*;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import bagel.util.Point;
import bagel.util.Rectangle;


/**
 * Skeleton Code for SWEN20003 Project 1, Semester 1, 2023
 *
 * Please enter your name below
 * @author: Taeeun Kim
 * Student ID: 1351062
 */
public class ShadowPac extends AbstractGame  {
    private final static int WINDOW_WIDTH = 1024;
    private final static int WINDOW_HEIGHT = 768;
    private final static String GAME_TITLE = "SHADOW PAC";
    private final Image BACKGROUND_IMAGE = new Image("../res/background0.png");
    private final Image ghostImage = new Image("../res/ghostRed.png");
    private final Image wallImage = new Image("../res/wall.png");
    private final Image dotImage = new Image("../res/dot.png");
    private final Image pacClosed = new Image("../res/pac.png");
    private final Image pacOpen = new Image("../res/pacOpen.png");
    // we will use arrays here so it is easy to read the csv file and add the elements
    List<Dot> dots = new ArrayList<>();
    List<Ghost> ghosts = new ArrayList<>();
    List<Wall> walls = new ArrayList<>();
    List<Player> players = new ArrayList<>();
    String state = "Start";

    public ShadowPac(){
        super(WINDOW_WIDTH, WINDOW_HEIGHT, GAME_TITLE);
    }

    /**
     * Method used to read file and create objects (you can change
     * this method as you wish).
     */
    public void CSVReader () {
        try {
            File file = new File("../res/level0.csv");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                String type = values[0];
                int x = Integer.parseInt(values[1]);
                int y = Integer.parseInt(values[2]);
                switch (type) {
                    // have an type array of the types. We will store info of each type in this array.
                    case "Ghost":
                        Ghost ghost = new Ghost(x, y, new Rectangle(x,y,25,25));
                        ghosts.add(ghost);
                        break;

                    case "Wall":
                        Wall wall = new Wall(x, y, new Rectangle(x,y,50,50));
                        walls.add(wall);
                        break;

                    case "Dot":
                        Dot dot = new Dot(x, y, new Rectangle(x, y, 26, 26));
                        dots.add(dot);
                        break;

                    case "Player":
                        Player player = new Player(x, y,new Rectangle(x, y, 25, 25));
                        players.add(player);
                        break;
                }
            }



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * The entry point for the program.
     */
    public static void main(String[] args) {
        ShadowPac game = new ShadowPac();
        game.CSVReader();
        game.run();
    }

    /**
     * Performs a state update.
     * Allows the game to exit when the escape key is pressed.
     */
    @Override
    protected void update(Input input) {
        // need to add:
        // state of the game winning or losing ?
        // direction of the pacman
        // frames of the pacman
        // score, heart
        // and more...
        Font font = new Font("../res/FSO8BITR.TTF", 64);
        if (input.wasPressed(Keys.ESCAPE)){
            Window.close();
        }
        // just the start screen
        BACKGROUND_IMAGE.draw(Window.getWidth()/2.0, Window.getHeight()/2.0);
        if(state.equals("Start")) {
            font.drawString("SHADOW PAC", 260, 250);
            font = new Font("../res/FSO8BITR.TTF", 24);
            font.drawString("PRESS SPACE TO START\nUSE ARROW KEYS TO MOVE", 260 + 60, 250 + 190);

        }

        // start page to game in progress
        if (input.wasPressed(Keys.SPACE) && state.equals("Start")){
            state = "In progress";
        }

        if (state.equals("In progress")) {
            // need to code: how do we know if it is from in progress to game over? or in progress to game won?
            // we only want one keyboard input at once. no moving diagonally.
            // need to code: change direction of the pacman.
            boolean checkMoving = false;

            // wall, dot, ghost classes are added.
            for (Wall wall:walls) {
                wall.Draw(wallImage);
            }
            for (Dot dot:dots) {
                if (dot.eaten == false) {
                    dot.Draw(dotImage);
                }

            }
            for (Ghost ghost:ghosts) {
                ghost.Draw(ghostImage);
            }


        }


    }

    // I need to know if the pacman is touching the dot or the wall or the ghost!
}
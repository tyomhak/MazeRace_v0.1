//import game.*;
import maze.*;

import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void main(final String[] args)
    {
        Board maze = new Board(20, 20);

        JFrame obj = new JFrame();
        obj.setSize(768 + 15, 768 + 40);
//        obj.setBounds(0, 0, windowWidth, windowHeight);
        obj.setBackground(Color.GRAY);
        obj.setResizable(true);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(maze);

        Wyrm modified_maze = new Wyrm(maze);
        modified_maze.create_maze(50);
        maze.print();
        maze.update();

    }
};
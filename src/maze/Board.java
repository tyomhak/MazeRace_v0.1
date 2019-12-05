package maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Set;
import java.util.Stack;


import javax.swing.JPanel;

import additional.Cell_Status;
import additional.Location;

import game.State;
import game.Action;
import game.game_additional.Item;
import game.player.Player;

public class Board extends JPanel implements State
{
    Cell[][] maze;

    int mazeWidth;
    int mazeHeight;

    int winWidth = 768;
    int winHeight = 768;
    public int cellSize;
    ArrayList<Player> players;
    ArrayList<Item> items;

    private static final long serialVersionUID = 1L;



    public Board(int width, int height)
    {
        maze = new Cell[width][height];
        mazeWidth = width;
        mazeHeight = height;
        players = new ArrayList<Player>();
        items = new ArrayList<Item>();

        cellSize = Math.min(winWidth / maze.length, winHeight/ maze[0].length);

        // initializing the board with null and nothings
        for(int i = 0; i < maze.length; i++)
        {
            for(int j = 0; j< maze[i].length; j++)
            {
                maze[i][j] = new Cell(null);
            }
        }
    }

    public Set<Action> getApplicableActions(Location location)
    {
        //Set<Action> actions = new LinkedHashSet<Action>();
        // to be implemented . . .

//        if(location.get_row() > 0)
//        {
//            Location left = new Location(location.get_row(), location.get_column() - 1);
//            if(maze[left.get_row()][left.get_column()].status == Cell_Status.PATH ||
//                    maze[left.get_row()][left.get_column()].status == Cell_Status.ROOM)
//            {
//                actions.add()
//            }
//        }


        return null;
    }

    public State getActionResult(Action action)
    {
        // to be implemented . . .
        return null;
    }

    public void print()
    {
        for(int i = 0; i < maze.length; i++)
        {
            for(int j = 0; j< maze[i].length; j++)
            {
                System.out.print(maze[i][j].status.value + "  ");
            }
            System.out.println();
        }
    }

    public void drawMaze(Graphics g)
    {
        g.setColor(Color.ORANGE);
        for(int i = 0; i < maze.length; ++i)
        {
            for(int j = 0; j < maze[0].length; ++j)
            {
                if(maze[i][j].status == Cell_Status.PATH)
                {
                    g.setColor(Color.white);
                }
                else if(maze[i][j].status == Cell_Status.WALL)
                {
                    g.setColor(Color.GRAY);
                }
                else if(maze[i][j].status == Cell_Status.ROOM)
                {
                    g.setColor(Color.ORANGE);
                }
                else
                {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }

        }

        Toolkit.getDefaultToolkit().sync();
    }

    public void update() {
        repaint();
    }
    public void paintComponent(Graphics g) {
//        g.setColor(Color.white);
//        g.drawRect(0, 0, winWidth, winHeight);
//
//        g.setColor(Color.LIGHT_GRAY);
//        g.fillRect(0, 0, winWidth, winHeight);

        drawMaze(g);

        for(int i = 0; i < players.size(); ++i)
        {
            players.get(i).draw(g, this);
        }

        for(int i = 0; i < items.size(); ++i)
        {
            items.get(i).draw(g, this);
        }
    }

    public Cell[][] get_maze()
    {
        return maze;
    }

    public void addPlayer(Player p)
    {
        players.add(p);
    }

    public void addItem(Item i)
    {
        items.add(i);
    }
}
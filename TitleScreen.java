import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    private int counter;
    
    public TitleScreen()
    {    
        super(600, 400, 1);
        Greenfoot.start();
        this.setBackground("Invade Escape TS.jpg");
    }

    
    public void act()
    {
        if (Greenfoot.isKeyDown("enter")) 
        {
            Greenfoot.setWorld(new Level2());
    }
}
}


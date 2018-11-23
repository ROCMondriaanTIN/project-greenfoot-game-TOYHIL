import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Doors here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Doors extends Actor
{
    /**
     * Act - do whatever the Doors wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Door door = new Door();
        Key key = new Key(door);
        
        private Door door;
        
        public Key(Door linkedDoor)
        {
            door = linkedDoor;
    }    
    
    Key key = (Key)getOneIntersectingObject(Key.class);
    if (key != null) key.encountered();
    
    public void encountered()
    {
        door.open();
        getWorld().removeObject(this);
}

private boolean opened;

public void open()
{
    opened = true;
}

public boolean isOpened()
{
    return opened;
}

Door door = (Door)getOneIntersectingObject(Door.class);
if (door != null && door.isOpened()) nextLevel();
}
}

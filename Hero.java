import greenfoot.*;
import java.util.List;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    private GreenfootImage run1 = new GreenfootImage("p1_walk01 L.png");
    private GreenfootImage run2 = new GreenfootImage("p1_walk02 L.png");
    private GreenfootImage run3 = new GreenfootImage("p1_walk03 L.png");
    private GreenfootImage run4 = new GreenfootImage("p1_walk04 L.png");
    private GreenfootImage run5 = new GreenfootImage("p1_walk05 L.png");
    private GreenfootImage run6 = new GreenfootImage("p1_walk06 L.png");
    private GreenfootImage run7 = new GreenfootImage("p1_walk07 L.png");
    private GreenfootImage run8 = new GreenfootImage("p1_walk08 L.png");
    private GreenfootImage run9 = new GreenfootImage("p1_walk09 L.png");
    private GreenfootImage run10 = new GreenfootImage("p1_walk10 L.png");
    private GreenfootImage run11 = new GreenfootImage("p1_walk11 L.png");
    private GreenfootImage run12 = new GreenfootImage("p1_walk01.png");
    private GreenfootImage run13 = new GreenfootImage("p1_walk02.png");
    private GreenfootImage run14 = new GreenfootImage("p1_walk03.png");
    private GreenfootImage run15 = new GreenfootImage("p1_walk04.png");
    private GreenfootImage run16 = new GreenfootImage("p1_walk05.png");
    private GreenfootImage run17 = new GreenfootImage("p1_walk06.png");
    private GreenfootImage run18 = new GreenfootImage("p1_walk07.png");
    private GreenfootImage run19 = new GreenfootImage("p1_walk08.png");
    private GreenfootImage run20 = new GreenfootImage("p1_walk09.png");
    private GreenfootImage run21 = new GreenfootImage("p1_walk10.png");
    private GreenfootImage run22 = new GreenfootImage("p1_walk11.png");
    
    
    private int frame = 1;
    private int speed = 3;
    private boolean onGround;
    private int levens = 5;
    private int spawnX;
    private int spawnY;
    private CollisionEngine collisionEngine;
    private TileEngine tileEngine;
    

    public Hero(CollisionEngine collisionEngine, TileEngine tileEngine) {
        super();
        this.collisionEngine = collisionEngine;
        this.tileEngine = tileEngine;
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1_front.png");
    }

    @Override
    public void act() {
        handleInput();
        
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        handleInput();

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                break;
            }
        }
        
        List <Tile> tiles = collisionEngine.getCollidingTiles(this, true);

        for (Tile tile : tiles) {
            if (tile != null) {
                if (tile.type == TileType.LIQUID) {
                    getWorld().removeObject(this);
                    return;
                } else if (tile.type == TileType.KEYGREEN) {
                    // Op deze manier kan je nu tiles verwijderen
                    // Zie ook de andere removeTile methodes die zijn toegevoegd
                    tileEngine.removeTile(tile);
                    return;
                }
                
                else if (tile.type == TileType.KEYBLUE) {
                    tileEngine.removeTile(tile);
                    return;
                }
                else if (tile.type == TileType.GEMBLUE) {
                    tileEngine.removeTile(tile);
                    return;
                }
            }
        }
    }

         boolean onGround(){
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Tile.class);
        return under != null;
        }
        
        public void handleInput() { 
        if (Greenfoot.isKeyDown("w") && (onGround() == true)) {
            velocityY = -15;
            setImage("p1_jump.png");
        }

        else if (Greenfoot.isKeyDown("a")) {
            velocityX = -10;
            animatieLeft();
        } 
        if (Greenfoot.isKeyDown("d")) {
            velocityX = 10;
            animatieRight();
        }
        
    }
    
    
    

    

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
    
    
    
    public void animatieRight() {
        if(frame == 1)
        {
            setImage(run12);
        }
        else if (frame == 2)
        {
            setImage(run13);
        }
        else if (frame == 3)
        {
            setImage(run14);
        }
        else if (frame == 4)
        {
            setImage(run15);
        }
        else if (frame == 5)
        {
            setImage(run16);
        }
        else if (frame == 6)
        {
            setImage(run17);
        }
        else if (frame == 7)
        {
            setImage(run18);
        }
        else if (frame == 8)
        {
            setImage(run19);
        }
        else if (frame == 9)
        {
            setImage(run20);
        }
        else if (frame == 10)
        {
            setImage (run21);
            frame = 0;
            return;
        }
        frame ++;
        
        
        
        
       }
       
           public void animatieLeft() {
        if(frame == 1)
        {
            setImage(run1);
        }
        else if (frame == 2)
        {
            setImage(run2);
        }
        else if (frame == 3)
        {
            setImage(run3);
        }
        else if (frame == 4)
        {
            setImage(run4);
        }
        else if (frame == 5)
        {
            setImage(run5);
        }
        else if (frame == 6)
        {
            setImage(run6);
        }
        else if (frame == 7)
        {
            setImage(run7);
        }
        else if (frame == 8)
        {
            setImage(run8);
        }
        else if (frame == 9)
        {
            setImage(run9);
        }
        else if (frame == 10)
        {
            setImage (run10);
            frame = 0;
            return;
        }
        frame ++;
       }
       
       public void dood() {
           levens --;
           if (levens > 0) {
               setLocation(spawnX, spawnY);
            } else {
                getWorld().removeObject(this);
            }
   }
}

        
        

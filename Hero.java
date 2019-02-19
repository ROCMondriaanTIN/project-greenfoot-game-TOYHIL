
import greenfoot.*;
import java.util.*;

/**
*
* @author R. Springer
*/
public class Hero extends Mover {

private final double gravity;
private final double acc;
private final double drag;

private int frame = 1;
private int speed = 3;
private boolean onGround;
public  int leven = 3;
private int spawnX;
private int spawnY;
private CollisionEngine collisionEngine;
private TileEngine tileEngine;
private boolean isTouching;
private int lockpick = 0;
private int lockpick_total = 0;
private int score = 0;
private int status = 0;
public int levens = 3;
public String worldName="";
int Gem= 0;
public boolean eatKeys;
boolean key = false;
public boolean starAdded = false;
public boolean keyBlueAdded = false;
public boolean keyGreenAdded = false;
public boolean keyRedAdded = false;
public boolean gemAdded = false;

private int setPlaynumber = 1;
private int walkL = -10;
private int walkR = 10;
private int springNumy;

private boolean toLevel2;
int star = 0;

private ArrayList<GreenfootImage> animatieP1;
private ArrayList<GreenfootImage> animatieP2;
private ArrayList<GreenfootImage> animatieP3;
private ArrayList<GreenfootImage> currentAnimation;

public Hero(CollisionEngine collisionEngine, TileEngine tileEngine) {
    super();
    this.collisionEngine = collisionEngine;
    this.tileEngine = tileEngine;
    gravity = 9.8;
    acc = 0.6;
    drag = 0.8;
    this.worldName = worldName;
    setImage("p1_front.png");
    animatieP1 = new ArrayList<GreenfootImage>();
    animatieP2 = new ArrayList<GreenfootImage>();
    animatieP3 = new ArrayList<GreenfootImage>();
    for(int i = 1; i <= 11; i++) {
        String imageStart = "p1_walk0";
        // als i > 9 dan grbruik je p1_walk i.p.v. p1_walk0;
        animatieP1.add(new GreenfootImage(imageStart + i + ".png"));
        animatieP2.add(new GreenfootImage(imageStart + i + ".png"));
        animatieP3.add(new GreenfootImage(imageStart + i + ".png"));
    }
    // verander current animatie naar de nieuw character zodra je deze oppakt.
    currentAnimation = animatieP1;
    
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
    toLevel2();

  
    
   

    for (Actor enemy : getIntersectingObjects(Enemy.class)) {
        if (enemy != null) {
            setLocation(300,200);
            setPlaynumber = 1;
            break;
        }
    }
    List <Tile> tiles = collisionEngine.getCollidingTiles(this, true);
    for (Tile tile : getIntersectingObjects(Tile.class)) {

        if (tile != null) {

            if(tile.getImage().toString().contains("hud_p1Alt")){
             setPlaynumber = 1;
            // getWorld().removeObject(tile);
             break;
     }else if(tile.getImage().toString().contains("hud_p2Alt")){
             setPlaynumber = 2;
            // getWorld().removeObject(tile);
             break;
     }else if(tile.getImage().toString().contains("hud_p3Alt")){
             setPlaynumber = 3;
            // getWorld().removeObject(tile);
             break;
            }
             else if (tile.type == TileType.LIQUID) {
                setLocation(300,200);
                setPlaynumber = 1;
                return;
            }else if (tile.type == TileType.SPIKES) {
                setLocation(300,200);
                setPlaynumber = 1;

            if (tile.type == TileType.LIQUID) {
                setLocation(50,400);
                return;
            } if (tile.type == TileType.SPIKES) {
                setLocation(50,400);
                return;
            } else  if (tile.type == TileType.GEMBLUE) {
                        tileEngine.removeTile(tile);
                        this.gemAdded = true;
                        return;
                    } else  if (tile.type == TileType.STAR) {
                        this.starAdded = true;
                        tileEngine.removeTile(tile);
                        return;
                    }
                    if (tile.type == TileType.KEYRED) {
                        tileEngine.removeTile(tile);
                        for(Door door : getWorld().getObjects(Door.class) ) {
                            if(door.type == TileType.REDLOCK) {
                                tileEngine.removeTile(door);
                            }
                            
                        }
                    }

                }
            
                
            if(Greenfoot.isKeyDown("e")) {
               if (tile.type == TileType.KEYGREEN) {
                   tileEngine.removeTile(tile);
                  this.keyGreenAdded = true;
                   for(Door door : getWorld().getObjects(Door.class) ) {
                       if(door.type == TileType.GREENLOCK) {
                           tileEngine.removeTile(door);
                        }
                        
                    }
                }
                 if (tile.type == TileType.KEYBLUE) {
                tileEngine.removeTile(tile);
                this.keyBlueAdded = true;
                   for(Door door : getWorld().getObjects(Door.class) ) {
                       if(door.type == TileType.BLUELOCK) {
                           tileEngine.removeTile(door);
                        }
                        
                    }
                 
                }
                if (tile.type == TileType.KEYRED) {
                        tileEngine.removeTile(tile);
                        this.keyRedAdded = true;
                        for(Door door : getWorld().getObjects(Door.class) ) {
                            if(door.type == TileType.REDLOCK) {
                                tileEngine.removeTile(door);
                            }
                            
                        }
                    }

            }
            
        }
    }
}



    public void isTouching()
    {
        if(isTouching (spikesTile.class))
        {

            setLocation(300 , 200);
            setPlaynumber = 1;

            setLocation(127, 1393);
        }
        if(isTouching (Star.class)) {
        star++;
    }
    if (isTouching (spikesTile.class) || (isTouching (Water.class))) {
        levens--;
        setLocation(127, 1393);
        return;
    }
       
    }
    
    
    





   boolean onGround(){
    Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Tile.class);
    return under != null;
    }
    
   public void handleInput() { 
       if(setPlaynumber == 1){
           getImage().scale(82, 97);
           springNumy = -14;
           walkL = -10;
           walkR = 10;
        }else if(setPlaynumber == 2){
            getImage().scale(82, 120);
            springNumy = -17;
            walkL = -10;
            walkR = 10;
        }else if(setPlaynumber == 3){
            getImage().scale(56, 64);
            springNumy = -11;
            walkL = -7;
            walkR = 7;
        }
    if (Greenfoot.isKeyDown("w") && (onGround() == true)) {
        velocityY = -15;
        setImage("p1_jump.png");
    }

    else if (Greenfoot.isKeyDown("a")) {
        velocityX = -5;
        animatie();
        // Gebruik een private boolean om aan te geven of hij naar links of recht kijkt
        // Flip als hij nog niet naar links kijkt
    } 
    if (Greenfoot.isKeyDown("d")) {
        velocityX = 5;
        animatie();
        // Flip als hij nog niet naar rechts kijkt
    }
    if (Greenfoot.isKeyDown("Control") && (Greenfoot.isKeyDown("r"))) {

        Greenfoot.setWorld(new Level2());
        setPlaynumber = 1;

        Greenfoot.setWorld(new Level2());

    }

}






public int getWidth() {
    return getImage().getWidth();
}

public int getHeight() {
    return getImage().getHeight();
}



    
public void toLevel2() {
    if(isTouching (Window.class)) {
       if (getWorld() instanceof TitleScreen) Greenfoot.setWorld(new Level2());
        if (getWorld() instanceof Level2) Greenfoot.setWorld(new Level3());
        if (getWorld() instanceof Level3) Greenfoot.setWorld(new Level4());
}
}

    


    public void flip() { 
        // for elke element 
            // haal huidige image op met .get(i)
            // Voer hier de .mirrorHorizontally() methode op uit
            
    }

    public void animatie() {
        frame++;
        if(frame >= 11) frame = 0;
        setImage(currentAnimation.get(frame));
   }
   
       
       
       public void dood() {
           leven --;
           if (leven > 0) {
               setLocation(127, 1393);
            } else {
                getWorld().removeObject(this);
            }
   }



     }
     

        
        

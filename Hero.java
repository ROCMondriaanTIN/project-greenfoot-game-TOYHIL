
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
    
    public Hero(CollisionEngine collisionEngine, TileEngine tileEngine) {
        super();
        this.collisionEngine = collisionEngine;
        this.tileEngine = tileEngine;
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        this.worldName = worldName;
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
        gem();
        

      
        
       

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
    
    

        public void isTouching()
        {
            if(isTouching (spikesTile.class))
            {
                setLocation(300 , 200);
                setPlaynumber = 1;
            }
            return;
        }
        
        public int levens() {
             if(leven==0)
            {
            if(worldName=="MyWorld")
            {
            Greenfoot.setWorld(new MyWorld());
}
            
        }
        return levens;
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
            animatieLeft();
        } 
        if (Greenfoot.isKeyDown("d")) {
            velocityX = 5;
            animatieRight();
        }
        if (Greenfoot.isKeyDown("Control") && (Greenfoot.isKeyDown("r"))) {
            Greenfoot.setWorld(new MyWorld());
            setPlaynumber = 1;
        }

}
    
    
    

    

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
    
    public void updateScoremunt()
    {
        score ++;
        }
        
        public void gem()
        
        {
            if(isTouching(Gem.class))
            
            {
                
                removeTouching(Gem.class);
                Gem++;
}
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
           leven --;
           if (leven > 0) {
               setLocation(300, 200);
            } else {
                getWorld().removeObject(this);
            }
   }

     }
     

        
        

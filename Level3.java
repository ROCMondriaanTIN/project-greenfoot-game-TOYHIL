import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author R. Springer
 */
public class Level3 extends World {

    private CollisionEngine ce;
    private int score = 0;
    private TileEngine te;
    public static boolean hud_heartFull = false;
    public Hero hero;
    public static int starX = 100;
    public static int keyBlueX = 150;
    public static int keyGreenX = 150;
    public static int keyRedX = 150;

    /** 
     * Constructor for objects of class MyWorld.
     *
     */
    public Level3() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 960, 1, false);
        this.setBackground("bg.png");

         int[][] map = {
             {96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96},
{96,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,185,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96},
{96,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96},
{96,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,116,161,96},
{96,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72,72,72,72,72,72,72,72,72,72,72,96},
{96,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72,72,55,55,55,55,55,55,55,55,55,55,55,96},
{96,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72,72,72,72,-1,-1,-1,-1,-1,72,72,72,72,72,72,72,72,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96},
{96,203,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72,72,72,72,72,55,55,55,55,-1,-1,-1,-1,-1,55,55,55,55,55,55,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96},
{96,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72,72,72,55,55,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96},
{96,-1,-1,-1,92,72,72,72,72,72,72,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,224,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96},
{96,-1,-1,-1,94,55,55,55,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96},
{96,-1,-1,-1,94,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96},
{96,-1,-1,-1,94,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96},
{96,-1,-1,-1,94,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96},
{96,-1,-1,-1,94,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96},
{96,-1,-1,-1,94,72,72,72,221,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96},
{96,96,96,96,96,55,55,55,72,72,72,72,221,221,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96},
{96,-1,-1,-1,-1,-1,-1,-1,55,55,55,55,72,72,72,72,72,72,72,72,221,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96},
{96,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,55,55,55,55,55,55,55,55,72,72,221,221,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96},
{96,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,55,55,72,72,72,221,221,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{96,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,55,55,55,72,72,72,72,72,221,221,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{96,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,55,55,55,55,55,72,72,72,221,221,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{96,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,55,55,55,72,72,72,72,72,72,221,221,-1,-1,-1,-1,-1,-1,87,87,87},
{96,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,55,55,55,55,55,55,55,72,72,72,72,72,72,72,72,87,-1,79},
{96,72,72,72,72,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,55,55,55,55,55,55,55,55,55,87,-1,78},
{96,55,55,55,55,-1,72,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,86,-1,-1,78},
{96,55,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,86,-1,-1,78},
{96,55,55,55,55,-1,-1,224,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72,72,72,72,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,86,-1,-1,78},
{96,55,55,55,55,-1,-1,-1,72,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,221,72,55,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,86,-1,-1,78},
{96,55,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72,72,-1,55,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,86,-1,-1,78},
{55,55,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72,-1,-1,-1,-1,55,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,86,-1,-1,78},
{55,55,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72,-1,-1,-1,-1,-1,55,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72,72,72,72},
{55,55,55,55,55,-1,-1,-1,-1,-1,-1,207,-1,-1,-1,-1,72,-1,-1,-1,-1,-1,-1,55,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72,55,55,55,55},
{55,55,55,55,55,84,84,84,84,84,84,84,72,72,72,72,84,84,84,84,84,84,84,55,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72,55,55,55,55,55},
{55,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,-1,-1,-1,-1,-1,208,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72,55,55,55,55,55,55},
{55,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72,55,55,55,55,55,55,55},
{55,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72,72,72,55,55,55,55,55,55,55,55},
{55,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,62,-1,224,55,55,55,55,55,55,55,55,55,55,55},
{55,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,-1,-1,-1,-1,-1,-1,62,-1,-1,-1,-1,-1,55,55,55,55,55,55,55,55,55,55,55},
{55,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,55,55,55,55,55,55,55,55,55,55,55},
{55,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,55,55,55,55,55,55,55,55,55,55,55},
{55,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,-1,-1,-1,-1,221,221,221,221,-1,-1,-1,-1,55,55,55,55,55,55,55,55,55,55,55},
{55,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,84,84,84,84,55,55,55,55,84,84,84,84,55,55,55,55,55,55,55,55,55,55,55},
{55,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,55,55,55,55,83,83,83,83,55,55,55,55,55,55,55,55,55,55,55},
{55,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,55,55,55,55,83,83,83,83,55,55,55,55,55,55,55,55,55,55,55},
{55,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,55,55,55,55,83,83,83,83,55,55,55,55,55,55,55,55,55,55,55},
{55,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,55,55,55,55,83,83,83,83,55,55,55,55,55,55,55,55,55,55,55},
{55,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,55,55,55,55,83,83,83,83,55,55,55,55,55,55,55,55,55,55,55},
{55,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,83,83,83,55,55,55,55,83,83,83,83,55,55,55,55,83,83,83,83,55,55,55,55,55,55,55,55,55,55,96},
{96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,55,55,55,96},

            







   
            
        };

        // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
        TileEngine te = new TileEngine(this, 60, 60, map);
        te.setTileFactory(new TileFactory());
        te.setMap(map);
        // Declarenre en initialiseren van de camera klasse met de TileEngine klasse 
        // zodat de camera weet welke tiles allemaal moeten meebewegen met de camera
        Camera camera = new Camera(te);
        // Declareren en initialiseren van een main karakter van het spel mijne heet Hero. Deze klasse 
        // moet de klasse Mover extenden voor de camera om te werken
        ce = new CollisionEngine(te, camera);
        
        
       hero = new Hero(ce, te);
        
        ce.addCollidingMover(hero);

        // Laat de camera een object volgen. Die moet een Mover instatie zijn of een extentie hiervan.
        camera.follow(hero);

        // Alle objecten toevoegen aan de wereld: camera, main karakter en mogelijke enemies
        addObject(camera, 0, 0);
        addObject(hero, 300, 200);
        addObject(new Enemy(), 1602, 1000);
        addObject(new Heart (), 50, 100);
        
        
        // Force act zodat de camera op de juist plek staat.
        camera.act();
        hero.act();
        

        
    }

    @Override
    public void act() {
        ce.update();
        if (hero.starAdded == true)
        {
            addObject(new CoinHUD(), starX, 100);
            
            starX += 30;
            hero.starAdded = false;
        }
        //if (hud_heartFull == false)
        // { Greenfoot.setWorld(new MyWorld(500));
        //   
        //}
        
        if (hero.gemAdded == true)
        {
            addObject(new gemBlue(), 50, 175);
        }
       if (hero.keyBlueAdded == true)
        {
            addObject(new KeyBlue(), 50, 50);
           
        }
 if (hero.keyGreenAdded == true)
{
    
    addObject(new KeyGreen(), 50, 75);
    
}
  if (hero.keyRedAdded == true)
{
    addObject(new KeyRed(), 50, 100);
    
}

    }
    public  void keys() {
        if (hero.starAdded == true)
        {
            hero.starAdded = false;
            addObject(new CoinHUD(), 40, 40);
            return;
        }
        
        if (hero.keyBlueAdded == true)
{
    hero.keyBlueAdded = false;
    addObject(new KeyBlue(), 50, 50);
    
    return;
}
 if (hero.keyGreenAdded == true)
{
    hero.keyGreenAdded = false;
    addObject(new KeyGreen(), 50, 75);
    
    return;
}
  if (hero.keyRedAdded == true)
{
    hero.keyRedAdded = false;
    addObject(new KeyRed(), 50, 100);
    
    return;
}
if(hero.gemAdded == true)
{
    hero.gemAdded = false;
    addObject(new gemBlue(), 50, 175);
    
    return;

}
} 
}



    



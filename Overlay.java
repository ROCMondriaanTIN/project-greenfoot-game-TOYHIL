import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Actor;
/**
 * Write a description of class Overlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Overlay extends Actor
{
    private OverlayObject gemBlue = new OverlayObject("hud_gem_blue.png", 47, 47);
    private int starCount;
    OverlayObject keyBlue = new OverlayObject("hud_keyBlue", 60, 60);
    OverlayObject keyGreen = new OverlayObject("hud_keyGreen", 60, 60);
    public Overlay() 
    {
      
    
}
    public void addButtons() {
    getWorld().addObject(gemBlue, 947, 33);
   }

    public void addKey (String color) {
    switch (color) {
        case "Blue":
        getWorld().addObject(keyBlue, 30, 28);
        break;
        case  "Green":
        getWorld().addObject(keyGreen, 90, 28);
        break;
    }
   }

    public void addStar() {
        starCount ++;
        getWorld().addObject(new OverlayObject("star", 100, 100), 400 + 50 * starCount, 30);
    }


   /* public void updateHeroState(int heroState) {
    heroIcon.setOverlayObjectImage("hud_heartFull" + heroState);
  } 

    public void updateGemBlue() {
    gemBlue.setImage(Main.newTextImage("x" + LevelStatistics.getInstance().gems, 60));
   }*/
} 


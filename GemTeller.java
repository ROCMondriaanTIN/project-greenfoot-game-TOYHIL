import greenfoot.*;
import java.util.*;
  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GemTeller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GemTeller extends Mover
{
   
    public void act() 
    {
            List<Hero>myHeroList=this.getWorld().getObjects(Hero.class); 
            Hero myHero=myHeroList.get(0);
            myHero.gem();
            getWorld().showText("Gems:",100,80);
        }    
}
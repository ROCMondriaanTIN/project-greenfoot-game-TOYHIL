import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class LevensIcoon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevensIcon extends Mover
{
    
    public void act() {
        List <Hero> heroList = this.getWorld().getObjects(Hero.class);
        Hero myHero = heroList.get(0);
        int leven = myHero.levens();
        getWorld().showText("Levens:"+myHero.levens(), 110,120);
    }
}
    
   
        



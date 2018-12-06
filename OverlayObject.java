import greenfoot.Actor;
import greenfoot.GreenfootImage;

/**
 * author 302147728
 *
 */

public class OverlayObject extends Actor {
    public OverlayObject (String image, int width, int height) {
        setImage("HUD\\" + image + ".png");
        getImage().scale(width, height);
    }

    public OverlayObject (GreenfootImage image) {
        setImage(image);
    }

    public void setOverlayObjectImage(String Image) {
        this.setImage("HUD//" + Image + ".png");
    }
}
import java.awt.Color;

/**
 * An image filter to give an image a green tint.
 * 
 * @author Michael Biondi
 * @version 1.0
 */
public class GreenTintFilter extends Filter
{
    /**
     * Constructor for objects of class RedChannelFilter.
     * @param name The name of the filter.
     */
    public GreenTintFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                int green = pix.getGreen();
                image.setPixel(x, y, new Color(0, green, 0));
            }
        }
    }
}

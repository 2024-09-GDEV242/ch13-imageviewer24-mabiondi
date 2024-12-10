import java.awt.Color;

/**
 * An image filter to show only the blue channel in an image.
 * 
 * @author Michael Biondi
 * @version 1.0
 */
public class BlueChannelFilter extends Filter
{
    /**
     * Constructor for objects of class RedChannelFilter.
     * @param name The name of the filter.
     */
    public BlueChannelFilter(String name)
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
                int blue = pix.getBlue();
                image.setPixel(x, y, new Color(blue, blue, blue));
            }
        }
    }
}

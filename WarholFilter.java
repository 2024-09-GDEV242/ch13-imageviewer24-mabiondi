import java.awt.Color;

/**
 * An image filter to make an image into 4 smaller versions
 * of itself in different colors.
 * 
 * @author Michael Biondi
 * @version 1.0
 */
public class WarholFilter extends Filter
{
    /**
     * Constructor for objects of class WarholFilter.
     * @param name The name of the filter.
     */
    public WarholFilter(String name)
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
        // create copy of image with quarter size
        int halfWidth = image.getWidth() / 2;
        int halfHeight = image.getHeight() / 2;
        OFImage smallImage = new OFImage(halfWidth, halfHeight);
        
        
        // copy pixel data into new image
        for(int y = 0; y < halfHeight; y++) {
            for(int x = 0; x < halfWidth; x++) {
                image.setPixel(x, y, smallImage.getPixel(x, y));
            }
        }
    }
}

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
        
        OFImage newImage = new OFImage(image.getWidth(), image.getHeight());
        
        // top left (normal)
        for(int y = 0; y < halfHeight; y++) {
            for(int x = 0; x < halfWidth; x++) {
                newImage.setPixel(x, y, image.getPixel(x * 2, y * 2));
            }
        }
        // top right (red tint)
        for(int y = 0; y < halfHeight; y++) {
            for(int x = halfWidth; x < image.getWidth(); x++) {
                int red = image.getPixel(x * 2 - evenImageWidth(image), y * 2).getRed();
                newImage.setPixel(x, y, new Color(red, 0, 0));
            }
        }
        
        // bottom left (green tint)
        for(int y = halfHeight; y < image.getHeight(); y++) {
            for(int x = 0; x < halfWidth; x++) {
                int green = image.getPixel(x * 2, y * 2 - evenImageHeight(image)).getGreen();
                newImage.setPixel(x, y, new Color(0, green, 0));
            }
        }
        
        // bottom right (blue tint)
        for(int y = halfHeight; y < image.getHeight(); y++) {
            for(int x = halfWidth; x < image.getWidth(); x++) {
                int blue = image.getPixel(x * 2 - evenImageWidth(image), y * 2 - evenImageHeight(image)).getBlue();
                newImage.setPixel(x, y, new Color(0, 0, blue));
            }
        }
        
        // draw it all to original image
        for(int y = 0; y < image.getHeight(); y++) {
            for(int x = 0; x < image.getWidth(); x++) {
                image.setPixel(x, y, newImage.getPixel(x, y));
            }
        }
        
    }
    
    /**
     * Returns width of the image as an even number (to avoid array index OOB errors)
     */
    private int evenImageWidth(OFImage image) {
        return (image.getWidth() / 2) * 2;
    }
    
    /**
     * Returns height of the image as an even number (to avoid array index OOB errors)
     */
    private int evenImageHeight(OFImage image) {
        return (image.getHeight() / 2) * 2;
    }

}


package qtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author Sjaak Smetsers
 * @version 11-03-2016
 */
public interface QTNode {
    public void fillBitmap( int x, int y, int width, Bitmap bitmap );
    public void writeNode( Writer out );
    public boolean equals(QTNode node); 
    public int getVal();
}

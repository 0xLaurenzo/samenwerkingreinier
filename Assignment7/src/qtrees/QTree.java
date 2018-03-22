package qtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class QTree {
    QTNode root;
    
    public QTree(Reader input) {
        try {
            root = readQTree( input );
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public QTree(Bitmap bitmap) {
        root = bitmap2QTree( 0, 0,  bitmap.getWidth(), bitmap );
    }

    public void fillBitmap (Bitmap bitmap) {
        root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
    }

    public void writeQTree(Writer sb) {
        root.writeNode(sb);
    }
    
    private static QTNode readQTree(Reader input) throws IOException {
            switch(input.read()) {
                case '1' : return new GrayNode(input);
                case '0':   
                        if (input.read() == '0')
                            return  new BlackLeaf();
                        else
                            return  new WhiteLeaf();
                default : return null;
            }
    }
    
    public static QTNode bitmap2QTree(int x, int y, int width, Bitmap bitmap){
        if (width == 1){
            if (bitmap.getBit(x, y)){
                return new BlackLeaf();
            }
            return new WhiteLeaf();
        }
        int widthdiv = width / 4;
        QTNode QTNode1 = bitmap2QTree(0 ,0 , widthdiv, bitmap);
        QTNode QTNode2 = bitmap2QTree(widthdiv ,0 , widthdiv, bitmap);
        QTNode QTNode3 = bitmap2QTree(0 ,widthdiv , widthdiv, bitmap);
        QTNode QTNode4 = bitmap2QTree(widthdiv ,widthdiv , widthdiv, bitmap);
        if (QTNode1.equals(QTNode2) && QTNode2.equals(QTNode3)
                && QTNode3.equals(QTNode4)){
            return QTNode1;
        }
        return new GrayNode(QTNode1, QTNode2, QTNode3, QTNode4);
    }
}

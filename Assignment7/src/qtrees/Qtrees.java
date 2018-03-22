package qtrees;

import java.io.StringReader;
import java.io.StringWriter;

public class Qtrees {

    public static void main(String[] args) {
        String test_tekst = "10011010001010010001010101100011000101000000";
        StringReader input = new StringReader(test_tekst);
        QTree qt = new QTree( input );
        StringWriter out = new StringWriter();
        qt.writeQTree(out);
        System.out.println(out.toString());
        Bitmap bitmap = new Bitmap(8, 8);
        qt.fillBitmap( bitmap );
        System.out.println(bitmap);
    }

}

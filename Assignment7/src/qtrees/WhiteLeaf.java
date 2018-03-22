/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qtrees;

import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Laurens
 */
public class WhiteLeaf implements QTNode{
    private int val;
    public WhiteLeaf(){
        this.val = 2;
    }
    
    public int getVal(){
        return this.val;
    }
    
    @Override
    public void writeNode(Writer out){
        try {
            out.append('0');
            out.append('1');
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap ){
        for (int i = 0; i < width; i++){
            for (int j = 0; j < width; j++){
                bitmap.setBit(i + x, j + y, true);
            }
        }
    }
    
    @Override
    public boolean equals(QTNode node){
        if(node.getVal() == this.val)
            return true;
        return false;
    }
}

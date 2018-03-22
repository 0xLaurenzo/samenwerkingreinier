/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author Laurens
 */
public class GrayNode implements QTNode{
     private int val;
     private QTNode[] nodes = new QTNode[4];

     
    public GrayNode(QTNode node1, QTNode node2, QTNode node3, QTNode node4){
        this.val = 1;
        this.nodes[0] = node1;
        this.nodes[1] = node2;
        this.nodes[2] = node3;
        this.nodes[3] = node4;
    }
    
    public GrayNode(Reader input){
        this.val = 1;
            for(int i = 0; i < 4; i++){
                try {
                switch (input.read()){
                    case '1' :  
                        nodes[i] = new GrayNode(input);
                        break;
                    case '0':   
                        if (input.read() == '0')
                            nodes[i] = new BlackLeaf();
                        else
                            nodes[i] = new WhiteLeaf();
                        break;
                    }
                }
                catch(IOException e){
                e.printStackTrace();
                }
        }
    }
    
    public int getVal(){
        return this.val;
    }
    
    @Override
    public void writeNode(Writer out){
        try {
            out.append('1');
            for (int i = 0; i < 4; i++){
                nodes[i].writeNode(out);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap){
        int widthdiv = width / 2;
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                x = j * widthdiv;
                nodes[i].fillBitmap(x, y, widthdiv, bitmap);
            }
            y = widthdiv * i;
        }
    }
    
    @Override
    public boolean equals(QTNode node){
        if(node.getVal() == this.val)
            return true;
        return false;
    }
}

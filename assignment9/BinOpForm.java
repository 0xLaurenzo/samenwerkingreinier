/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment9;

/**
 *
 * @author Laurens
 */
public class BinOpForm implements Form {
    private BinOp op;
    private Form leftOperand;
    private Form rightOperand;
    
    public BinOpForm ( BinOp op, Form left, Form right ) {
        this.op = op;
        this.leftOperand = left;
        this.rightOperand = right;
    }

    @Override
    public Form getId(){
        return this.op.getId();
    }
    
    public Form getLeft(){
        return this.leftOperand;
    }
    
    public Form getRight(){
        return rightOperand;
    }
    
    
    public void accept( FormVisitor v ) {
        v.visit( this );
    }
}

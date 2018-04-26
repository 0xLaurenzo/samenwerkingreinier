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
public enum BinOp implements Form{
    AndOp ( "/\\" ),
    OrOp ( "\\/" ),
    ImpliesOp ( "=>" ) ;
    
    private String string;
    
    private BinOp ( String string ) {
        this.string = string;
    }
    
    @Override
    public Form getId(){
        return this;
    }
    
    @Override
    public void accept(FormVisitor v){
        v.visit(this);
    }
}

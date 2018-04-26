/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg9;

/**
 *
 * @author reiniersanders
 */
public enum AtomVal implements Form{
    TrueOp ( "T" ),
    FalseOp ( "F" );
    
    private String string;
    
    private AtomVal(String string){
        this.string = string;
    }
    
    public Form getId(){
        return this;
    }
    
    @Override
    public boolean accept(FormVisitor v){
        return v.visit(this);
    }
}
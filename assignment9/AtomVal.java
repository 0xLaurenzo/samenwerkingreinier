/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment9;

/**
 * @author Laurens Kubat s4626249
 * @author Reinier Sanders s4335422
 */
public enum AtomVal implements Form {
    TrueOp ( "T" ){
        public boolean apply(){
            return true;
        }
    },
    FalseOp ( "F" ){
        public boolean apply(){
            return false;
        }
    };
    
    private String string;
    
    private AtomVal(String string){
        this.string = string;
    }
    
    @Override
    public Form getId(){
        return this;
    }
    
    @Override
    public boolean accept(FormVisitor v){
        return v.visit(this);
    }
}

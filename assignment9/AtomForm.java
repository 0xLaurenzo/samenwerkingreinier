/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment9;

/**
 *
 * @author reiniersanders
 */
public class AtomForm implements Form {
    private AtomVal value;
    
    public AtomForm(AtomVal value){
        this.value = value;
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

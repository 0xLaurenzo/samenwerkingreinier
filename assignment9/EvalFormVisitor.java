/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment9;

/**
 * @author Reinier Sanders s4335422
 * @author Laurens Kubat s4626249
 */
public class EvalFormVisitor implements Form{
    private Map<String,Boolean> environ;
    
    public EvalFormVisitor(Map<String,Boolean> environ){
        this.environ = environ;
    }
    
    public boolean visit(BinOpForm form){
        return form.getOp().apply(
        form.getLeft().accept(this),
        form.getRight().accept(this));
    }
    
    public boolean visit(AtomForm form){
        return form.getValue().apply(
        form.getValue().accept(this));
    }
    
    public boolean visit(NotForm form){
        return form.getOperand().apply(
        form.getOperand().accept(this));
    }
    
    @Override
    public boolean accept(FormVisitor v){
        return v.visit(this);
    }
    
    @Override
    public Form getId(){
        return this;
    }
}

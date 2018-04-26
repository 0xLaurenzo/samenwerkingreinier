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
public class NotForm implements Form{
    private NotSym sym;
    private Form operand;
    
    public NotForm(NotSym sym, Form operand){
        this.sym = sym;
        this.operand = operand;
    }
    
    @Override
    public boolean accept(FormVisitor v){
        return v.visit(this);
    }
    
    @Override
    public Form getId(){
        return this;
    }
    
    Form getOperand() {
        return operand;
    }
}

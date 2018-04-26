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
public class PrintFormVisitor implements FormVisitor {
    private StringBuilder string;
    
    

    @Override
    public boolean visit(BinOpForm form) {
       string.append("(" + form.getLeft().accept(this) 
               + form.getId()+ form.getRight().accept(this) + ")"); 
    }

    @Override
    public boolean visit(NotForm form) {
        string.append("~" + form.getOperand().accept( this ));
    }

    @Override
    public boolean visit(AtomForm form) {
        string.append(form.getId());
    }

    @Override
    public boolean visit(AtomVal form) {
        string.append(form.getId());
    }

    @Override
    public boolean visit(BinOp form) {
        string.append(form.getId());
    }
        
}

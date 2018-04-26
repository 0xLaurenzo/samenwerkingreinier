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
public class PrintFormVisitor implements FormVisitor {
    private StringBuilder string;
    
    

    @Override
    public void visit(BinOpForm form) {
       string.append("(" + form.getLeft().accept(this) 
               + form.getId()+ form.getRight().accept(this) + ")"); 
    }

    @Override
    public void visit(NotForm form) {
        string.append("~" + form.getOperand().accept( this ));
    }

    @Override
    public void visit(AtomForm form) {
        string.append(form.getId());
    }

    @Override
    public void visit(AtomVal form) {
        string.append(form.getId());
    }

    @Override
    public void visit(BinOp form) {
        string.append(form.getId());
    }
        
}

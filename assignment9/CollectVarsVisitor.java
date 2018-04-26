/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment9;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Laurens
 */
public class CollectVarsVisitor implements FormVisitor {
    private List<String> collectedVariables;
    
    public CollectVarsVisitor() {
        collectedVariables = new LinkedList<> ();
    }
    
    @Override
    public void visit( BinOpForm form ) {
        form.getLeft().accept( this );
        form.getRight().accept( this );
    }

    public void visit( NotForm form ){
    form.getOperand().accept( this );
    }

    public void visit( AtomForm form ) {
        if ( ! collectedVariables.contains( form.getId() )) {
            collectedVariables.add( form.getId() );
        }
    }
    public void visit( BasicForm form ) {
    }
    
    public List<String> getCollectedVariables() {
        return collectedVariables;
    }
}

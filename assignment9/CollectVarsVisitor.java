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
    
    public boolean visit( BinOpForm form ) {
    form.getLeft().accept( this );
    form.getRight().accept( this );
    }

    public boolean visit( NotForm form ){
    form.getOperand().accept( this );
    }

    public boolean visit( AtomForm form ) {
        if ( ! collectedVariables.contains( form.getId() )) {
            collectedVariables.add( form.getId() );
        }
    }
    public boolean visit( BasicForm form ) {
    }
    
    public List<String> getCollectedVariables() {
        return collectedVariables;
    }
}

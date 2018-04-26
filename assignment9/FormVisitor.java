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
public interface FormVisitor{
    boolean visit( BinOpForm form );
    boolean visit( NotForm form );
    boolean visit( AtomForm form );
    boolean visit( AtomVal form );
    boolean visit( BinOp form);
    boolean visit( NotSym form);
    boolean visit( EvalFormVisitor form);
}

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
public interface FormVisitor {
    void visit( BinOpForm form );
    void visit( NotForm form );
    void visit( AtomForm form );
    void visit( BasicForm form );
    void visit( BinOp form);
}

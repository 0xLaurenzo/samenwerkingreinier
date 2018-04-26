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
    boolean visit( BinOpForm form );
    boolean visit( NotForm form );
    boolean visit( AtomForm form );
    boolean visit( BasicForm form );
}

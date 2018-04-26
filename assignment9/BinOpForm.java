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
public class BinOpForm implements Form {
    private BinOpForm op;
    private Form leftOperand;
    private Form rightOperand;
    public BinOpForm ( BinOpForm op, Form left, Form right ) {
    this.op = op;
    this.leftOperand = left;
    this.rightOperand = right;
}

    @Override
    public boolean accept( FormVisitor v ) {
        v.visitBinOpForm( this );
    }

    Object getRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Object getLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

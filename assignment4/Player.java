/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 *
 * @author  Laurens Kubat   s4626249
 * @author  Reinier Sanders s4335422
 */
public interface Player {
    public void play(int x_cord, int y_cord);
    public String getName();
    public void setName(String name);
    public String getColor();
    public void setColor(String color);
}

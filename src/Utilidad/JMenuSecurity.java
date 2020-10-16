/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidad;

import javax.swing.Action;
import javax.swing.JMenu;

/**
 *
 * @author W4LT3R
 */
public class JMenuSecurity extends JMenu{

    public JMenuSecurity() {
    }

    public JMenuSecurity(String s) {
        super(s);
    }

    public JMenuSecurity(Action a) {
        super(a);
    }

    public JMenuSecurity(String s, boolean b) {
        super(s, b);
    }
}

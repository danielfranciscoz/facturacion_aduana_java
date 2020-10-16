package Utilidad;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author W4LT3R
 */
public class Validador {

    public static int NUMEROS = 0;
    public static int NUMEROS_POS_DEC = 1;
    public static int NUMEROS_POS_ENT = 2;
    public static int NUMEROS_NEG_ENT = 3;
    public static int NUMEROS_NEG_DEC = 4;

    public static int LETRAS = 5;
    public static int LETRAS_WITH_SPACE = 6;
    public static int ALFANUMERICO = 7;
    public static int ALFANUMERICO_WITH_SPACE = 8;

    public static void Validar(JComponent componente, int ValidacionTipo) {
        String claseComponente = componente.getClass().getName();
//        if (claseComponente.equalsIgnoreCase("javax.swing.JTextArea")
//                || claseComponente.equalsIgnoreCase("javax.swing.JTextField")
//                || claseComponente.equalsIgnoreCase("javax.swing.JPasswordField")) {
//        }
        componente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char letra = evt.getKeyChar();
                String texto;
                if (claseComponente.equalsIgnoreCase("javax.swing.JTextArea")) {
                    texto = ((JTextArea) evt.getSource()).getText();
                } else if (claseComponente.equalsIgnoreCase("javax.swing.JPasswordField")) {
                    texto = new String(((JPasswordField) evt.getSource()).getPassword());
                } else {
                    texto = ((JTextField) evt.getSource()).getText();
                }
                String specialsCharacters = "!#$%&@.,;:-_{}[]^+*~¨|°¬/()¿?!¡\\\"";

                switch (ValidacionTipo) {
                    case 0:
                        if (!Character.isDigit(evt.getKeyChar())
                                && letra != '-' && letra != '.') {
                            evt.consume();
                        } else if (letra == '-') {
                            if (texto.contains("-")
                                    || texto.length() > 0) {
                                evt.consume();
                            }
                        } else if (letra == '.') {
                            if (texto.length() < 1 || texto.contains(".")) {
                                evt.consume();
                            }
                        }
                        break;

                    case 1:
                        if (!Character.isDigit(evt.getKeyChar()) && letra != '.') {
                            evt.consume();
                        } else if (letra == '.') {
                            if (texto.length() < 1 || texto.contains(".")) {
                                evt.consume();
                            }
                        }
                        break;

                    case 2:
                        if (!Character.isDigit(evt.getKeyChar())) {
                            evt.consume();
                        }
                        break;

                    case 5:
                        if (!Character.isLetter(evt.getKeyChar())) {
                            evt.consume();
                        }
                        break;

                    case 6:
                        if (!Character.isLetter(letra) && letra != ' ') {
                            evt.consume();
                        }
                        break;

                    case 7:
                        if (!Character.isLetter(letra)
                                && !Character.isDigit(letra)
                                && !specialsCharacters.contains(String.valueOf(letra))) {
                            evt.consume();
                        }
                        break;

                    case 8:
                        if (!Character.isLetter(letra)
                                && !Character.isDigit(letra)
                                && letra != ' '
                                && !specialsCharacters.contains(String.valueOf(letra))) {
                            evt.consume();
                        }
                        break;

                    default:
                        if (!Character.isLetter(letra) && letra != ' ') {
                            evt.consume();
                        }
                        break;
                }
            }
        });
    }
}

package Utilidad;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author W4LT3R
 */
public class JTextValid extends javax.swing.JTextField {

    public JTextValid() {
        Init();
    }

    public JTextValid(String text) {
        super(text);
        Init();
    }

    public static int ONLY_NUMEROS = 0;
    public static int ONLY_NUMEROS_POS_DEC = 1;
    public static int ONLY_NUMEROS_POS_ENT = 2;
    public static int ONLY_NUMEROS_NEG_ENT = 3;
    public static int ONLY_NUMEROS_NEG_DEC = 4;

    public static int ONLY_LETRAS = 5;
    public static int ONLY_LETRAS_WITH_SPACE = 6;
    public static int ONLY_ALFANUMERICO = 7;
    public int ValidationType = 7;

    public void setValidationType(int type) {
        this.ValidationType = type;
    }

    private void Init() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                Validator validar = new Validator(e);
                switch (ValidationType) {
                    case 0:
                        break;
                    case 1:
                        validar.NumPosDec();
                        break;
                    case 2:
                        validar.NumPosEnt();
                        break;

                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        validar.AlfaNumerico();
                        break;
                    case 8:

                        break;
                    default:
                        validar.Letras();
                        break;
                }
            }
        });

    }

    public static void EnviarFoco(JTextField txtActual, Component txtFuturo) {
        if (!txtActual.getText().equals("")) {
            txtFuturo.requestFocus();
        }

    }

    public class Validator {

        KeyEvent evt;
        String texto;
        char letra;
        String caracteres;

        public Validator(KeyEvent evt) {
            this.caracteres = "!#$%&/()¿?!¡ \\\"";
            this.evt = evt;
            this.texto = ((JTextField) evt.getSource()).getText();
            this.letra = evt.getKeyChar();
        }

        public void Num() {

        }

        public void NumPosEnt() {
            if (!Character.isDigit(evt.getKeyChar())) {
                evt.consume();
            }
        }

        public void NumPosDec() {
            if (!Character.isDigit(evt.getKeyChar()) && letra != '.') {
                evt.consume();
            }
            if (letra == '.') {
                if (texto.length() < 1 || texto.contains(".")) {
                    evt.consume();
                }
            }
        }

        public void Letras() {
            if (!Character.isLetter(evt.getKeyChar())) {
                evt.consume();
            }
        }

        public void LetrasWithSpace() {
            if (!Character.isLetter(letra) && letra != ' ') {
                evt.consume();
            }
        }

        public void AlfaNumerico() {
            if (!Character.isLetter(letra)
                    && !Character.isDigit(letra)
                    && !caracteres.contains(String.valueOf(letra))) {
                evt.consume();
            }
        }
    }
}

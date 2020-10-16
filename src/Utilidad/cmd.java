/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author W4LT3R
 */
public class cmd {

    public static void Execute(String command) {
        try {
            Runtime run = Runtime.getRuntime();
            run.exec(new String[]{
                "cmd.exe",
                "/c",
                command
            });
        } catch (Exception e) {
        }
    }

    public static String ExecuteWithResult(String... command) {
        String result = "";
        try {
            String[] prms = new String[command.length + 2];
            prms[0] = "cmd.exe";
            prms[1] = "/c";
            System.arraycopy(command, 0, prms, 2, command.length);

            ProcessBuilder builder = new ProcessBuilder(prms);
            builder.redirectErrorStream(true);
            Process proc = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            while (true) {
                String line = r.readLine();
                if (line == null) {
                    break;
                }
                result += "\n" + line;
            }
        } catch (IOException ex) {
        }
        return result.trim();
    }

    public class CmdProperty {

        private String Name = "";
        private String Value = "";

        public CmdProperty() {
        }

        public CmdProperty(String prop) {
            String replace = prop.replace("\n", "").trim();
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getValue() {
            return Value;
        }

        public void setValue(String Value) {
            this.Value = Value;
        }

    }
}

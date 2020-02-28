package sef.module11.ac.activitySkibin;

import java.io.*;

public class Notepad implements TextEditor {

    private BufferedReader input;


    public Notepad() {
        System.out.println("Notepad ready!");
        input = new BufferedReader(new InputStreamReader(System.in));


    }

    @Override
    public void saveAs(String text) {
        System.out.println("Please input path where file should be saved or push 'Enter' to save in current directory:");

        try {
            String path = input.readLine();
            if (path.length() == 0) {
                path = ".\\src\\sef\\module11\\";
            }
            if (path.lastIndexOf('\\') < 0) {
                path += "\\";
            }
            System.out.println("Please input name for file ('text' is default)");
            String name = input.readLine();
            if (name.length() == 0) {
                name = "text";
            }

            File file = new File(String.format(path + "%s.txt", name));
            FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
            Writer output = new BufferedWriter(fileWriter);
            output.write(text);
            output.flush();
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("File was saved");

    }

    @Override
    public String typeIn() {
        System.out.println("Enter a string or type 'END' to exit");


        StringBuilder text = new StringBuilder();
        String line = "";

        while (!line.equalsIgnoreCase("end")) {
            try {
                line = input.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line.equalsIgnoreCase("end")) {
                System.out.println("Bye bye (●'◡'●)");
            } else {
                System.out.println("You typed: " + line);
            }
            text.append(line + System.lineSeparator());

        }

        return text.toString();
    }


}

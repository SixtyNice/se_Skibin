package sef.module11.ac.activitySkibin;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TextEditor notepad = new Notepad();
        String text = notepad.typeIn();
        notepad.saveAs(text);
    }

}

import java.util.Scanner;

public class UserInput {

    // Methode für die Menu Navigation
    public int menuAuswahl(){
        int auswahl;
        Scanner scan = new Scanner(System.in);
        readInt("Bitte geben Sie eine Zahl an. ");
        auswahl = scan.nextInt();
        return auswahl;
    }

    public String jaNeinAbfrage(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.println(prompt);
        String antwort = " ";
        antwort = readChar("Bitte geben sie ein Y oder N ein.");
        return antwort;
    }

    // Methode für die Nutzereingabe des Ap Namen.
    public String userApNameIn() {

        return readString("Bitte geben Sie einen Namen für das Arbeitspaket an. ");
    }

    // Methode für die Nutzereingabe des Ap Nummer.
    public int userApNummerIn() {
        return readInt("Bitte geben Sie die Nummer des Arbeitpakets an. ");
    }

    // Methode für die Nutzereingabe des Nachfolgers  !!! Bisher nur einer möglich !!!
    public int userVorgaengerIn() {
        return readInt("Bitte geben Sie die Vorgänger des AP an.");
    }

    // Methode für die Nutzereingabe des frühsten Anfangsstartpunkt.
    //public int userFazIn() {
    //    return readInt("Bitte geben Sie die Nummer des Arbeitpakets an. ");
    //}

    // Methode für die Nutzereingabe der Dauer des Arbeitspaketes.
    public int userDauerIn() {
        return readInt("Bitte geben Sie die Dauer des Arbeitpakets an. ");
    }

    // Methode zum aufangen einer falschen Eingabe wenn kein -int-
    public int readInt(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.println(prompt);

        while (!scan.hasNextInt()) {
            System.out.println("Bitte geben sie nur Zahlen an. ");
            scan.next();
        }
        return scan.nextInt();
    }

    // Methode zum aufangen einer falschen Eingabe wenn kein -String-
    public String readString(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.println(prompt);
        String input = scan.nextLine();

        if(input.isEmpty()) {
            return readString("Bitte mindestens ein Zeichen angeben. ");
        }
        return input;
    }

    // Methode zum aufangen einer falschen Eingabe -char-
    public String readChar(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.println(prompt);
        String auswahl = scan.next();
        switch (auswahl) {
            case "y":

                break;
            case "Y":

                break;
            case "x":

                break;
            case "X":

                break;
            default:
                System.out.println("Bitte geben sie ein Y für Ja oder N für Nein ein.");
        }

        return scan.nextLine();
    }


}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Scanner für Variable ApNr erstellen
        Scanner scannerApNr = new Scanner(System.in);

        // Instanz der Klasse Arbeitspaket erstellen
        Arbeitspaket arbeitspaket = new Arbeitspaket();

        // Eingabeaufforderung für den Benutzer
        System.out.print("Bitte geben Sie eine Arbeitspaket Nummer ein: ");
        int input = scannerApNr.nextInt(); // Liest die Benutzereingabe

        // Setzen der privaten Variablen über den Setter
        arbeitspaket.setApNr(input);

        // (Optional) Den Wert der Variablen ausgeben
        System.out.println("Die eingegebene Arbeitspaket Nummer ist: " + arbeitspaket.getApNr());

        // Scanner schließen (optional, aber empfohlen)
        scannerApNr.close();
    }
}
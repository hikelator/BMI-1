package ovm_lehrjahr_1;
import java.util.InputMismatchException; //nochmal nachlesen
import java.util.Scanner; //importiert die Scannerklasse
/**
 * @author Hajk Medyan
 */
public class BMIRechner {

    public static void main(String[] args) {
        //Hier werden die Variablen gesetzt!
        int gewicht = 0;
        double groesse = 0;
        double ergebnis;
        boolean sex_control = false;
        boolean gewichtkontrolle = false;
        boolean groessekontrolle = false;
        String Bezeichner = "BMI = ";
        String sex_man = "";
        
        
        Scanner input = new Scanner(System.in); //Hier wird die tastatureingabe ermöglicht.
        
        System.out.println("Bitte geben sie Ihr Geschlecht an (m / w): ");
            
            while (sex_control == false) {
                    
                sex_man = input.next();
                  
                if ("m".equals(sex_man) || "w".equals(sex_man) )
                {
                    sex_control = true;
                }
                else 
                {
                    sex_man = "";
                    System.out.println("Bitte geben sie nur 'm' für männlich oder 'w' für weiblich ein.");
                }
            }
        
            
            System.out.println("Geben Sie bitte Ihre Körpergröße in Zentimeter an: "); //Ausgegebener Text
             
            
            while (groessekontrolle == false) { //Bedingungen um die Groesse zu akzeptieren
                try {                           //versuch eines Durchlaufes
                    groesse = input.nextInt();  //Input der Tastatur wird der Variable groesse zugewiesen
                }
                catch (InputMismatchException e){ //bei Falscheingabe wird nachfolgendes ausgeführt
                    System.out.println("Geben Sie bitte nur Zahlen ein!"); 
                    input.nextLine();           //Siehe groesse = input.nextInt();
                }
                if (groesse < 150 || groesse > 251) {             //Bedingung zur Ausführung
                    System.out.println("Dieser Wert ist unzulässig. Bitte geben Sie eine Größe ab 150cm oder bis 251cm ein!");
                }
                else {                          //wird die Bedingung bei if nicht erfüllt kommt else
                    groessekontrolle = true;
                }
            }
                       
            System.out.println("Geben Sie bitte Ihr Körpergewicht in KG an: ");
            
            while (gewichtkontrolle == false) {
                try {
                    gewicht = input.nextInt();
                }
                catch (InputMismatchException e){
                    System.out.println("Geben Sie bitte nur Zahlen ein!");
                    input.nextLine();
                }
                if (gewicht < 40 || gewicht > 300 ) {
                    System.out.println("Dieser Wert ist unzulässig. Bitte geben sie ein Gewicht zwischen 40 & 300 Kg ein!");
                }
                else {
                    gewichtkontrolle = true;
                }
            }
                     
                ergebnis = ( (gewicht / (groesse * groesse))*10000); //Berechnungsfunktion            
        ergebnis = ergebnis * 100;
        ergebnis = Math.round(ergebnis);       
        ergebnis = ergebnis / 100;
        
        System.out.println(Bezeichner + ergebnis);
        
        if ("m".equals(sex_man)){
            if (ergebnis < 19)
                System.out.println("Sie sind untergewichtig");
            if (ergebnis >= 19 && ergebnis < 25)
                System.out.println("Sie befinden sich im Bereich des Normalgewichts.");
            if (ergebnis >= 25 && ergebnis < 29)
                System.out.println("Sie sind Übergewichtig");
            if (ergebnis >= 29)
                System.out.println("Sie sind stark Übergewichtig.");
        }    
        
        else {
        if (ergebnis < 18.5)
                System.out.println("Sie sind untergewichtig");
            if (ergebnis >= 18.5 && ergebnis < 25)
                System.out.println("Sie befinden sich im Bereich des Normalgewichts.");
            if (ergebnis >= 25 && ergebnis < 30)
                System.out.println("Sie sind Übergewichtig");
            if (ergebnis >= 30)
                System.out.println("Sie sind stark Übergewichtig.");
        }
    }    
}

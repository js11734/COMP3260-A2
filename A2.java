
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class A2
{
    static String PLAINTEXT ="";
    static String PDASH ="";
    static String KEY ="";
    static String KEYDASH="";
    
    


    public static void main(String[] args)
    {
        A2 A2 = new A2();
        System.out.println("Plaintext: " +PLAINTEXT);
        Scanner scan = new Scanner(System.in);
        A2.readInputs();
        System.out.println("Plaintext: " +PLAINTEXT);
        System.out.println("PDASH: " + PDASH);
        System.out.println("KEY: " + KEY);
        System.out.println("KEYDASH: " + KEYDASH);
       
        
    }

    public void readInputs() {
        try {
            System.out.println("Enter a file name to read from");
            Scanner read = new Scanner(System.in);
            String fileName = read.nextLine();
            File file = new File(fileName);
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String line = scan.nextLine().trim();
                if (!line.isEmpty() && PLAINTEXT.equals("")) {
                    PLAINTEXT = line;
                    
                }
                else if (!line.isEmpty() &&PDASH.equals(""))
                {
                    PDASH = line;
                }
                else if (!line.isEmpty() && KEY.equals(""))
                {
                    KEY = line;
                }

                else if(!line.isEmpty() && KEYDASH.equals(""))
                {
                    KEYDASH = line;
                }
            }

            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    

    }

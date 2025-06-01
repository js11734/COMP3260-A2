
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileReader
{
    static String PLAINTEXT ="";
    static String PDASH ="";
    static String KEY ="";
    static String KEYDASH="";
    
    


FileReader()
{

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
                    setPlaintext(line);
                    
                }
                else if (!line.isEmpty() &&PDASH.equals(""))
                {
                    setPlaintextDash(line);
                }
                else if (!line.isEmpty() && KEY.equals(""))
                {
                    setKey(line);
                }

                else if(!line.isEmpty() && KEYDASH.equals(""))
                {
                    setKeyDash(line);
                } 
            }

            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void setPlaintext(String Plaintext)
    {
        PLAINTEXT = Plaintext;

    }

    public String getPlainText()
    {
        return PLAINTEXT;
    }

      public void setPlaintextDash(String Plaintext)
    {
        PDASH = Plaintext;

    }

    public String getPlainTextDash()
    {
        return PDASH;
    }

     public void setKey(String Key)
    {
        KEY = Key;
    }
    public String getKey()
    {
        return KEY;
    }

      public void setKeyDash(String Key)
    {
        KEYDASH = Key;
    }
    public String getKeyDash()
    {
        return  KEYDASH;
    }
    
    

    }

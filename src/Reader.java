import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Reader {

    String inputText;

    //-------------------------------file names------------------------------------
//    private static final String declarationFilePath = "C:\\Users\\Tamar\\Desktop\\usdeclarPC.txt";
//    private static final String humanDNAFilePath = "C:\\Users\\Tamar\\Desktop\\humanDNA.txt";
//    private static final String moneyInFilePath = "C:\\Users\\Tamar\\Downloads\\moneyIn.txt";

    private static final String declarationFilePath = "C:\\Users\\tamar\\Desktop\\stuff\\CS stuff\\usdeclarPC.txt";
    private static final String humanDNAFilePath = "C:\\Users\\tamar\\Desktop\\stuff\\CS stuff\\humanDNA.txt";
    private static final String moneyInFilePath = "C:\\Users\\tamar\\Desktop\\stuff\\CS stuff\\moneyIn.txt";
    //-----------------------------------------------------------------------------


    public String getDeclaration(){
        readFile(declarationFilePath);
        return inputText;
    }

    public String getDNA(){
        readFile(humanDNAFilePath);
        return inputText;
    }

    public String getMoneyIn(){
        readFile(moneyInFilePath);
        return inputText;
    }

    private void readFile(String FILENAME) {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        try {
            String text;
            reader = new BufferedReader(new FileReader(FILENAME));
            while ((text = reader.readLine()) != null) {
                builder.append(text);
                builder.append("\n");
            }
            inputText = builder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //System.out.println(builder.toString());
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {

            }
        }
    }
}
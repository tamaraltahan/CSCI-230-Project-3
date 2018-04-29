import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Reader {

    String text;

    //-------------------------------file names------------------------------------
    private static final String declartionFilePath = "C:\\Users\\Tamar\\Desktop\\usdeclarPC.txt";
    private static final String humanDNAFilePath = "C:\\Users\\Tamar\\Desktop\\humanDNA.txt";
    //-----------------------------------------------------------------------------


    public String getDeclaration(){
        readFile(declartionFilePath);
        return text;
    }

    public String getDNA(){
        readFile(humanDNAFilePath);
        return text;
    }

    private void readFile(String FILENAME) {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        try {
            String text;
            reader = new BufferedReader(new FileReader(FILENAME));
            while ((text = reader.readLine()) != null) {
                builder.append(text);
            }
            text = builder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {

            }
        }
    }
}
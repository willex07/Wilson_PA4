import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {
    private Integer wordCounter;
    private Map<String, Integer> map;
    public DuplicateCounter()
    {
        this.wordCounter = 0;
        this.map = new HashMap<>();
    }
    public void count(String dataFile)
    {
        Scanner fileReader;
        try
        {
            fileReader = new Scanner(new File(dataFile));
            while(fileReader.hasNextLine()) {
                String line = fileReader.nextLine().trim();
                String[] data = line.split("[\\W]+");
                for(String word : data) {
                    this.wordCounter = map.get(word);
                    this.wordCounter = (this.wordCounter == null) ? 1 : ++this.wordCounter;
                    map.put(word, this.wordCounter);
                }
            }
            fileReader.close();
        }catch(FileNotFoundException fnfe){
            System.out.println("File " + dataFile + " cannot be found.");
            System.exit(1);
        }
    }
    public void write(String outputFile)
    {
        FileWriter fw;
        PrintWriter pw;
        try {
            fw = new FileWriter(new File(outputFile));
            pw = new PrintWriter(fw);
            for(Map.Entry<String, Integer> entry : map.entrySet())
            {
                pw.write(entry.getKey() + " occurs " + entry.getValue() + " times" + System.lineSeparator());
            }
            System.out.println("" + outputFile);
            pw.flush();
            fw.close();
            pw.close();
        } catch (IOException ex) {
            System.out.println("Error in writing to " + outputFile + ": " + ex.getMessage());
            System.exit(1);
        }
    }
}
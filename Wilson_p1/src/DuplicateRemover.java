import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
    private Set<String> uniqueWords;
    public void remove(String dataFile) throws FileNotFoundException
    {
        String wrd;
        uniqueWords = new HashSet<String>();
        Scanner scnr=new Scanner(new File(dataFile));
        while(scnr.hasNext()) {
            wrd=scnr.next();
            uniqueWords.add(wrd);
        }
        scnr.close();
    }
    public void write(String outputFile) throws IOException
    {
        File y;
        FileWriter fw = null;
        y = new File(outputFile);
        if(y.exists()) {
            fw=new FileWriter(y,true);
            Iterator itr=uniqueWords.iterator();
            while(itr.hasNext()) {
                String str=(String)itr.next();
                fw.write(str+"\n");
            }
            fw.close();

        }
        else
        {
            y.createNewFile();
            fw=new FileWriter(y);
            Iterator itr=uniqueWords.iterator();
            while(itr.hasNext()){
                String str=(String)itr.next();
                fw.write(str+"\n");
            }
            fw.close();
        }
    }
}
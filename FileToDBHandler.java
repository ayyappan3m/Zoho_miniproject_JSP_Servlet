package student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileToDBHandler {
	private DB db;
    private File file;
    private BufferedReader bufferedReader;
    public FileToDBHandler(){
        db = new DB();
    }
    
    public void fileToDB(String filename){
         try {            
            file = new File(filename); 
            bufferedReader = new BufferedReader(new FileReader(file)); 
            String line; 

            while ((line = bufferedReader.readLine()) != null){
                String words[] = line.split(",");
                //for (String word : words) 
                {
                  //  if (word != null)
                	{
                        db.insert(words[0],words[1]);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }finally{
             try {
                 bufferedReader.close();             
             } catch (IOException ex) {
            	 System.out.println(ex);
             }
            
         }
    } 
}

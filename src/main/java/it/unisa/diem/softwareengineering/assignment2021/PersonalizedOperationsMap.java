package it.unisa.diem.softwareengineering.assignment2021;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;


public class PersonalizedOperationsMap extends HashMap<String,String>{
    
    
    public Iterator<String> getPersonalizedOperationIterator(String key){
        String[] strings= this.get(key).split(" ");
        ArrayList<String> values= new ArrayList<>(Arrays.asList(strings));
        return values.iterator();
    }

    public Iterator<String> getMapIterator(){
        ArrayList<String> strings= new ArrayList<>();
        for (Map.Entry<String, String> pair: this.entrySet()){
            strings.add(pair.getKey()+":"+pair.getValue());
        }
        return strings.iterator();
    }

    public void saveToFile(String fileName) throws IOException, ClassNotFoundException{
        File file=new File(fileName);
        if(!file.createNewFile()){
            ObjectInputStream in=new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            PersonalizedOperationsMap mapOnFile=(PersonalizedOperationsMap) in.readObject();
            in.close();
            for (Map.Entry<String, String> pair: this.entrySet()){
                String key=pair.getKey();
                String value=pair.getValue();
                int i=0;
                boolean check=false;
                String copyValue=value;
                while(mapOnFile.containsKey(copyValue)){
                    i=i+1;
                    copyValue=value+"_"+i;
                }
                mapOnFile.put(key, value);
            }
            file.delete();
            ObjectOutputStream out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            out.writeObject(mapOnFile);
            out.close();
        }else{
            ObjectOutputStream out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            out.writeObject(this);
            out.close();
        }
    }
    
    public void loadFromFile(String fileName) throws IOException, ClassNotFoundException{
        File file=new File(fileName);
        ObjectInputStream in=new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
        PersonalizedOperationsMap mapOnFile=(PersonalizedOperationsMap) in.readObject();
        in.close();
        for (Map.Entry<String, String> pair: mapOnFile.entrySet()){
            String key=pair.getKey();
            String value=pair.getValue();
            int i=0;
            String copyValue=value;
            while(this.containsKey(copyValue)){
                i=i+1;
                copyValue=value+"_"+i;
            }
            this.put(key, copyValue);
        }
    }

    
}

package it.unisa.diem.softwareengineering.assignment2021;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;


public class PersonalizedOperationsMap extends HashMap<String,String>{
    
    
    /** Put method that checks if the key already exists. In this case, the key will be duplicated
     * @param key
     * @param value
     * @return String return the key that will be modified if there is a duplicate
     */
    @Override
    public String put(String key, String value){
        int i=0;
        String copyKey=key;
        while(this.containsKey(copyKey)){
            i=i+1;
            copyKey=key+"("+i+")";
        }
        super.put(copyKey,value);
        return copyKey;
    }
    
    
    /** Method that edit an operation and replace the old value associated with the key.
     * @param key key to modify
     * @param value new value
     */
    public void edit(String key, String value){
        super.put(key,value);
    }
    
    /** Get an Iterator that iterate over the operations associated with the key
     * @param key Name of the operation
     * @return Iterator<String>
     */
    public Iterator<String> getPersonalizedOperationIterator(String key){
        String[] strings= this.get(key).split(" ");
        ArrayList<String> values= new ArrayList<>(Arrays.asList(strings));
        return values.iterator();
    }

    
    /** Get an Iterator that iterate over the map. Each element is like "key:value"
     * @return Iterator<String>
     */
    public Iterator<String> getMapIterator(){
        ArrayList<String> strings= new ArrayList<>();
        for (Map.Entry<String, String> pair: this.entrySet()){
            strings.add(pair.getKey()+":"+pair.getValue());
        }
        return strings.iterator();
    }

    
    /** Save to file the map (serialization) and delete the previous file.
     * @param fileName
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void saveToFile(String fileName) throws IOException, ClassNotFoundException{
        File file=new File(fileName);
        ObjectOutputStream out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
        out.writeObject(this);
        out.close();
    }
    
    
    /** Load from file the map (serialization). If there are duplicate keys, they will be kept unless their values are the same
     * @param fileName
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void loadFromFile(String fileName) throws IOException, ClassNotFoundException{
        File file=new File(fileName);
        ObjectInputStream in=new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
        PersonalizedOperationsMap mapOnFile=(PersonalizedOperationsMap) in.readObject();
        in.close();
        for (Map.Entry<String, String> pair: mapOnFile.entrySet()){
            String key=pair.getKey();
            String value=pair.getValue();
            boolean check_duplicate=false;
            int i=0;
            String copyKey=key;
            while(this.containsKey(copyKey)){
                if(this.get(copyKey).equals(mapOnFile.get(copyKey))){
                    check_duplicate=true;
                    break;
                }else{
                    i=i+1;
                    copyKey=key+"("+i+")";
                }
            }
            if(!check_duplicate){
                this.put(copyKey, value);
            }
            
        }
    }

    
}

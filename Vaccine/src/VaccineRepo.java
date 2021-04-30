import java.util.ArrayList;
import java.util.HashMap;

public class VaccineRepo {
    private HashMap<String, Integer> vaccines = new HashMap<>();

    public void addVaccine(String name, int count){
        if(vaccines.get(name) == null) vaccines.put(name, count);
        else
            vaccines.put(name, vaccines.get(name) + count);
    }

    public HashMap<String, Integer> getVaccines() {
        return vaccines;
    }

    public int getRest(String name){
        return  vaccines.get(name);
    }

    public void printList(){
        String[] vaccineNames = (String[]) vaccines.keySet().toArray();
        for(String name : vaccineNames){
            System.out.println(name + "\t\t"+vaccines.get(name));
        }
    }

}

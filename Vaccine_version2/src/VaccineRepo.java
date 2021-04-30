import java.util.HashMap;
import java.util.Set;

public class VaccineRepo {
    private HashMap<String, Integer> vaccines = new HashMap<>();

    //添加疫苗
    public void addVaccine(String name, int count){
        if(vaccines.get(name) == null) vaccines.put(name, count);
        else
            vaccines.put(name, vaccines.get(name) + count);
    }

    //使用疫苗
    public void useVaccine(String name){
        vaccines.put(name, vaccines.get(name) - 1);
    }

    //获取疫苗列表
    public HashMap<String, Integer> getVaccines() {
        return vaccines;
    }

    //获取疫苗余量
    public int getRest(String name){
        return  vaccines.get(name);
    }

    //打印仓库列表
    public void printList(){
        String[] vaccineNames =  vaccines.keySet().toArray(new String[0]);
        for(String name : vaccineNames){
            System.out.println("\t\t"+name + "\t\t"+vaccines.get(name));
        }
    }

}

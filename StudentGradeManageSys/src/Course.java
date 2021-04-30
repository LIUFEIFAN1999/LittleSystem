import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Course {
    private String name;
    private HashMap<String, Integer> scores= new HashMap<>();

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore(String name) {
        return scores.get(name);
    }

    public void setScore(String name, int score){
        scores.put(name, score);
    }

    public double getAvg(){
        int sum = 0;
        Iterator iter1=scores.entrySet().iterator();
        while(iter1.hasNext()){
            Map.Entry<String,Integer> entry=(Map.Entry<String,Integer>)iter1.next();
            sum += entry.getValue();
        }
        return sum/(double)scores.size();
    }
    public int getMax(){
        int max = 0;
        Iterator iter1=scores.entrySet().iterator();
        while(iter1.hasNext()){
            Map.Entry<String,Integer> entry=(Map.Entry<String,Integer>)iter1.next();
            if(entry.getValue() > max) max = entry.getValue();
        }
        return max;
    }
    public int getMin(){
        int min = Integer.MAX_VALUE;
        Iterator iter1=scores.entrySet().iterator();
        while(iter1.hasNext()){
            Map.Entry<String,Integer> entry=(Map.Entry<String,Integer>)iter1.next();
            if(entry.getValue() < min) min = entry.getValue();
        }
        return min;
    }

}

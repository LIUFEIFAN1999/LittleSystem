import java.util.ArrayList;

public class PersonManager {
    ArrayList<Person> persons = new ArrayList<>();

    //注册
    public void register(String name,  String gender, String phoneNumber,  String idCard,  String address,  String city, int age){
        persons.add(new Person(name,  gender,  age, phoneNumber,  idCard,  address,  city));
        System.out.println(name+" 注册成功");
    }

    //验证身份
    public Person verify(String idCard){
        //验证被接种者是否已注册
        for(Person p: persons){
            if(p.getIdCard().equals(idCard))
                return p;
        }
        return null;
    }
}

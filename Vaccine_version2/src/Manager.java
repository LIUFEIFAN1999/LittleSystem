import java.text.SimpleDateFormat;
import java.util.*;

public class Manager {
    //人员管理
    PersonManager personManager = new PersonManager();
    //诊所管理
    ClinicManager clinicManager = new ClinicManager();
    //记录管理
    RecordManager recordManager = new RecordManager();

    //接种
    // idCard 身份证号码 （用于验证身份）
    //disease 疾病史  pregnant 怀孕与否 （用于验证身体状况）
public void vaccinate(String clinicName, String idCard, boolean disease, boolean pregnant){

    // 以下变量用于存储此次接种记录信息
    // name, 被接种人姓名
    // clinicName, 接种诊所名字
    // nurseName, 接种护士名字
    // vaccineName, 接种疫苗种类
    // time, 接种时间
    String name,nurseName, vaccineName;
    Date time;

    //验证idCard
    Person person = personManager.verify(idCard);
    if(person == null){
        System.out.println("您尚未注册！");
    }

    //验证身体状况以及年龄
    if(disease || pregnant || person.age < 18 || person.age > 59)
        System.out.println("由于年龄或身体状况的原因，您不适合接种！");

    //分配资源
    String[] sources = clinicManager.allocate(clinicName);
    if(sources == null){
        System.out.println("接种资源不足！");
    }
    nurseName = sources[0];
    vaccineName = sources[1];

    //接种
    clinicManager.vaccinate(clinicName, vaccineName);

    // 获取当前时间
    time = new Date();
    name = person.name;
    Record record = new Record(name, idCard, clinicName, nurseName, vaccineName,time);

    //添加记录
    recordManager.addRecord(record);
    System.out.println(person.getName()+"接种成功");
    }
}

import java.text.SimpleDateFormat;
import java.util.*;

public class Manager {
    ArrayList<Person> persons = new ArrayList<>();
    ArrayList<Clinic> clinics = new ArrayList<>();
    ArrayList<Record> records = new ArrayList<>();

    //添加诊所
    public void addClinic(String name, String address, String city){
        Clinic clinic = new Clinic(name, address, city);
        clinics.add(clinic);
    }

    //添加疫苗
    public void addVaccine(String clinicName, String name, int count){
        for(Clinic clinic : clinics){
            if(clinic.getName().equals(clinicName))
                clinic.getRepo().addVaccine(name, count);
        }
    }

    //添加护士
    public void addNurse(String clinicName, String nurseName, String gender){
        for(Clinic clinic : clinics){
            if(clinic.getName().equals(clinicName))
                clinic.getNurses().add(new Person(nurseName, gender));
        }
    }

    //注册
    public void register(){
        String name,  gender, phoneNumber,  idCard,  address,  city;
        int age;
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********个人信息注册**************");
        System.out.print("姓名：");
        name = scanner.next();
        System.out.print("性别：");
        gender = scanner.next();
        System.out.print("年龄：");
        age = scanner.nextInt();
        System.out.print("手机号：");
        phoneNumber = scanner.next();
        System.out.print("身份证号：");
        idCard = scanner.next();
        System.out.print("城市：");
        city = scanner.next();
        System.out.print("详细地址：");
        address = scanner.next();
        persons.add(new Person(name,  gender,  age, phoneNumber,  idCard,  address,  city));
    }

    //输入身体状况
    private Conditions inputCondition(){
        Scanner scanner = new Scanner(System.in);
        boolean disease, pregnant;
        String input;
        System.out.println("@个人身体状况登记");
        System.out.print("是否有严重疾病，不适合接种：");
        input = scanner.next();
        disease = input.equals("Y") || input.equals("y");
        System.out.print("是否怀孕：");
        input = scanner.next();
        pregnant = input.equals("Y") || input.equals("y");
        return new Conditions(disease, pregnant);
    }

    //分配诊所
    private String allocateClinic(String city){
        for(Clinic clinic:clinics){
            if(clinic.getCity().equals(city)){
                Collection<Integer> counts = clinic.getRepo().getVaccines().values();
                int n = 0;
                for(int count : counts){
                    n += count;
                }
                if(n > 0)
                     return clinic.getName();
            }
        }
        return "no clinic";
    }

    //分配护士
    private String allocateNurse(String clinicName){
        for(Clinic clinic:clinics){
            if(clinic.getName().equals(clinicName)){
                Random random = new Random();
                ArrayList<Person> nurses = clinic.getNurses();
                return nurses.get(random.nextInt(nurses.size())).getName();
            }
        }
        return "no nurse";
    }

    //分配疫苗
    private String allocateVaccine(String clinicName){
        for(Clinic clinic:clinics){
            if(clinic.getName().equals(clinicName)){
                Set<String> vaccines = clinic.getRepo().getVaccines().keySet();
                for(String vaccineName : vaccines){
                    if(clinic.getRepo().getRest(vaccineName) > 0)
                        return vaccineName;
                }
            }
        }
        return "no clinic";
    }

    //验证身份
    private Person verify(){
        String idCard;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入身份证号码：");
        idCard = scanner.next();
        for(Person p:persons){
            if(p.getIdCard().equals(idCard))
                return p;
        }
        return null;
    }

    //接种
    public boolean vaccinate(){
        String clinicName, nurseName, vaccineName;
        Date time;
        System.out.println("**********疫苗接种服务**************");


        Person person = verify();
        if(person == null){
            System.out.println("您尚未注册！");
            return false;
        }


        Conditions condition = inputCondition();
        person.setCondition(condition);
        if(!person.isQualified()){
            System.out.println("由于年龄或身体状况的原因，您不适合接种！");
            return false;
        }


        String city = person.city;
        clinicName = allocateClinic(city);
        if(clinicName.equals("no clinic")){
            System.out.println("您所在的城市还没有接种点！");
            return false;
        }

        vaccineName = allocateVaccine(clinicName);
        if(vaccineName.equals("no vaccine")){
            System.out.println("疫苗余量供应不足！");
            return false;
        }

        nurseName = allocateNurse(clinicName);
        time = new Date();// 获取当前时间
        person.setVaccinated(true);
        Record record = new Record(person.getName(), person.getIdCard(), clinicName, nurseName, vaccineName,time);
        records.add(record);
        System.out.println("接种成功！");
        return  true;
    }

    //打印接种名单
    private void printList(){
        System.out.println("****************已接种人名单*****************");
        for(Record r : records)
            System.out.println("\t\t"+r.getName());
        System.out.println("************************************************");
    }

    //打印库存
    private void printRepo(){
        String clinicName;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入诊所名字：");
        clinicName = scanner.next();
        for(Clinic clinic : clinics){
            if(clinic.getName().equals(clinicName)){
                System.out.println("*********************疫苗仓库***********************");
                System.out.println("类型\t\t余量");
                clinic.getRepo().printList();
                return;
            }
        }
        System.out.println("该仓库为空");
    }

    //打印接种证明
    private void printProof(Record record){
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss ");
        System.out.println("*********************************接种证明**************************************************************");
        System.out.println("*             姓名：" +record.getName());
        System.out.println("*             身份证："+record.getIdCard());
        System.out.println("*             接种地："+record.getClinicName());
        System.out.println("*             接种护士："+record.getNurseName());
        System.out.println("*             接种疫苗："+record.getVaccineName());
        System.out.println("*             接种时间："+sdf.format(record.getTime()));
        System.out.println("***************************************************************************************************");
    }

    //查询证明
    public void queryRecordById(){
        String idCard;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入身份证号码：");
        idCard = scanner.next();
        for(Record r : records){
            if(r.getIdCard().equals(idCard)){
                printProof(r);
                return;
            }
        }
        System.out.println("暂无接种记录！");
    }

    private void exitSys(){
        System.exit(0);
    }

    private void printError(){
        System.out.println("输入不正确！");
    }

    public void menu(){
        int option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你选择的操作：");
        System.out.println("1.注册");
        System.out.println("2.接种");
        System.out.println("3.查询证明");
        System.out.println("4.接种名单");
        System.out.println("5.离开系统");
        System.out.println("请输入你的选择：");
        option = scanner.nextInt();
        switch(option) {
            case 1:
                register();
                menu();
                break;
            case 2:
                vaccinate();
                menu();
                break;
            case 3:
                queryRecordById();
                menu();
                break;
            case 4:
                printList();
                menu();
                break;
            case 5:
                exitSys();
            default:
                printError();
        }
    }
}

import java.util.*;

public class ClinicManager {
    ArrayList<Clinic> clinics = new ArrayList<>(); //诊所列表

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
                clinic.getNurses().add(new Nurse(nurseName, gender));
        }
    }

    //接种
    public void vaccinate(String clinicName, String vaccineName){
        for(Clinic c : clinics){
            if(c.getName().equals(clinicName)){
                c.getRepo().useVaccine(vaccineName);
                return;
            }
        }
    }

    //分配资源
    public String[] allocate(String clinicName) {
        String nurseName, vaccineName = null;
        Clinic clinic = null;

        for (Clinic c : clinics) {
            if(c.getName().equals(clinicName))
                clinic = c;
        }
        if (clinic == null)
            return null;

        //分配疫苗
        HashMap<String, Integer> vaccines = clinic.getRepo().getVaccines();
        for(Map.Entry<String,Integer> entry : vaccines.entrySet()){
            if(entry.getValue() > 0){
                vaccineName = entry.getKey();
                break;
            }
        }
        /*Set<String> vaccineNames = vaccines.keySet();
        for (String _vaccineName : vaccineNames) {
            if (clinic.getRepo().getRest(_vaccineName) > 0)
                vaccineName = _vaccineName;
        }*/
        if (vaccineName == null){
            return null;
        }

        //分配护士
        ArrayList<Nurse> nurses = clinic.getNurses();
        Random random = new Random();
        //生成一个小于护士数量的非负数
        int n = random.nextInt(nurses.size());
        //获取随机分配的护士姓名
        nurseName = nurses.get(n).getName();
        if (nurseName == null)
            return null;

        return new String[] {nurseName, vaccineName};
    }

    //打印库存
    public void printRepo(String clinicName){
        for(Clinic clinic : clinics){
            if(clinic.getName().equals(clinicName)){
                System.out.println("***********"+clinicName+" 疫苗仓库*************");
                System.out.println("\t\t类型\t\t余量");
                clinic.getRepo().printList();
                return;
            }
        }
        System.out.println("\t\t该仓库为空");
    }
}

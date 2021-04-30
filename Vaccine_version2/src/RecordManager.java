import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class RecordManager {
    ArrayList<Record> records = new ArrayList<>();

    public void addRecord(Record record){
        records.add(record);
    }

    //打印已接种名单
    public void printList(){
        System.out.println("************已接种人名单**************");
        for(Record r : records)
            System.out.println("\t\t\t"+r.getName());
        System.out.println("*****************************************");
    }

    //查询证明
    public void queryRecordById(String idCard){
        for(Record r : records){
            if(r.getIdCard().equals(idCard)){
                printProof(r);
                return;
            }
        }
        System.out.println("暂无接种记录！");
    }

    //打印接种证明
    private void printProof(Record record){
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss ");
        System.out.println("******************************接种证明******************************");
        System.out.println("*          姓名：" +record.getName());
        System.out.println("*          身份证："+record.getIdCard());
        System.out.println("*          接种地："+record.getClinicName());
        System.out.println("*          接种护士："+record.getNurseName());
        System.out.println("*          接种疫苗："+record.getVaccineName());
        System.out.println("*          接种时间："+sdf.format(record.getTime()));
        System.out.println("************************************************************************");
    }
}

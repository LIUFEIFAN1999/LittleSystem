import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Manager manager = new Manager();
        //添加诊所
        manager.clinicManager.addClinic("武汉诊所","武昌区108","武汉市");
        manager.clinicManager.addClinic("北京诊所","海淀区503","北京市");
        manager.clinicManager.addClinic("上海诊所","徐汇区998","上海市");

        //添加护士
        manager.clinicManager.addNurse("武汉诊所","小红","女");
        manager.clinicManager.addNurse("武汉诊所","小明","男");

        manager.clinicManager.addNurse("北京诊所","小黄","女");
        manager.clinicManager.addNurse("北京诊所","小绿","男");

        manager.clinicManager.addNurse("上海诊所","小白","女");
        manager.clinicManager.addNurse("上海诊所","小紫","女");

        //添加疫苗
        //疫苗种类
        Vaccine vaccine1 = new Vaccine("疫苗1", 200);
        Vaccine vaccine2 = new Vaccine("疫苗2", 100);
        Vaccine vaccine3 = new Vaccine("疫苗3", 300);
        //添加
        manager.clinicManager.addVaccine("武汉诊所", "疫苗1", 3);
        manager.clinicManager.addVaccine("武汉诊所", "疫苗2", 2);
        manager.clinicManager.addVaccine("北京诊所", "疫苗1", 2);
        manager.clinicManager.addVaccine("北京诊所", "疫苗3", 1);
        manager.clinicManager.addVaccine("上海诊所", "疫苗2", 2);
        manager.clinicManager.addVaccine("上海诊所", "疫苗3", 2);

        //注册
        System.out.println("注册>>>>>");
        manager.personManager.register("Jack","Male","12345","111222","WHU","武汉市",22);
        manager.personManager.register("Lisa","Female","12356","111333","The Great Wall","北京市",29);

        //查看库存  before vaccinating
        System.out.println("查看库存>>>>>");
        manager.clinicManager.printRepo("武汉诊所");
        manager.clinicManager.printRepo("北京诊所");
        manager.clinicManager.printRepo("上海诊所");

        //接种
        System.out.println("接种>>>>>");
        manager.vaccinate("武汉诊所","111222",false,false);
        manager.vaccinate("北京诊所","111333",false,false);

        //再次查看仓库 after vaccinating
        System.out.println("再次查看库存>>>>>");
        manager.clinicManager.printRepo("武汉诊所");
        manager.clinicManager.printRepo("北京诊所");
        manager.clinicManager.printRepo("上海诊所");

        //查看接种名单
        System.out.println("接种人员名单>>>>>");
        manager.recordManager.printList();

        //查询接种证明
        System.out.println("接种证明查询>>>>>");
        manager.recordManager.queryRecordById("111222");
        manager.recordManager.queryRecordById("111333");
    }
}

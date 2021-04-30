import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Manager manager = new Manager();
        //添加诊所
        manager.addClinic("武汉诊所","武昌区108","武汉市");
        manager.addClinic("北京诊所","海淀区503","北京市");
        manager.addClinic("上海诊所","徐汇区998","上海市");

        //添加护士
        manager.addNurse("武汉诊所","小红","女");
        manager.addNurse("武汉诊所","小明","男");

        manager.addNurse("北京诊所","小黄","女");
        manager.addNurse("北京诊所","小绿","男");

        manager.addNurse("上海诊所","小白","女");
        manager.addNurse("上海诊所","小紫","女");

        //添加疫苗
            //疫苗种类
        Vaccine vaccine1 = new Vaccine("疫苗1", 200);
        Vaccine vaccine2 = new Vaccine("疫苗2", 100);
        Vaccine vaccine3 = new Vaccine("疫苗3", 300);
            //添加
        manager.addVaccine("武汉诊所", "疫苗1", 3);
        manager.addVaccine("武汉诊所", "疫苗2", 2);
        manager.addVaccine("北京诊所", "疫苗1", 2);
        manager.addVaccine("北京诊所", "疫苗3", 1);
        manager.addVaccine("上海诊所", "疫苗2", 2);
        manager.addVaccine("上海诊所", "疫苗3", 2);

        //开始
        manager.menu();

    }
}

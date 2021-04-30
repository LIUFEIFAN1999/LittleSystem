import java.util.*;

public class Manager {
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();

    public Manager() {
        courses.add(new Course("应用数学"));
        courses.add(new Course("大学英语"));
        courses.add(new Course("Java"));
        courses.add(new Course("计算机基础"));
    }

    public void printGradeList(){
       HashMap<String, Double> map = new HashMap<>();
        System.out.println("姓名\t\t平均分");
        for(Student stu : students){
            int sum = 0;
            for(Course c : courses){
                sum += c.getScore(stu.getName());
            }
            map.put(stu.getName(), sum/4.0);
        }
        List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Map.Entry<String, Double> mapping : list){
            System.out.println(mapping.getKey()+"\t\t"+mapping.getValue());
        }
    }

    public void printCourseGradeList(){
        System.out.println("姓名\t\t最高分\t\t最低分\t\t平均分");
        for(Course c : courses){
            System.out.println(c.getName()+"\t\t"+c.getMax()+"\t\t" +
                    c.getMin()+"\t\t"+c.getAvg());
        }
    }

    public void queryGradeByName(){
        Scanner scanner = new Scanner(System.in);
        String name = null;
        System.out.println("请输入姓名：");
        name = scanner.next();
        for(Course c:courses)
            System.out.print(c.getName()+"\t\t");
        System.out.println();
        for(Course c:courses)
            System.out.print(c.getScore(name)+"\t\t\t\t");
        System.out.println();
    }

    public void inputInfo(int n){
        Scanner scanner = new Scanner(System.in);
        String name = null;
        long id = 0;
        int am =0, eng=0, java=0, cs=0;
        for(int i=0; i<n; i++){
            System.out.println("学生"+(i+1)+":");
            System.out.print("学号：");
            id = scanner.nextLong();
            System.out.print("姓名：");
            name = scanner.next();
            System.out.print("应用数学：");
            am = scanner.nextInt();
            System.out.print("大学英语：");
            eng = scanner.nextInt();
            System.out.print("Java：");
            java = scanner.nextInt();
            System.out.print("计算机基础：");
            cs = scanner.nextInt();
            Student stu = new Student(name, id);
            students.add(stu);
            courses.get(0).setScore(stu.getName(), am);
            courses.get(1).setScore(stu.getName(), eng);
            courses.get(2).setScore(stu.getName(), java);
            courses.get(3).setScore(stu.getName(), cs);
        }
    }

    public void menu(){
        System.out.println("请选择以下功能：");
        System.out.println("1.输入学生成绩");
        System.out.println("2.输出成绩表");
        System.out.println("3.输出各科成绩单");
        System.out.println("4.查询成绩");
        System.out.println("5.退出");
        Scanner scanner = new Scanner(System.in);
        int s;
        s = scanner.nextInt();
        switch (s){
            case 1: inputInfo(10);menu();break;
            case 2:printGradeList();menu();break;
            case 3:printCourseGradeList();menu();break;
            case 4:queryGradeByName();menu();break;
            case 5: System.exit(0);
            default:
                System.out.println("输入格式错误！");
                menu();
        }
    }

    public static void main(String[] args) {
        Manager stuManager  = new Manager();
        stuManager.menu();
    }
}

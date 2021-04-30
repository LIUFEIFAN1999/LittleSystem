import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Manager {
    //存放图书的数组
    Vector<Book> vector = new Vector<Book>();
    //扫描读取键盘输入
    Scanner sc = new Scanner(System.in);

    //无参构造函数
    public Manager() { }

    //打印列表
    public void printBook(){
        int n = vector.size();
        System.out.println("\t书号\t作者\t姓名\t标题\t出版社\t定价\t");
        for(int index = 0; index < n; index++){
            Book book = vector.elementAt(index);
            System.out.println(book.toString());
        }
    }

    //
    public void addBook(){
        int id;
        String name, title, publish;
        double price;
        System.out.println("请输入你要添加的书号：");
        id = sc.nextInt();
        System.out.println("请输入你要添加的作者：");
        name = sc.next();
        System.out.println("请输入你要添加的标题：");
        title = sc.next();
        System.out.println("请输入你要添加的出版社：");
        publish = sc.next();
        System.out.println("请输入你要添加的定价：");
        price = sc.nextDouble();
        Book book = new Book(id, name, title, publish, price);
        vector.add(book);
    }

    //
    public void queryBook(){
        int id;
        System.out.println("请输入你要查询的书号：");
        id = sc.nextInt();
        for(int i=0; i<vector.size(); i++)
            if(vector.get(i).id==id)
                System.out.println(vector.get(i));
    }

    //
    public void deleteBook(){
        int id;
        System.out.println("请输入你要删除的书号：");
        id = sc.nextInt();
        for(int i=0; i<vector.size(); i++)
        {
            if(vector.get(i).id==id)
                vector.remove(i);
        }
    }

    //
    public void exitSystem(){
        System.exit(0);
    }

    //导入图书
    public void importBook() throws IOException, ClassNotFoundException {
        File f = new File("D:/book.txt");
        if (f.exists() == true)
        {
            FileInputStream in = new FileInputStream(f);
            ObjectInputStream oin = new ObjectInputStream(in);
            Book[] aa=(Book[])oin.readObject();
            vector.clear();
            for(Book x:aa)
                vector.add(x);
            oin.close();
        }
    }

    //保存图书
    public void exportBook() throws IOException {
        File f = new File("D:/book.txt");
        FileOutputStream out = new FileOutputStream(f);
        ObjectOutputStream oout = new ObjectOutputStream(out);
        //JDK1.6能很好支持数组读写，下面将vector转换成ob数组，保存ob
        Book[] ob=vector.toArray(new Book[vector.size()]);
        oout.writeObject(ob);
        oout.close();
    }

    public void printError(){
        System.out.println("输入有误！");
    }

    public void menu() throws IOException, ClassNotFoundException {
        int option;
        System.out.println("请输入你选择的功能：");
        System.out.println("1.打印列表");
        System.out.println("2.增加图书");
        System.out.println("3.查找图书");
        System.out.println("4.删除图书");
        System.out.println("5.离开系统");
        System.out.println("6.保存到文件");
        System.out.println("7.从文件加载");
        System.out.println("请输入你的选择：");
        option = sc.nextInt();
        switch(option)
        {
            case 1:
                printBook();
                menu();
                break;
            case 2 :
                addBook();
                menu();
                break;
            case 3:
                queryBook();
                menu();
                break;
            case 4:
                deleteBook();
                menu();
                break;
            case 5:
                exitSystem();
                menu();
                break;
            case 6:
                exportBook();
                menu();
                break;
            case 7:
                importBook();
                menu();
                break;
            default:
                printError();
        }
    }
}

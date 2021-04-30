import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    //书号
    public int id;
    //作者姓名
    public String name;
    //标题
    public String title;
    //出版社
    public String publish;
    //定价
    public double price;

    //构造函数1
    public Book(int id, String name, String title, String publish, double price) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.publish = publish;
        this.price = price;
    }

    //无参构造函数
    public Book(){

    }
    //重写toString函数
    public String toString() {
        String ret = null;
        ret =  id + "\t";
        ret +=  name + "\t";
        ret +=  title + "\t";
        ret +=  publish + "\t";
        ret +=  price + "\t";
        return ret;
        }
}
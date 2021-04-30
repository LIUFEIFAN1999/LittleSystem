public class Test {
    public static void main(String args[])
    {
        Manager mag;
        try {
            mag = new Manager();
            mag.menu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

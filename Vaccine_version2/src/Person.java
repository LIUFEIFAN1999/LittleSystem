public class Person{
    protected String name;
    protected String gender;
    protected int age;
    protected String phoneNumber;
    protected String idCard;
    protected String address;
    protected String city;

    public Person(String name, String gender, int age, String phoneNumber, String idCard, String address, String city) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.idCard = idCard;
        this.address = address;
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }
}
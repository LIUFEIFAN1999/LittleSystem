import java.util.ArrayList;

public class Clinic {
    private String name;
    private String address;
    private String city;
    private ArrayList<Nurse> nurses = new ArrayList<>();
    private VaccineRepo repo = new VaccineRepo();

    public Clinic(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public ArrayList<Nurse> getNurses() {
        return nurses;
    }

    public VaccineRepo getRepo() {
        return repo;
    }
}
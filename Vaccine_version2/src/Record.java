import java.util.Date;

public class Record {
    private String name;
    private String idCard;
    private String clinicName;
    private String nurseName;
    private String VaccineName;
    private Date time;

    public Record(String name, String idCard, String clinicName, String nurseName, String vaccineName, Date time) {
        this.name = name;
        this.idCard = idCard;
        this.clinicName = clinicName;
        this.nurseName = nurseName;
        VaccineName = vaccineName;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getClinicName() {
        return clinicName;
    }

    public String getNurseName() {
        return nurseName;
    }

    public String getVaccineName() {
        return VaccineName;
    }

    public Date getTime() {
        return time;
    }
}

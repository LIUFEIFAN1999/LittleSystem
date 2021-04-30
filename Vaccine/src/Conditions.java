public class Conditions {
    private boolean disease;
    private boolean pregnant;

    public Conditions(boolean disease, boolean pregnant) {
        this.disease = disease;
        this.pregnant = pregnant;
    }

    public boolean isQualified(){
        if(disease && pregnant)
            return false;
        else
            return true;
    }
}

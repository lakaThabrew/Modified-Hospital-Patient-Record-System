public class Nurse implements Runnable {
    private int id;
    private LabReport report;

    public Nurse(int id, LabReport labReport) {
        this.report = labReport;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Nurse " + id + " is waiting for reading the lab report.");
        report.readreport(this);
    }
    
    public int getId() {
        return id;
    }

}

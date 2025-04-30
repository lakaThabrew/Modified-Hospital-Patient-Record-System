public class Doctor implements Runnable{
    private int id;
    private LabReport report;
    
    public Doctor(int id, LabReport labReport) {
        this.report = labReport;
        this.id = id;
    }
    
    @Override
    public void run() {
        System.out.println("Doctor " + id + " is waiting for writing the lab report.");
        report.writereport(this);
    }
    
    public int getId() {
        return id;
    }

}

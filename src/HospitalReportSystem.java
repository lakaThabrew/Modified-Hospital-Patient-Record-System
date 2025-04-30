public class HospitalReportSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to the Hospital Report System!\n");
        
        LabReport labReport = new LabReport();

        for (int i = 0; i < 10; i++) {
            Nurse nurse = new Nurse(i, labReport);
            Thread nurseThread = new Thread(nurse);
            nurseThread.start();
        }

        for (int i = 0; i < 5; i++) {
            Doctor doctor = new Doctor(i, labReport);
            Thread doctorThread = new Thread(doctor);
            doctorThread.start();
        }

        MLT mlt = new MLT(1, labReport);
        Thread mltThread = new Thread(mlt);
        mltThread.start();

        System.out.println("All threads have been started. The program will exit when all threads are done.\n");
    }
}

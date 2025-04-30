import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LabReport {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int readers = 0;
    private int writers = 0;

    public void readreport(Nurse nurse)
    {
        while (writers > 0) {
            try {
                Thread.sleep(100); // Wait for readers/writers to finish
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }
        lock.readLock().lock();
       // lock.writeLock().lock();
        try {
            // Simulate reading the report
            System.out.println("Nurse " + nurse.getId() + " is reading the lab report.");
            readers++;
            Thread.sleep(1000 + new Random().nextInt(1000)); // Simulate time taken to read the report
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        } finally {
            System.out.println("Nurse " + nurse.getId() + " has finished reading the lab report.");
            lock.readLock().unlock();
            readers--;
        }
    }

    public void writereport(Doctor doctor)
    {
        while (readers > 0 || writers > 0) {
            try {
                Thread.sleep(100); // Wait for readers/writers to finish
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }
        writers++;
        lock.writeLock().lock();
        try {
            // Simulate writing the report
            System.out.println("Doctor " + doctor.getId() + " is writing the lab report.");
            Thread.sleep(1000 + new Random().nextInt(1000)); // Simulate time taken to write the report
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        } finally {
            System.out.println("Doctor " + doctor.getId() + " has finished writing the lab report.");
            lock.writeLock().unlock();
            writers--;
        }
    }

    public void writereport(MLT mlt)
    {
        while (readers > 0 || writers > 0) {
            try {
                Thread.sleep(100); // Wait for readers/writers to finish
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }
        writers++;
        lock.writeLock().lock();
        try {
            // Simulate writing the report
            System.out.println("MLT " + mlt.getId() + " is writing the lab report.");
            Thread.sleep(1000 + new Random().nextInt(1000)); // Simulate time taken to write the report
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        } finally {
            System.out.println("MLT " + mlt.getId() + " has finished writing the lab report.");
            lock.writeLock().unlock();
            writers--;
        }
    }
}

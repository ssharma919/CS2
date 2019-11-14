package cs2.heap;

public class PriorityQueueRunner {

    public static void main(String[] args) {

        System.out.println("\nCreate with default sorting (ascending by condition)\n");

        Heap<Patient> heap = new Heap<Patient>();

        heap.add(new Patient("Fleming, Julius", Patient.OBSERVATION));
        heap.add(new Patient("Adkins, Roberta", Patient.OBSERVATION));
        heap.add(new Patient("Jefferson, Bernice", Patient.WAIT));
        heap.add(new Patient("Malone, Gwen", Patient.IMMEDIATE));
        heap.add(new Patient("Bowers, Dustin", Patient.IMMEDIATE));
        heap.add(new Patient("Powell, Daisy", Patient.WAIT));
        heap.add(new Patient("Briggs, Ramona", Patient.OBSERVATION));
        heap.add(new Patient("Dennis, Kerry", Patient.OBSERVATION));
        heap.add(new Patient("Johnson, Colin", Patient.EXPECTANT));
        heap.add(new Patient("Williams, Danielle", Patient.IMMEDIATE));

        while (!heap.isEmpty()) {
            System.out.println(heap.remove() + " ");
        }

        // repeat with different Patient settings
        System.out.println("\nRepeat - sorting by name in descending order\n");
        heap = new Heap<Patient>();
        Patient.sortBy(Patient.BY_NAME);
        Patient.setDirection(Patient.DESC);

        heap.add(new Patient("Fleming, Julius", Patient.OBSERVATION));
        heap.add(new Patient("Adkins, Roberta", Patient.OBSERVATION));
        heap.add(new Patient("Jefferson, Bernice", Patient.WAIT));
        heap.add(new Patient("Malone, Gwen", Patient.IMMEDIATE));
        heap.add(new Patient("Bowers, Dustin", Patient.IMMEDIATE));
        heap.add(new Patient("Powell, Daisy", Patient.WAIT));
        heap.add(new Patient("Briggs, Ramona", Patient.OBSERVATION));
        heap.add(new Patient("Dennis, Kerry", Patient.OBSERVATION));
        heap.add(new Patient("Johnson, Colin", Patient.EXPECTANT));
        heap.add(new Patient("Williams, Danielle", Patient.IMMEDIATE));

        while (!heap.isEmpty()) {
            System.out.println(heap.remove() + " ");
        }
    }


}
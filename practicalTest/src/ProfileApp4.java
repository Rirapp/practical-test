//import java.io.*;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//class Person4 {
//    String name;
//    String tanggalLahir;
//    String nik;
//
//    public Person4(String name, String tanggalLahir, String nik) {
//        this.name = name;
//        this.tanggalLahir = tanggalLahir;
//        this.nik = nik;
//    }
//
//    @Override
//    public String toString() {
//        return nik + "," + name + "," + tanggalLahir;
//    }
//}
//
//public class ProfileApp4 {
//    public static void main(String[] args) {
//        // Step 1: Create Person objects and store them in an array
//        Person[] persons = readPersonsFromInput();
//
//        // Step 2: Write data from the array to the file
//        writePersonsToFile(persons);
//
//        // Step 3: Read only the names from the file and store them in a string array
//        String[] names = readNamesFromFile();
//
//        // Step 4: Print the names array
//        System.out.println(Arrays.toString(names));
//    }
//
//    private static Person[] readPersonsFromInput() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter the number of persons: ");
//        int numPersons = scanner.nextInt();
//        scanner.nextLine(); // Consume the newline character
//
//        Person[] persons = new Person[numPersons];
//
//        for (int i = 0; i < numPersons; i++) {
//            System.out.println("Person #" + (i + 1));
//            System.out.print("Nama: ");
//            String name = scanner.nextLine();
//            System.out.print("Tanggal Lahir (yyyy-MM-dd): ");
//            String tanggalLahir = scanner.nextLine();
//            System.out.print("NIK: ");
//            String nik = scanner.nextLine();
//
//            persons[i] = new Person(name, tanggalLahir, nik);
//        }
//
//        scanner.close();
//
//        return persons;
//    }
//
//    private static void writePersonsToFile(Person[] persons) {
//        try (PrintWriter writer = new PrintWriter("profile.txt")) {
//            for (Person person : persons) {
//                writer.println(person);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static String[] readNamesFromFile() {
//        List<String> names = new ArrayList<>();
//
//        try (Scanner scanner = new Scanner(new File("profile.txt"))) {
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] parts = line.split(",");
//                if (parts.length >= 2) {
//                    names.add(parts[1]);
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return names.toArray(new String[0]);
//    }
//}

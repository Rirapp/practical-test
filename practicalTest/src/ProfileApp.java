//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//class Person {
//    String name;
//    Date tanggalLahir;
//    Integer nik;
//
//    public Person(String name, Date tanggalLahir, Integer nik) {
//        this.name = name;
//        this.tanggalLahir = tanggalLahir;
//        this.nik = nik;
//    }
//}
//
//public class ProfileApp {
//    public static void main(String[] args) {
//        // Step 1: Memasukkan objek ke dalam array of objects
//        List<Person> persons = new ArrayList<>();
//        persons.add(new Person("Budi", new Date(99, 0, 1), 123456789));
//        persons.add(new Person("Wati", new Date(99, 11, 31), 987654321));
//
//        // Step 2: Menulis data dalam array ke dalam file profile.txt
//        writeToFile(persons, "profile.txt");
//
//        // Step 3: Membaca isi file profile.txt dan memasukkan hanya Nama ke dalam array of strings
//        String[] names = readNamesFromFile("profile.txt");
//
//        // Menampilkan output array of strings (nama)
//        for (String name : names) {
//            System.out.println(name);
//        }
//    }
//
//    private static void writeToFile(List<Person> persons, String filename) {
//        try {
//            FileWriter writer = new FileWriter(filename);
//            for (Person person : persons) {
//                String line = person.nik + "," + person.name + "," + person.tanggalLahir.toString();
//                writer.write(line + "\n");
//            }
//            writer.close();
//            System.out.println("Data berhasil ditulis ke dalam file " + filename);
//        } catch (IOException e) {
//            System.out.println("Terjadi kesalahan dalam penulisan file.");
//            e.printStackTrace();
//        }
//    }
//
//    private static String[] readNamesFromFile(String filename) {
//        try {
//            List<String> lines = Files.readAllLines(Paths.get(filename));
//            String[] names = new String[lines.size()];
//            for (int i = 0; i < lines.size(); i++) {
//                String[] parts = lines.get(i).split(",");
//                names[i] = parts[1];
//            }
//            return names;
//        } catch (IOException e) {
//            System.out.println("Terjadi kesalahan dalam membaca file.");
//            e.printStackTrace();
//            return new String[0];
//        }
//    }
//}

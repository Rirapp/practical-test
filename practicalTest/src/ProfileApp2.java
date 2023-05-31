//import java.io.*;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//class Person2 {
//    String name;
//    Date tanggalLahir;
//    int nik;
//
//    public Person2(String name, Date tanggalLahir, int nik) {
//        this.name = name;
//        this.tanggalLahir = tanggalLahir;
//        this.nik = nik;
//    }
//}
//
//public class ProfileApp2 {
//    public static void main(String[] args) {
//        List<Person> persons = readPersonsFromInput();
//
//        if (persons.isEmpty()) {
//            System.out.println("Tidak ada data yang dimasukkan.");
//            return;
//        }
//
//        writeToFile(persons, "profile.txt");
//
//        String[] names = readNamesFromFile("profile.txt");
//
//        System.out.println("Nama-nama dari file profile.txt:");
//        for (String name : names) {
//            System.out.println(name);
//        }
//    }
//
//    private static List<Person> readPersonsFromInput() {
//        List<Person> persons = new ArrayList<>();
//
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            System.out.println("Masukkan data objek (nama,tanggal lahir,NIK), ketik 'selesai' untuk mengakhiri:");
//
//            String line;
//            while ((line = reader.readLine()) != null && !line.equalsIgnoreCase("selesai")) {
//                String[] parts = line.split(",");
//                if (parts.length == 3) {
//                    String name = parts[0].trim();
//                    Date tanggalLahir = new Date(parts[1].trim());
//                    int nik = Integer.parseInt(parts[2].trim());
//
//                    persons.add(new Person(name, tanggalLahir, nik));
//                } else {
//                    System.out.println("Format data tidak valid: " + line);
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Terjadi kesalahan pada input.");
//            e.printStackTrace();
//        }
//
//        return persons;
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
//        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//            List<String> names = new ArrayList<>();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts.length >= 2) {
//                    names.add(parts[1]);
//                }
//            }
//            return names.toArray(new String[0]);
//        } catch (IOException e) {
//            System.out.println("Terjadi kesalahan dalam membaca file.");
//            e.printStackTrace();
//            return new String[0];
//        }
//    }
//}

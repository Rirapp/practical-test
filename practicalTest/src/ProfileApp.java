import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;


class Person {
    String name;
    LocalDate tanggalLahir;
    int nik;

    public Person(String name, LocalDate tanggalLahir, int nik) {
        this.name = name;
        this.tanggalLahir = tanggalLahir;
        this.nik = nik;
    }
}


public class ProfileApp {
    public static void main(String[] args) {
        List<Person> persons = readPersonsFromInput();
        writeToFile(persons, "profile.txt");
        String[] names = readNamesFromFile("profile.txt");

        for (String name : names) {
            System.out.println(name);
        }
    }

    private static List<Person> readPersonsFromInput() {
        List<Person> persons = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        try {
            while (true) {
                System.out.print("Masukkan Nama (atau tekan Enter untuk selesai): ");
                String name = reader.readLine();
                if (name.isEmpty()) {
                    break;
                }

                System.out.print("Masukkan Tanggal Lahir (Format: yyyy-MM-dd): ");
                String tanggalLahirStr = reader.readLine();
                LocalDate tanggalLahir = LocalDate.parse(tanggalLahirStr);

                System.out.print("Masukkan NIK: ");
                int nik = Integer.parseInt(reader.readLine());

                Person person = new Person(name, tanggalLahir, nik);
                persons.add(person);
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan dalam membaca input.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("NIK harus berupa angka.");
            e.printStackTrace();
        }

        return persons;
    }

    private static void writeToFile(List<Person> persons, String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (Person person : persons) {
                String line = person.nik + "," + person.name + "," + person.tanggalLahir.toString();
                writer.write(line + "\n");
            }
            writer.close();
            System.out.println("Data berhasil dimasukan ke dalam file " + filename);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan dalam penulisan file.");
            e.printStackTrace();
        }
    }

    private static String[] readNamesFromFile(String filename) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            String[] names = new String[lines.size()];
            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                names[i] = parts[1];
            }
            return names;
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan dalam membaca file.");
            e.printStackTrace();
            return new String[0];
        }
    }
}

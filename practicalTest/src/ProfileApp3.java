import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// paling oke
class Person3 {
    String name;
    Date tanggalLahir;
    int nik;

    public Person3(String name, Date tanggalLahir, int nik) {
        this.name = name;
        this.tanggalLahir = tanggalLahir;
        this.nik = nik;
    }
}

public class ProfileApp3 {
    public static void main(String[] args) {
        List<Person3> persons = readPersonsFromInput();
        writeToFile(persons, "profile.txt");
        String[] names = readNamesFromFile("profile.txt");

        for (String name : names) {
            System.out.println(name);
        }
    }

    private static List<Person3> readPersonsFromInput() {
        List<Person3> persons = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            while (true) {
                System.out.print("Masukkan Nama (atau tekan Enter untuk selesai): ");
                String name = reader.readLine();
                if (name.isEmpty()) {
                    break;
                }

                System.out.print("Masukkan Tanggal Lahir (Format: yyyy-MM-dd): ");
                String tanggalLahirStr = reader.readLine();
                Date tanggalLahir = dateFormat.parse(tanggalLahirStr);

                System.out.print("Masukkan NIK: ");
                int nik = Integer.parseInt(reader.readLine());

                Person3 person = new Person3(name, tanggalLahir, nik);
                persons.add(person);
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan dalam membaca input.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("NIK harus berupa angka.");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("Format tanggal lahir tidak valid. Gunakan format yyyy-MM-dd.");
            e.printStackTrace();
        }

        return persons;
    }

    private static void writeToFile(List<Person3> persons, String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (Person3 person : persons) {
                String line = person.nik + "," + person.name + "," + person.tanggalLahir.toString();
                writer.write(line + "\n");
            }
            writer.close();
            System.out.println("Data berhasil ditulis ke dalam file " + filename);
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

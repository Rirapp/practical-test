//import java.io.*;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//public class Main {
//
//    public static void main(String[] args)  {
//        class Person {
//
//            String name;
//            String tanggalLahir;
//            String nik;
//
//            public Person(String name, String tanggalLahir, String nik) {
//                this.name = name;
//                this.tanggalLahir = tanggalLahir;
//                this.nik = nik;
//            }
//
//            @Override
//            public String toString() {
//                return nik + ":" + name + ":" + tanggalLahir;
//            }
//        }
//
//        try{
//
//            // Create an array of objects
//            Object[] objects = new Object[2];
//
//            // Add data to the array
//            objects[0] = new Person("Budi", "1999-01-01", "123456789");
//            objects[1] = new Person("Wati", "1999-12-31", "987654321");
//
//            // Write data to file
//            FileWriter writer = new FileWriter("profile.txt");
//            for (Object object : objects) {
//                writer.write(object.toString() + "\n");
//            }
//            writer.close();
//
//            // Read data from file
//            BufferedReader reader = new BufferedReader(new FileReader("profile.txt"));
//            String[] lines = reader.readLine().split(",");
//            List<String> names = new ArrayList<>();
//            for (String line : lines) {
//                names.add(line.split(":")[1]);
//            }
//
//            // Print names
//            System.out.println(names);
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
//
//

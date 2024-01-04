package io.bytes.zip;

import java.io.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class PersonController {
    public static ArrayList<Person> findAll(){
        try(ZipInputStream zipInput = new ZipInputStream(new BufferedInputStream(new FileInputStream("people.zip")))){
            zipInput.getNextEntry();
            ObjectInputStream objectInput = new ObjectInputStream(zipInput);
            return (ArrayList<Person>) objectInput.readObject();
        } catch (IOException e){
        } catch (ClassNotFoundException e){
        }
        return new ArrayList<>();
    }
    public static boolean saveAll(ArrayList<Person> persons){
        try(ZipOutputStream zipOutput = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(new File("people.zip"))))){
            ZipEntry zipEntry = new ZipEntry("people.obj");
            zipOutput.putNextEntry(zipEntry);
            ObjectOutputStream objectOutput = new ObjectOutputStream(zipOutput);
            objectOutput.writeObject(persons);
            zipOutput.closeEntry();
            return true;
        } catch (IOException e){
        }
        return false;
    }
    public static boolean save(Person person){
//        try (ZipOutputStream zipOutput = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream("people.zip")))){
//            ZipEntry zipEntry = new ZipEntry("people.obj");
//            zipOutput.putNextEntry(zipEntry);
//            ObjectOutputStream objOutput = new ObjectOutputStream(zipOutput);
//            objOutput.writeObject(person);
//            zipOutput.closeEntry();
//            return true;
//        } catch (IOException e){
//        }

        ArrayList<Person> foundPersons = findAll();
        foundPersons.add(person);
        return saveAll(foundPersons);
    }
    public static boolean delete(Person person){
        ArrayList<Person> foundPersons = findAll();
        return foundPersons.remove(person) && saveAll(foundPersons);
    }
    public static boolean update(Person oldPerson, Person newPerson){
        return delete(oldPerson) && save(newPerson);
    }
    public static ArrayList<Person> find(String name, String lastName, Date date){
        ArrayList<Person> foundPersons = new ArrayList<>();
        ArrayList<Person> persons = findAll();
        for (Person person : persons){
            if (person.getName().equals(name) && person.getLastName().equals(lastName) && person.getDate().equals(date)){
                foundPersons.add(person);
            }
        }
        return foundPersons;
    }
    public static ArrayList<Person> find(int id){
        ArrayList<Person> foundPersons = new ArrayList<>();
        ArrayList<Person> persons = findAll();
        for (Person person : persons) {
            if (person.getId() == id) {
                foundPersons.add(person);
            }
            return foundPersons;
        }
        return new ArrayList<>();
    }
    public static ArrayList<Person> find(ArrayList<String> cities){
        ArrayList<Person> foundPersons = new ArrayList<>();
        ArrayList<Person> persons = findAll();
        for (Person person : persons) {
            if (cities.contains(person.getAddress().getCity())){
                foundPersons.add(person);
            }
        }
        return foundPersons;
    }
}

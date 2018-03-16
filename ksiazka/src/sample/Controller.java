package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Controller {

    @FXML
     Label Name;
    @FXML
     Label Phone;
    @FXML
     Button add;
    @FXML
     Button update;
    @FXML
     Button delete;
    @FXML
     TextField fName;
    @FXML
     TextField fPhone;
    @FXML
     TableView<Contact> tab;


    /**Dodanie kontaktu**/
    public void add(){
        ObservableList<Contact> dane = tab.getItems();
        String imie = fName.getText();
        String tel = fPhone.getText();
        dane.add(new Contact(imie,tel));
        fName.setText("");
        fPhone.setText("");
        saveFile();
    }

    /**Usunięcie kontaktu**/
    public void delete(){
        ObservableList<Contact> dane = tab.getItems();
        int numer = tab.getSelectionModel().getSelectedIndex();
        dane.remove(numer);
        saveFile();
    }

    /**uzupełnienie pól po zaznaczeniu elementu**/
    public void fill(){
        Contact tmp = tab.getSelectionModel().getSelectedItem();
        fName.setText(tmp.getName());
        fPhone.setText(tmp.getPhone());
    }

    /** zmiana wpiu **/
    public void change(){
        int numer = tab.getSelectionModel().getSelectedIndex();
        Contact tmp = tab.getSelectionModel().getSelectedItem();
        ObservableList<Contact> dane = tab.getItems();
        tmp.setName(fName.getText());
        tmp.setPhone(fPhone.getText());
        dane.set(numer, tmp);
        saveFile();
    }

    /** zapis **/
    public void saveFile(){
        try{
            PrintWriter pisz = new PrintWriter("plik.dat");
            ObservableList<Contact> data = tab.getItems();
            for (Contact a : data){
                pisz.println(a.getName());
                pisz.println(a.getPhone());
            }
            pisz.close();
        }
        catch (IOException e){
            fName.setText("Błąd odczytu pliku!");
            fPhone.setText(e.getMessage());
        }

    }

    /** odczyt z pliku **/
    public void initialize(){
        try{
            File plik = new File ("plik.dat");
            if (plik.exists()) {
                Scanner wej = new Scanner(plik);
                ObservableList<Contact> dane = tab.getItems();
                while (wej.hasNext()){
                    dane.add(new Contact(wej.nextLine(), wej.nextLine()));
                }
            }
        }
        catch (IOException e){
        }
    }







}

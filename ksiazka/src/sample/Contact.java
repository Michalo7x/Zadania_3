package sample;
import javafx.beans.property.SimpleStringProperty;


public class Contact {
    private SimpleStringProperty name = new SimpleStringProperty("");
    private SimpleStringProperty phone = new SimpleStringProperty("");

    public Contact() {
        this("", "");
    }

    public Contact(String name, String phone) {
        setName(name);
        setPhone(phone);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String xname) {
        name.set(xname);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String xName) {
        phone.set(xName);
    }
}


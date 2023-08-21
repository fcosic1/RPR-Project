package ba.unsa.etf.rpr.domain;

public class User implements Idable {

    private int id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String email;
    private String address;


    public User(String name, String lastName, String address, String password,String email, String phoneNumber){
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User(){}
    @Override
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }
    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getPassword() {

        return password;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }
}

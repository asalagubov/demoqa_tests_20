package hw_10.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class model {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private AddressModel address;
    private List<String> pets;
    @JsonProperty("working")
    private boolean working;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public AddressModel getAddress() {
        return address;
    }

    public List<String> getPets() {
        return pets;
    }

    public boolean Working() {
        return working;
    }

    public static class AddressModel {
        private String street;
        private String city;
        private String state;
        private String zipcode;

        public String getStreet() {
            return street;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getZipcode() {
            return zipcode;
        }
    }

}
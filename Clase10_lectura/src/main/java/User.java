
import java.io.Serializable;
 
public class User implements Serializable {
 
    private static final long serialVersionUID = 1L;
     
    // User
    public static String ID = "id";
    public static String NAME = "name";
    public static String USERNAME = "username";
    public static String EMAIL = "email";
    public static String ADDRESS = "address";
    public static String PHONE = "phone";
    public static String WEBSITE = "website";
    public static String COMPANY = "company";
 
    // Address
    public static String STREET = "street";
    public static String SUITE = "suite";
    public static String CITY = "city";
    public static String ZIPCODE = "zipcode";
    public static String GEO = "geo";
 
    // Geo
    public static String LAT = "lat";
    public static String LNG = "lng";
 
    // Company
    public static String C_NAME = "name";
    public static String CATCHPHRASE = "catchPhrase";
    public static String BS = "bs";
 
    public int id;
 
    public String name;
 
    public String username;
 
    // @JsonProperty(value = "email")
    public String email;
 
    public Address_ address;
 
    public String phone;
 
    public String website;
 
    public Company company;
 
    public User(Address_ address, Company company) {
        super();
        this.address = address;
        this.company = company;
    }
 
    public User() {
    }
 
    public void setId(int i) {
        this.id = i;
    }
 
    public int getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public Address_ getAddress() {
        return address;
    }
 
    public void setAddress(Address_ address) {
        this.address = address;
    }
 
    public String getPhone() {
        return phone;
    }
 
    public void setPhone(String phone) {
        this.phone = phone;
    }
 
    public String getWebsite() {
        return website;
    }
 
    public void setWebsite(String website) {
        this.website = website;
    }
 
    public Company getCompany() {
        return company;
    }
 
    public void setCompany(Company company) {
        this.company = company;
    }
 
 
    public class Address_ {
 
        public String street;
 
        public String suite;
 
        public String city;
 
        public String zipcode;
 
        public Geo geo;
 
        public String getStreet() {
            return street;
        }
 
        public void setStreet(String street) {
            this.street = street;
        }
 
        public String getSuite() {
            return suite;
        }
 
        public void setSuite(String suite) {
            this.suite = suite;
        }
 
        public String getCity() {
            return city;
        }
 
        public void setCity(String city) {
            this.city = city;
        }
 
        public String getZipcode() {
            return zipcode;
        }
 
        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }
 
        public Geo getGeo() {
            return geo;
        }
 
        public void setGeo(Geo geo) {
            this.geo = geo;
        }
 
        @Override
        public String toString() {
            return "Address_ [getStreet()=" + getStreet() + ", getSuite()=" + getSuite() + ", getCity()=" + getCity()
                    + ", getZipcode()=" + getZipcode() + ", getGeo()=" + getGeo() + "]";
        }
 
    }
     
    public class Company {
 
        public String name;
        public String catchPhrase;
 
        public String bs;
 
        public String getName() {
            return name;
        }
 
        public void setName(String name) {
            this.name = name;
        }
 
        public String getCatchPhrase() {
            return catchPhrase;
        }
 
        public void setCatchPhrase(String catchPhrase) {
            this.catchPhrase = catchPhrase;
        }
 
        public String getBs() {
            return bs;
        }
 
        public void setBs(String bs) {
            this.bs = bs;
        }
 
        @Override
        public String toString() {
            return "Company [getName()=" + getName() + ", getCatchPhrase()=" + getCatchPhrase() + ", getBs()=" + getBs()
                    + "]";
        }
    }
 
    public class Geo {
 
        public String lat;
 
        public String lng;
 
        public String getLat() {
            return lat;
        }
 
        public void setLat(String string) {
            this.lat = string;
        }
 
        public String getLng() {
            return lng;
        }
 
        public void setLng(String lng) {
            this.lng = lng;
        }
 
    }

    @Override
    public String toString() {
        return "User [id=" + getId() + ", name=" + getName()
                + ", username=" + getUsername() + ", email=" + getEmail() + ", \naddress=" + getAddress()
                + ", phone=" + getPhone() + ", website=" + getWebsite() + ", \ncompany=" + getCompany()
                + "]";
    }
}
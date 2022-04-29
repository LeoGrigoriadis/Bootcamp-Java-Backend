import java.util.ArrayList;
import java.util.List;
 
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
 
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

	
	public static void main(String[] args) {
		 
        String URL_API = "https://jsonplaceholder.typicode.com/users";
        // Cliente para la conexión
        Client client = ClientBuilder.newClient();
        // Definición de URL
        WebTarget target = client.target(URL_API);
        // Recogemos el resultado en una variable String
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        // Escribimos por consola el resultado de json
        //System.out.println(response);
 
        //Almacenamos la información del json en una lista java
        ArrayList<User> listUser = saveJsonToList(response);
         
        //Llamada a procedimiento que imprime el registro buscado
        showUserByCity("Aliyaview", listUser);
    }
	
	private static void showUserByCity(String string, ArrayList<User> listUser) {
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getAddress().city.equalsIgnoreCase(string)){
                System.out.println("El usuario con ciudad " + string + " es: \n" + listUser.get(i));
            }
        }
         
    }
	
	private static ArrayList<User> saveJsonToList(String response) {
		 
        ArrayList<User> listUser = new ArrayList<User>();
         
        User user;
        User.Address_ address = null;
        User geo = null;
        User company = null;
         
        JSONObject jsonUser;
 
        JSONArray jsonarray = new JSONArray(response);
 
        for (int i = 0; i < jsonarray.length(); i++) {
 
            jsonUser = jsonarray.getJSONObject(i);
 
            user = new User();
            user.setId(jsonUser.getInt(User.ID));
            user.setName(jsonUser.getString(User.NAME));
            user.setUsername(jsonUser.getString(User.USERNAME));
            user.setEmail(jsonUser.getString(User.EMAIL));
            user.setPhone(jsonUser.getString(User.PHONE));
            user.setWebsite(jsonUser.getString(User.WEBSITE));
 
            if (jsonUser.get(User.ADDRESS) != null) {
                JSONObject jsonAddress = jsonUser.getJSONObject(User.ADDRESS);
                address = new User().new Address_();
                address.setStreet(jsonAddress.getString(User.STREET));
                address.setSuite(jsonAddress.getString(User.SUITE));
                address.setCity(jsonAddress.getString(User.CITY));
                address.setZipcode(jsonAddress.getString(User.ZIPCODE));
 
                if (jsonAddress.get(User.GEO) != null) {
                    JSONObject jsonGeo = jsonAddress.getJSONObject(User.GEO);
 
                    geo = new User().new Geo();
                    geo.setLat(jsonGeo.getString(User.LAT));
                    geo.setLng(jsonGeo.getString(User.LNG));
                    address.setGeo(geo);
                }
            }
 
            if (jsonUser.get(User.COMPANY) != null) {
                JSONObject jsonCompany = jsonUser.getJSONObject(User.COMPANY);
                company = new User().new Company();
                company.setName(jsonCompany.getString(User.C_NAME));
                company.setCatchPhrase(jsonCompany.getString(User.CATCHPHRASE));
                company.setBs(jsonCompany.getString(User.BS));
 
            }
 
            user.setAddress(address);
            user.setCompany(company);
 
            listUser.add(user);
        }
 
//      imprimirLista(listUser);
        return listUser;
    }
 
    private static void imprimirLista(List<User> listUser) {
        for (int i = 0; i < listUser.size(); i++) {
            System.out.println(listUser.get(i));
        }
 
    }
}

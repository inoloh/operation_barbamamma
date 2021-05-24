import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

public class ZooClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        /*Response response = client.target("http://localhost:8080/operation_barbapappa-1.0-SNAPSHOT-war/fantastic-world/animals/19").request().buildGet().invoke();
        System.out.println(response.readEntity(Animal.class));

        Animal animal = response.readEntity(Animal.class);
        System.out.println(animal);
        response.close();*/

        // get headers for animalId
        /*Response response = client.target("http://localhost:8080/operation_barbapappa-1.0-SNAPSHOT-war/fantastic-world/animals/21").request("application/JSON").buildGet().invoke();
        System.out.println(response.getHeaders().toString());
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
        response.close();*/

        // get headers for executing animals
        /*Response response = client.target("http://localhost:8080/operation_barbapappa-1.0-SNAPSHOT-war/fantastic-world/animals/execute/24")
                                  .request("application/JSON").delete();
        System.out.println(response.getHeaders().toString());
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
        response.close();*/
        /*System.out.println(response.readEntity(String.class));*/

        /*List<Animal> animals = response.readEntity(new GenericType<List<Animal>>() {});

        for (Animal a : animals) {
            System.out.println(a);
        }
        response.close();*/
        Response response = client.target("http://localhost:8080/operation_barbapappa-1.0-SNAPSHOT-war/fantastic-world/animals/22").request("application/JSON").buildGet().invoke();
        Animal animal = response.readEntity(Animal.class);
        Entity nigelEntity = Entity.entity(animal, "application/JSON");
        response.close();
        response = client.target("http://localhost:8080/operation_barbapappa-1.0-SNAPSHOT-war/fantastic-world/animals?animalid=22&status=SICK").request("application/JSON").buildPut(nigelEntity).invoke();
        response.close();

        // lägga till djur
        /*Animal lasse = new Animal("Lolita", 14, "Dog", HealthStatus.DEAD, "2012-05-21" );
        Entity lasseEntity = Entity.entity(lasse, "application/JSON");

        Response response = client.target("http://localhost:8080/operation_barbapappa-1.0-SNAPSHOT-war/fantastic-world/animals/freezer").request("application/JSON").buildPost(lasseEntity).invoke();*/
        /*System.out.println(response.readEntity(Animal.class).getId());*/
        /*response.close();*/

    }
}

import com.mongodb.client.*;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class MongoCRUDExample {
    public static void main(String[] args) {
        String uri = "mongodb://localhost:27017";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("testdb");
            MongoCollection<Document> collection = database.getCollection("users");

            // 1️ CREATE
            Document user = new Document("name", "John Doe")
                    .append("email", "john@example.com")
                    .append("age", 28);
            collection.insertOne(user);
            System.out.println("Inserted: " + user.toJson());

            // 2️ READ
            System.out.println("All users:");
            FindIterable<Document> users = collection.find();
            for (Document doc : users) {
                System.out.println(doc.toJson());
            }

            // 3️ UPDATE
            collection.updateOne(eq("name", "John Doe"), set("age", 30));
            System.out.println("Updated John's age to 30");

            // Read again to verify update
            Document updatedUser = collection.find(eq("name", "John Doe")).first();
            System.out.println("After update: " + updatedUser.toJson());

            // 4️ DELETE
            collection.deleteOne(eq("name", "John Doe"));
            System.out.println("Deleted user 'John Doe'");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
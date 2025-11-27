import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

public class MongoDBConnectionExample {
    public static void main(String[] args) {
        // 1. Connect to MongoDB
        String uri = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(uri)) {

            // 2. Access database
            MongoDatabase database = mongoClient.getDatabase("testdb");

            // 3. Access collection
            MongoCollection<Document> collection = database.getCollection("users");

            // 4. Insert a document
            Document doc = new Document("name", "Alice")
                    .append("email", "alice@example.com")
                    .append("age", 30);
            collection.insertOne(doc);
            System.out.println("Document inserted");

            // 5. Read documents
            FindIterable<Document> users = collection.find();
            System.out.println("Users in database:");
            for (Document user : users) {
                System.out.println(user.toJson());
            }

        } catch (Exception e) {
            System.err.println("MongoDB connection failed: " + e.getMessage());
        }
    }
}
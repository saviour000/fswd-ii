const mongoose = require("mongoose");

// Connect to MongoDB
mongoose
  .connect("mongodb://localhost:27017/mydb", {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })
  .then(() => console.log("Connected to MongoDB"))
  .catch((err) => console.error("Connection error:", err));

// Define schema
const userSchema = new mongoose.Schema({
  name: String,
  email: String,
  age: Number,
});

// Create model
const User = mongoose.model("User", userSchema);

// CRUD Operations
async function runCRUD() {
  // 1. CREATE
  const user = new User({
    name: "Alice",
    email: "alice@example.com",
    age: 24,
  });

  await user.save();
  console.log("User added:", user);

  // 2. READ
  const users = await User.find();
  console.log("Users in DB:", users);

  // 3. UPDATE
  const updatedUser = await User.findOneAndUpdate(
    { name: "Alice" },
    { age: 25 },
    { new: true }
  );
  console.log("User updated:", updatedUser);

  // 4. DELETE
  const deletedUser = await User.findOneAndDelete({ name: "Alice" });
  console.log("User deleted:", deletedUser);

  mongoose.connection.close();
}

runCRUD();

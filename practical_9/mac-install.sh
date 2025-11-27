# 1. Update Homebrew
brew update

# 2. Install MongoDB
brew tap mongodb/brew
brew install mongodb-community@6.0

# 3. Start MongoDB Service
brew services start mongodb-community@6.0

# 4. Verify Installation
mongosh   # Opens the MongoDB shell
# 1. Import MongoDB GPG Key
curl -fsSL https://pgp.mongodb.com/server-6.0.asc | \
sudo gpg -o /usr/share/keyrings/mongodb-server-6.0.gpg --dearmor

# 2. Add MongoDB Repository
echo "deb [ signed-by=/usr/share/keyrings/mongodb-server-6.0.gpg ] \
https://repo.mongodb.org/apt/ubuntu jammy/mongodb-org/6.0 multiverse" | \
sudo tee /etc/apt/sources.list.d/mongodb-org-6.0.list

# 3. Update & Install
sudo apt update
sudo apt install -y mongodb-org

# 4. Start MongoDB
sudo systemctl start mongod
sudo systemctl enable mongod

# 5. Check Status
sudo systemctl status mongod
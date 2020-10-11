###Steps:
1. [Install Couchbase](https://docs.couchbase.com/server/current/install/install-intro.html)
2. After installation, you can start from Applications, and will be available at:

http://127.0.0.1:8091/ui/index.html

Now, create a cluster with credentials: 

Cluster name: tacosvc

Password: tacosvc

Once you get into cluster, add user, which will be used in `ReactiveCouchbaseConfig.java` to configure the connection, as:

username: tacoadmin

password: password

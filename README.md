# Client Server Application for Flower Shop

### Overview

This repository contains a full stack application designed for a flower shop. The application is built using JavaFX for the client-side, Java for the backend, and MySQL for database management. The application supports a variety of features including product management, order processing, and user authentication.

## Features

- **Product Management**: Add, update, and delete products.
- **Order Processing**: Place and track orders.
- **User Authentication**: Secure login and registration for users.
- **Client-Server Communication**: Robust communication between the client and server.
- **Database Management**: Efficient data storage and retrieval using MySQL.

## Prerequisites

- **Java Development Kit (JDK) 11 or higher**
- **JavaFX SDK**
- **MySQL Server**
- **Maven** (for dependency management)
# How to supply arguments while running with Maven?
When configuring the `Maven Build...` target, Add a parameter with the name `exec.args`(or `-Dexec.args` in Intellij IDE) and the arguments you want as a value.

# Running the client
Simply run the goal ``exec:java@client`` with two arguments: the host and the port.

# Running the server
Run the goal ``exec:java@server`` with one argument: the port to listen to.

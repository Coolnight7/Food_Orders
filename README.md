## Food Ordering System

## Introduction

The **Food Ordering System** is a Java-based mini project that allows users to register customers, manage menu items, and place/view orders. It uses Hibernate (JPA-style) for ORM and connects to a PostgreSQL database. Designed as a console application, it's ideal for learning Hibernate with real-world database interaction.

---

## Features

- Customer registration
- Add and manage menu items
- Place new food orders
- View orders by customer
- Hibernate handles all persistence
- Tables are auto-generated on first run

---

## Technologies Used

- Java
- Hibernate ORM (JPA-style API)
- PostgreSQL
- Maven (for build and dependency management)

---

## Prerequisite

Before running the project, ensure the following:

- Java JDK 17 or higher
- PostgreSQL installed and running (default port 5432)
- Maven installed (optional if compiling manually)
- A database for creating tables is created in PostgreSQL

##  Dependencies

Added via `pom.xml`:

```xml
<dependencies>
  <dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.2</version>
  </dependency>

  <dependency>
      <groupId>org.hibernate.orm</groupId>
      <artifactId>hibernate-core</artifactId>
      <version>7.0.6.Final</version>
    </dependency>

    <dependency>
      <groupId>jakarta.persistence</groupId>
      <artifactId>jakarta.persistence-api</artifactId>
      <version>3.2.0</version>
    </dependency>
</dependencies>
```
---
## Persistence.xml
```xml
<properties>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/orders"/>
            <property name="jakarta.persistence.jdbc.user" value="postgres"/>
            <property name="jakarta.persistence.jdbc.password" value="park_7jimin"/>
            <property name="jakarta.persistence.jdbc.driver" value="org.postgresql.Driver"/>

            <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
</properties>

```
## Output
Console based menu output:<img width="822" height="478" alt="mini-proj2" src="https://github.com/user-attachments/assets/7ce5e7e3-2953-492f-90c1-7d3479d64ce4" />

---
## Contact

Hope you liked the Simple Mini Project , for any questions , modifications or feedback:

  - Name : Amina Subhedar
  - Email: aminasubhedar2022@gmail.com
  - Github: https://github.com/Coolnight7

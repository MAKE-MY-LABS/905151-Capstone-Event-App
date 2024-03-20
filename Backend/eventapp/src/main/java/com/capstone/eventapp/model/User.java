package com.capstone.eventapp.model;

/*
 * create a model class for the user with following fields: userName, password, emailId, mobileNumber
 * using lambok @Getter @Setter annotation to generate getters and setters
 * use @Document annotation to specify the collection name in the database
 * use @NoArgsConstructor and @AllArgsConstructor to generate default and parameterized constructors
 */
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a user in the system.
 */
/**
 * Represents a user in the system.
 */
@Document(collection = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String emailId;
    private String userName;
    private String password;
    private String mobileNumber;
}

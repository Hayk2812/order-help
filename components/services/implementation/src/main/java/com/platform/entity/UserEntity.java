package com.platform.entity;

import com.platform.constants.DataBaseConstants;
import com.platform.constants.RoutConstants;
import com.platform.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = DataBaseConstants.USER_TABLE, schema = DataBaseConstants.SCHEMA)


public class UserEntity {
    @Id
    @Column(name = "user_id")
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private UUID userId;
    @Column(name = "first_name")
    private String name;
    @Column(name = "last name")
    private String surname;
    private String email;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    @RestResource(path = "userAddress", rel = "addressEntity")
    private AddressEntity addressEntity;


    public User toUser() {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword(password);
        user.setAddress(addressEntity.toAddress());
        return user;
    }


    public UserEntity(User user) {
        userId = user.getUserId();
        name = user.getName();
        surname = user.getSurname();
        email = user.getEmail();
        password = user.getPassword();
        addressEntity = new AddressEntity(user.getAddress());

    }
}

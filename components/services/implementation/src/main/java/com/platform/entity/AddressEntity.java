package com.platform.entity;

import com.platform.constants.DataBaseConstants;
import com.platform.model.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = DataBaseConstants.ADDRESS_TABLE, schema = DataBaseConstants.SCHEMA)
public class AddressEntity {
    @Id
    @Column(name = "address_id")
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private UUID addressId;
    private String country;
    private String city;
    private String street;

    @OneToOne(mappedBy = "addressEntity")
    private UserEntity userEntity;




    public Address toAddress() {
        return new Address(addressId, country, city, street);
    }


    public AddressEntity(Address address) {
        addressId = address.getAddressId();
        country = address.getCountry();
        city = address.getCity();
        street = address.getStreet();
    }
}

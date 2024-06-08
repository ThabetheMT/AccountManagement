package org.unclecodes.int_tutorial1.accountholder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountHolder {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Transient
    private char gender;
    private int age;
    private Date dateOfBirth;
    private boolean maritalStatus;
}

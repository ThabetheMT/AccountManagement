package org.unclecodes.int_tutorial1.admin;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admin {

    @Id
    private String id;
    private String firstName;
    private String lastName;
}

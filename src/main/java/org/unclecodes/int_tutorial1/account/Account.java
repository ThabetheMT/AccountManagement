package org.unclecodes.int_tutorial1.account;

import jakarta.persistence.*;
import lombok.*;
import org.unclecodes.int_tutorial1.accountholder.AccountHolder;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    private String accountNumber;
    private String accountType;
    private double balance;
    private Date creationDate;
    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST
    )
    @JoinColumn(
            referencedColumnName = "id"
    )
    private AccountHolder accountHolder;
}

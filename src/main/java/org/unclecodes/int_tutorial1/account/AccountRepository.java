package org.unclecodes.int_tutorial1.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    List<Account> findByBalance(double balance);
    Account findByAccountHolderId(String id);
}

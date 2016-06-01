
package edu.spcollege.ecox.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author atillman
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findOneByEmail(String email);
}
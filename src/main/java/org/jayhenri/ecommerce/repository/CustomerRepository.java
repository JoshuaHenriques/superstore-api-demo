package org.jayhenri.ecommerce.repository;

import org.jayhenri.ecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

/**
 * The interface Customer repository.
 */
@Transactional
@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    /**
     * Exists by phone number boolean.
     *
     * @param phoneNumber the phone number
     * @return the boolean
     */
    @Query("select case when count(c)> 0 then true else false end from Customer c where lower(c.phoneNumber) like lower(:phoneNumber)")
    boolean existsByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    /**
     * Exists by email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    @Query("select case when count(c)> 0 then true else false end from Customer c where lower(c.email) like lower(:email)")
    boolean existsByEmail(@Param("email") String email);

    /**
     * Gets by email.
     *
     * @param email the email
     * @return the by email
     */
    @Query(value = "SELECT * FROM customers WHERE customers.email=:email", nativeQuery = true)
    Customer getByEmail(@Param("email") String email);
}

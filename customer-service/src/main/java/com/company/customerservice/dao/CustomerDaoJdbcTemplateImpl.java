package com.company.customerservice.dao;

import com.company.customerservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * a customer jdbc template class that implements the customerDao and
 *  uses prepared statements
 */
@Repository
public class CustomerDaoJdbcTemplateImpl implements CustomerDao {

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_CUSTOMER_SQL = "Insert into customer (first_name, last_name, street, city, zip, email, phone) values (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_CUSTOMER_SQL = "select * from customer where customer_id = ?";
    private static final String SELECT_ALL_CUSTOMERS_SQL = "select * from customer";
    private static final String UPDATE_AUTHOR_SQL = "update customer set first_name = ?, last_name = ?, city = ?, street = ?, phone = ?, zip = ? ,email = ? where customer_id = ?";
    private static final String DELETE_AUTHOR_SQL = "delete from customer where customer_id = ?";

    @Autowired
    public CustomerDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        jdbcTemplate.update(
                INSERT_CUSTOMER_SQL,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getStreet(),
                customer.getCity(),
                customer.getZip(),
                customer.getEmail(),
                customer.getPhone()

        );
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        customer.setCustomerId(id);
        return customer;
    }

    @Override
    public Customer getCustomer(int customerId) {
        try{
            return jdbcTemplate.queryForObject(SELECT_CUSTOMER_SQL, this::mapRowToCustomer, customerId);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
    return jdbcTemplate.query(SELECT_ALL_CUSTOMERS_SQL, this::mapRowToCustomer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        jdbcTemplate.update(
                UPDATE_AUTHOR_SQL,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getCity(),
                customer.getStreet(),
                customer.getPhone(),
                customer.getZip(),
                customer.getEmail(),
                customer.getCustomerId());

    }

    @Override
    public void deleteCustomer(int customerId) {
    jdbcTemplate.update(DELETE_AUTHOR_SQL, customerId);
    }

    private Customer mapRowToCustomer(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerId(rs.getInt("customer_id"));
        customer.setZip(rs.getString("zip"));
        customer.setStreet(rs.getString("street"));
        customer.setPhone(rs.getString("phone"));
        customer.setEmail(rs.getString("email"));
        customer.setCity(rs.getString("city"));
        customer.setLastName(rs.getString("last_name"));
        customer.setFirstName(rs.getString("first_name"));

        return customer;
    }
}

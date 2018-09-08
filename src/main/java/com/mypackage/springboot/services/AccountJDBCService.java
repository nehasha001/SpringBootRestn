package com.mypackage.springboot.services;

import com.mypackage.springboot.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class AccountJDBCService {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public AccountJDBCService(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Account> getAllAccounts() {


        return jdbcTemplate.query("select * from accountsdata", new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                return getAccountMapper(resultSet);
            }
        });
    }

    public Account getAccountMapper(ResultSet resultSet) {

        Account account = new Account();
        try {
            account.setAccountNumber(resultSet.getInt("accountnumber"));
            account.setAccountDescription(resultSet.getString("accountdescription"));
            account.setAccountType(resultSet.getString("accounttype"));
            account.setAmount(resultSet.getInt("amount"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }

    public Account createAccount(Account account) {
        KeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement =
                        connection.prepareStatement("insert into accountsdata(amount, accounttype, accountdescription) values (?,?,?)"
                                , new String[] {"accountnumber"});
                preparedStatement.setLong(1, account.getAmount());
                preparedStatement.setString(2, account.getAccountType());
                preparedStatement.setString(3, account.getAccountDescription());

                return preparedStatement;
            }
        }, holder);

        account.setAccountNumber(holder.getKey().intValue());
        return account;

    }

    public void deleteAccount(int accountNumber) {
        jdbcTemplate.update("DELETE from accountsdata where accountnumber = ?", accountNumber);


    }
}


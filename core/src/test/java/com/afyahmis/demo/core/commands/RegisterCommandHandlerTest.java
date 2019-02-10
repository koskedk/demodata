package com.afyahmis.demo.core.commands;

import com.afyahmis.demo.core.interfaces.DbConnection;
import com.afyahmis.demo.core.interfaces.PracticeRepository;
import com.afyahmis.demo.core.model.LiveResponse;
import com.afyahmis.demo.core.model.Practice;
import com.afyahmis.demo.data.MysqlConnection;
import com.afyahmis.demo.data.PracticeJdbcRepository;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class RegisterCommandHandlerTest {

    private PracticeRepository repository;
    private DbConnection connection;
    private Practice demoPractice;
    private Faker faker = new Faker();
    private RegisterCommandHandler registerCommandHandler;

    @Before
    public void setUp() throws Exception {
        connection= MysqlConnection.getInstance();
        repository=new PracticeJdbcRepository(connection);
        registerCommandHandler=new RegisterCommandHandler(repository);

        demoPractice =new Practice(new Date().getTime(),  faker.name().firstName());
        repository.create(demoPractice);
    }

    @Test
    public void handle_success() {
        long code=new Date().getTime();
        LiveResponse response=registerCommandHandler.Handle(new RegisterCommand(code,"Barca"));
        Assert.assertTrue(response.equals(LiveResponse.SUCCESS));
    }


    @Test
    public void handle_fail() {
        long code=new Date().getTime();
        LiveResponse response=registerCommandHandler.Handle(new RegisterCommand(demoPractice.getCode(),"Barca"));
        Assert.assertTrue(response.equals(LiveResponse.FAIL));
    }

    @After
    public void tearDown() throws Exception {
        repository.execute("delete from practices");
    }
}
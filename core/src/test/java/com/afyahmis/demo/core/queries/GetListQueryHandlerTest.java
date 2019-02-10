package com.afyahmis.demo.core.queries;

import com.afyahmis.demo.core.interfaces.DbConnection;
import com.afyahmis.demo.core.interfaces.PracticeRepository;
import com.afyahmis.demo.core.model.Practice;
import com.afyahmis.demo.data.MysqlConnection;
import com.afyahmis.demo.data.PracticeJdbcRepository;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class GetListQueryHandlerTest {

    private PracticeRepository repository;
    private DbConnection connection;
    private Practice demoPractice,demoPractice2;
    private Faker faker = new Faker();
    private GetListQueryHandler getListQueryHandler;

    @Before
    public void setUp() throws Exception {
        connection= MysqlConnection.getInstance();
        repository=new PracticeJdbcRepository(connection);
        getListQueryHandler =new GetListQueryHandler(repository);

        demoPractice =new Practice(new Date().getTime(),  faker.name().firstName());
        demoPractice2 =new Practice(new Date().getTime()+2,  faker.name().firstName());
        repository.create(demoPractice);
        repository.create(demoPractice2);
    }

    @Test
    public void handle() {
        List<Practice> practices=getListQueryHandler.Handle(new GetListQuery());
        Assert.assertTrue(practices.size()>0);
        practices.forEach(System.out::println);
    }

    @After
    public void tearDown() throws Exception {
        repository.execute("delete from practices");
    }
}
package com.afyahmis.demo.data;

import com.afyahmis.demo.core.interfaces.DbConnection;
import com.afyahmis.demo.core.interfaces.PracticeRepository;
import com.afyahmis.demo.core.model.Practice;
import com.github.javafaker.Faker;
import com.sun.tools.javac.jvm.Code;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class PracticeJdbcRepositoryTest {

    private PracticeRepository repository;
    private DbConnection connection;
    private Practice demoPractice;
    Faker faker = new Faker();

    @Before
    public void setUp() throws Exception {
        connection=MysqlConnection.getInstance();
        repository=new PracticeJdbcRepository(connection);

        demoPractice =new Practice(new Date().getTime(),  faker.name().firstName());
        repository.create(demoPractice);
    }

    @Test
    public void create() throws Exception {
        Practice practice=new Practice(new Date().getTime(),  faker.name().firstName());
        repository.create(practice);

        Practice savedPractice=repository.get(practice.getCode());
        Assert.assertNotNull(savedPractice);
        System.out.println(savedPractice);
    }

    @Test
    public void update() throws Exception {
        demoPractice.changeName("maun");
        repository.update(demoPractice);

        Practice saved=repository.get(demoPractice.getCode());
        Assert.assertEquals("maun",saved.getName());
        System.out.println(saved);
    }

    @Test
    public void delete() throws Exception {
        repository.delete(demoPractice.getCode());

        Practice saved=repository.get(demoPractice.getCode());
        Assert.assertNull(saved);
    }

    @Test
    public void get() throws Exception {
        Practice saved=repository.get(demoPractice.getCode());
        Assert.assertNotNull(saved);
        System.out.println(saved);
    }

    @Test
    public void getAll() throws Exception {
        List<Practice> saved=repository.getAll();
        Assert.assertTrue(saved.size()>0);
        saved.forEach(System.out::println);
    }

    @Test
    public void execute() throws Exception {
        long code = new Date().getTime();
        repository.execute("insert into practices(code,name) values(" + code + ",'execdemo')");

        Practice saved=repository.get(code);
        Assert.assertNotNull(saved);
        Assert.assertEquals("execdemo",saved.getName());
        System.out.println(saved);
    }

    @After
    public void tearDown() throws Exception {
        repository.execute("delete from practices");
    }
}
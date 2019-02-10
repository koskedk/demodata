package com.afyahmis.demo.app;

import com.afyahmis.demo.core.commands.RegisterCommand;
import com.afyahmis.demo.core.commands.RegisterCommandHandler;
import com.afyahmis.demo.core.interfaces.DbConnection;
import com.afyahmis.demo.core.interfaces.PracticeRepository;
import com.afyahmis.demo.core.model.Practice;
import com.afyahmis.demo.core.queries.GetListQuery;
import com.afyahmis.demo.core.queries.GetListQueryHandler;
import com.afyahmis.demo.data.MysqlConnection;
import com.afyahmis.demo.data.PracticeJdbcRepository;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;

public class Program {
    private static DbConnection dbConnection;
    private static PracticeRepository repository;
    private static RegisterCommandHandler registerCommandHandler;
    private static GetListQueryHandler getListQueryHandler;

    public static void main(String[] args) {
        init();
        addPrac();
        printPrac();
    }
    private static void init(){
        dbConnection= MysqlConnection.getInstance();
        repository=new PracticeJdbcRepository(dbConnection);
        registerCommandHandler=new RegisterCommandHandler(repository);
        getListQueryHandler=new GetListQueryHandler(repository);
    }
    private static void addPrac(){
        registerCommandHandler.Handle(new RegisterCommand(new Date().getTime(),"Maun"));
        registerCommandHandler.Handle(new RegisterCommand(new Date().getTime(),"Demo"));
    }
    private static void printPrac(){
        List<Practice> practices=getListQueryHandler.Handle(new GetListQuery());
        practices.forEach(System.out::println);
    }
}

package com.afyahmis.demo.core.interfaces;

public interface IQueryHandler<TQuery extends IQuery,TResult> {
    TResult Handle(TQuery query);
}

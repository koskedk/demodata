package com.afyahmis.demo.core.interfaces;

public interface ICommandHandler<TCommand extends ICommand,TResponse> {
    TResponse Handle(TCommand command);
}

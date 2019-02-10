package com.afyahmis.demo.core.commands;

import com.afyahmis.demo.core.interfaces.ICommandHandler;
import com.afyahmis.demo.core.interfaces.PracticeRepository;
import com.afyahmis.demo.core.model.LiveResponse;
import com.afyahmis.demo.core.model.Practice;

public class RegisterCommandHandler implements ICommandHandler<RegisterCommand, LiveResponse> {

    private final PracticeRepository practiceRepository;

    public RegisterCommandHandler(PracticeRepository practiceRepository) {
        this.practiceRepository = practiceRepository;
    }

    @Override
    public LiveResponse Handle(RegisterCommand command) {
        try {
            practiceRepository.create(new Practice(command.getCode(),command.getName()));
            return LiveResponse.SUCCESS;
        }catch (Exception ex){

        }
        return LiveResponse.FAIL;
    }
}

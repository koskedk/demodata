package com.afyahmis.demo.core.queries;

import com.afyahmis.demo.core.interfaces.IQuery;
import com.afyahmis.demo.core.interfaces.IQueryHandler;
import com.afyahmis.demo.core.interfaces.PracticeRepository;
import com.afyahmis.demo.core.model.Practice;

import java.util.ArrayList;
import java.util.List;

public class GetListQueryHandler implements IQueryHandler<GetListQuery, List<Practice>> {

    private final PracticeRepository practiceRepository;

    public GetListQueryHandler(PracticeRepository practiceRepository) {
        this.practiceRepository = practiceRepository;
    }

    @Override
    public List<Practice> Handle(GetListQuery query) {
        try {
            return practiceRepository.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}

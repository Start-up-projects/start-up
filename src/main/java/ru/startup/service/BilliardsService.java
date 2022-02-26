package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.BilliardsDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.model.entertainment.Billiards;
import ru.startup.repository.BilliardsRepository;

@Service
public class BilliardsService {

    private BilliardsRepository billiardsRepository;

    private EntertainmentMapper entertainmentMapper;

    @Autowired
    public void setBilliardsRepository(BilliardsRepository billiardsRepository) {
        this.billiardsRepository = billiardsRepository;
    }

    @Autowired
    public void setEntertainmentMapper(EntertainmentMapper entertainmentMapper) {
        this.entertainmentMapper = entertainmentMapper;
    }

    public BilliardsDTO getBilliardsById(Long id) {
        return entertainmentMapper.map(billiardsRepository.getById(id), BilliardsDTO.class);
    }

    public void deleteBilliardsById(Long id) {
        Billiards billiards = billiardsRepository.getById(id);
        billiards.setDeleted(true);
        billiardsRepository.save(billiards);
    }
}
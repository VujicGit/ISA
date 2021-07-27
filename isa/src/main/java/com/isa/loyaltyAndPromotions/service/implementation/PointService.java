package com.isa.loyaltyAndPromotions.service.implementation;

import com.isa.loyaltyAndPromotions.domain.Point;
import com.isa.loyaltyAndPromotions.repository.PointRepository;
import com.isa.loyaltyAndPromotions.service.interfaces.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointService implements IPointService {

    private final PointRepository pointRepository;

    @Autowired
    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @Override
    public Point save(Point point) {
        return pointRepository.save(point);
    }
}

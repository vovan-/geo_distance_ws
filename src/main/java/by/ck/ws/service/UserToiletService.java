package by.ck.ws.service;

import by.ck.ws.ClosestToiletDto;
import by.ck.ws.model.GeoPoint;
import by.ck.ws.model.Toilet;
import by.ck.ws.repo.ToiletRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserToiletService {
    private ToiletRepo toiletRepo;
    private DistanceService distanceService;

    public ClosestToiletDto getClosestToilet(GeoPoint point) {
        List<Toilet> toilets = toiletRepo.getToilets();
        Integer minDistance = Integer.MAX_VALUE;
        Toilet closestToilet = null;
        for (Toilet toilet : toilets) {
            Integer distance = distanceService.getDistance(point, toilet.getPoint());
            if (distance < minDistance) {
                closestToilet = toilet;
                minDistance = distance;
            }
        }
        return new ClosestToiletDto(closestToilet, "", minDistance);
    }
}

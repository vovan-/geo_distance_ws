package by.ck.ws.service;

import by.ck.ws.model.GeoPoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

@Slf4j
@Service
public class DistanceService {
    public Integer getDistance(GeoPoint firstPoint, GeoPoint secondPoint) {
        double powOfXs = pow(secondPoint.getX() - firstPoint.getX(), 2);
        double powOfYs = pow(secondPoint.getY() - firstPoint.getY(), 2);
        return Double.valueOf(sqrt(powOfXs + powOfYs)).intValue();
    }
}

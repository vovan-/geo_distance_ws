package by.ck.ws.service;

import by.ck.ws.model.GeoPoint;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;


class DistanceServiceTest {
    @Test
    public void shouldReturnCorrectDistanceBetweenPoints() {
        // Given
        DistanceService distanceService = new DistanceService();
        GeoPoint firstPoint = new GeoPoint(1, 0);
        GeoPoint secondPoint = new GeoPoint(0, 0);

        // When
        Integer distance = distanceService.getDistance(firstPoint, secondPoint);

        // Then
        assertEquals("Should return the expected distance", distance, 1);
    }
}
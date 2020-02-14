package by.ck.ws.service;

import by.ck.ws.ClosestToiletDto;
import by.ck.ws.model.GeoPoint;
import by.ck.ws.model.Toilet;
import by.ck.ws.repo.ToiletRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.springframework.test.util.AssertionErrors.assertEquals;

class UserToiletServiceTest {
    private DistanceService mockDistanceService;
    private ToiletRepo mockToiletRepo;
    private GeoPoint userPoint;

    @BeforeEach
    void setUp() {
        mockDistanceService = mock(DistanceService.class);
        mockToiletRepo = mock(ToiletRepo.class);
        userPoint = new GeoPoint(0, 0);
    }

    @Test
    public void shouldDelegateToDistanceServiceForDistanceCalculation() {
        // Given
        GeoPoint expectedClosestPoint = new GeoPoint(1, 0);
        Toilet expectedClosestToilet = Toilet.builder().point(expectedClosestPoint).open(true).build();
        GeoPoint thirdPoint = new GeoPoint(1, 211);
        GeoPoint secondPoint = new GeoPoint(29, 23);
        List<Toilet> data = List.of(expectedClosestToilet,
                Toilet.builder().point(thirdPoint).open(false).build(),
                Toilet.builder().point(secondPoint).open(true).build());
        UserToiletService userToiletService = new UserToiletService(mockToiletRepo, mockDistanceService);
        doReturn(data).when(mockToiletRepo).getToilets();
        doReturn(1).when(mockDistanceService).getDistance(eq(userPoint), eq(expectedClosestPoint));
        doReturn(2).when(mockDistanceService).getDistance(eq(userPoint), eq(secondPoint));
        doReturn(3).when(mockDistanceService).getDistance(eq(userPoint), eq(thirdPoint));

        // When
        ClosestToiletDto closestToilet = userToiletService.getClosestToilet(userPoint);

        // Then
        assertEquals("Should be the expected toilet", expectedClosestToilet,  closestToilet.getToilet());
    }

}
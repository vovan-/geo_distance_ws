package by.ck.ws.repo;

import by.ck.ws.model.GeoPoint;
import by.ck.ws.model.Toilet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HardCodedToiletRepo implements ToiletRepo {
    private final List<Toilet> data;

    public HardCodedToiletRepo() {
        List<Toilet> data = List.of(buildAToilet(11, 26, true),
                buildAToilet(1, 211, false),
                buildAToilet(29, 23, true),
                buildAToilet(19, 2, false));
        this.data = data;
    }

    public static Toilet buildAToilet(int i, int i2, boolean b) {
        return Toilet.builder().point(new GeoPoint(i, i2)).open(b).build();
    }

    @Override
    public List<Toilet> getToilets() {
        return data;
    }
}

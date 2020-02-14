package by.ck.ws.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Toilet {
    private GeoPoint point;
    private boolean open;
}

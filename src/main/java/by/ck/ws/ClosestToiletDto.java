package by.ck.ws;

import by.ck.ws.model.Toilet;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClosestToiletDto {
    Toilet toilet;
    String message;
    Integer distance;
}

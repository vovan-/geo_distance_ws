package by.ck.ws;

import by.ck.ws.model.GeoPoint;
import by.ck.ws.service.UserToiletService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/toilet")
@AllArgsConstructor
public class ToiletEndPoint {
    private UserToiletService userToiletService;

    @GetMapping("/closest")
    public ResponseEntity<ClosestToiletDto> findClosestToilet(@RequestParam(name = "x", required = true) Integer x,
                                                              @RequestParam(name = "y", required = true) Integer y,
                                                              @RequestParam(name = "user", required = true) String user) {
        ClosestToiletDto closestToilet = userToiletService.getClosestToilet(new GeoPoint(x, y));
        closestToilet.setMessage(String.format("The nearest toilet for user %s", user));
        return ResponseEntity.ok(closestToilet);
    }
}

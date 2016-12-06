package campaign.controller;

import campaign.model.Bid;
import campaign.reader.BidCSVReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

@RestController
public class BidController {

    @GetMapping(value = "/bids", produces = "application/json")
    public @ResponseBody
    List<Bid> bids() {
        Calendar cal = Calendar.getInstance();
        int minutes = cal.get(Calendar.MINUTE);
        int fileNumber;
        if(minutes % 3 == 0) {
            fileNumber = 3;
        }
        else if(minutes % 2 == 0) {
            fileNumber = 2;
        }
        else {
            fileNumber = 1;
        }

        return BidCSVReader.getBids("minute_" + fileNumber + ".csv");
    }
}

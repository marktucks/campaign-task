package campaign.reader;

import campaign.model.Bid;
import campaign.model.Campaign;

import java.util.*;

public class BidCSVReader extends CSVReader {

    public static List<Bid> getBids(String file) {
        List<Bid> bids = new LinkedList<>();
        List<Campaign> campaigns = CampaignCSVReader.getCampaigns();
        List<Integer> campaignIds = new ArrayList<>();

        for(String[] strings : read(file)) {
            int campaignId = Integer.parseInt(strings[0]);

            if(!campaignIds.contains(campaignId)) {
                float winningPrice = Float.parseFloat(strings[1]);
                String currency = strings[2];

                Bid bid = new Bid(winningPrice, currency);

                for (Campaign campaign : campaigns) {
                    if (campaign.getId() == campaignId) {
                        bid.setCampaign(campaign);
                        break;
                    }
                }

                bids.add(bid);

                campaignIds.add(campaignId);
            }
        }

        return bids;
    }
}


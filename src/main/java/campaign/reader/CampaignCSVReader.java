package campaign.reader;

import campaign.model.Campaign;

import java.util.LinkedList;
import java.util.List;

public class CampaignCSVReader extends CSVReader {

    public static List<Campaign> getCampaigns() {
        List<Campaign> campaigns = new LinkedList<>();

        for (String[] strings : read("campaign_idx.csv")) {
            int id = Integer.parseInt(strings[0]);
            String name = strings[1];

            Campaign campaign = new Campaign(id, name);
            campaigns.add(campaign);
        }

        return campaigns;
    }
}
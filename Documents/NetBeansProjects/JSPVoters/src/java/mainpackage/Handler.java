package mainpackage;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeSet;

public class Handler extends DefaultHandler {

    private static SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    private HashMap<Integer, WorkTime> voteStationWorkTimes = new HashMap<>();
    private TreeSet<String> dni = new TreeSet<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws org.xml.sax.SAXException {
        if (qName.equals("visit")) {
            Integer station = Integer.parseInt(attributes.getValue("station"));
            Date time = null;
            try {
                time = visitDateFormat.parse(attributes.getValue("time"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            WorkTime workTime = voteStationWorkTimes.get(station);
            if (workTime == null) {
                workTime = new WorkTime();
                voteStationWorkTimes.put(station, workTime);
            }
            workTime.addVisitTime(time.getTime());
        }
    }

    public HashMap<Integer, OneTime> results() {
        HashMap<Integer, OneTime> stationDays = new HashMap<>();

        for (Integer votingStation : voteStationWorkTimes.keySet()) {
            WorkTime workTime = voteStationWorkTimes.get(votingStation);
            String[] times = workTime.toString().split(", ");
            OneTime dayN = new OneTime();
            for (int i = 0; i < times.length; i++) {
                String[] dayMark = times[i].split(" ");
                dayN.addTime(dayMark[0], dayMark[1]);
                dni.add(dayMark[0]);
            }
            stationDays.put(votingStation, dayN);
        }
        return stationDays;
    }

    public TreeSet<String> getDni() {
        return dni;
    }
}

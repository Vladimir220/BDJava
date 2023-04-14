package bdjava.lab4;

import java.util.*;

import static java.lang.System.out;

public class Program2 {

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 25);
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        calendar.set(Calendar.MINUTE, 42);
        calendar.set(Calendar.SECOND, 12);

        PublicTransportInformationService serv = new PublicTransportInformationService();
        PublicTransportInformationService.Transport bus = serv.new Transport("OP344TT322", "bus");
        bus.setCost(100);
        bus.setRouteLineId(16);
        bus.addToSchedule("London", calendar);
        out.println(bus);
    }
}

class PublicTransportInformationService {
    class Transport {
        private final String num;
        private final String type;
        private HashMap <String, Calendar> schedule;
        private int routeLineId;
        private  int cost;
        Transport (String num, String type) {
            this.num = num;
            this.type = type;
            schedule = new HashMap<String, Calendar>();
        }
        public int getCost() {
            return cost;
        }
        public void setCost(int cost) {
            this.cost = cost;
        }
        public int getRouteLineId() {
            return routeLineId;
        }
        public void setRouteLineId(int routeLineId) {
            this.routeLineId = routeLineId;
        }
        public String getNum() {
            return num;
        }
        public String getType() {
            return type;
        }
        public HashMap<String, Calendar> getSchedule() {
            return schedule;
        }
        public void addToSchedule(String halt, Calendar time) {
            this.schedule.put(halt, time);
        }
        public void setSchedule(HashMap<String, Calendar> schedule) {
            this.schedule = schedule;
        }

        @Override
        public String toString() {
            StringBuilder buf = new StringBuilder("Transport{" +
                    "num='" + num + '\'' +
                    ", type='" + type + '\'' +
                    ", schedule=(\n");
            for (String key : schedule.keySet())
                buf.append("<" + key + " : " + schedule.get(key).getTime() + ">\n");
            buf.append(")\n" +
                    ", routeLineId=" + routeLineId +
                    ", cost=" + cost +
                    '}');
            return buf.toString();
        }
    }
}

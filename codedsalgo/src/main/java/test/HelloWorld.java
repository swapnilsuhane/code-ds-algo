package test;

import java.util.*;

public class HelloWorld {

    public static void test(int i) {
        switch (i) {
            case 10:
                System.out.println("das");
            case 20:
                System.out.println("bees");
                break;
        }
    }

    public static long siteIdHash(String siteId) {
        Map<String, Long> map = new HashMap<>();
        map.put("SG", 0L);
        map.put("MY", 1L);
        map.put("TH", 2L);
        map.put("ID", 3L);
        map.put("PH", 4L);
        map.put("VN", 5L);
        map.put("PK", 6L);
        map.put("MM", 6L);
        map.put("BD", 7L);
        map.put("LK", 7L);


        return map.get(siteId);
    }

    //[Long func(String siteId){
    //    def map = [SG:0, MY:1]
    //    return map.get(siteId);
    //}
    //func(#site_id#)]
    ////
    //    [Long func(String siteId){         Map<String, Long> map = new HashMap<>();        map.put("SG", 0L);        map.put("MY", 1L);        map.put("TH", 2L);        map.put("ID", 3L);        map.put("PH", 4L);        map.put("VN", 5L);        map.put("PK", 6L);        map.put("BD", 6L);        map.put("MM", 7L);        map.put("LK", 7L);        return map.get(siteId);    }     func(#site_id#)]
    //
    //    [Long func(String siteId){        Map<String, Long> map = new HashMap<>();        map.put("SG", 0L);        map.put("MY", 1L);        map.put("TH", 2L);        map.put("ID", 3L);        map.put("PH", 4L);        map.put("VN", 5L);        map.put("PK", 6L);        map.put("BD", 6L);        map.put("MM", 7L);        map.put("LK", 7L);        return map.get(siteId);    }    func(#site_id#)]
    //
    //    [Long func(String siteId){        Map<String, Long> map = new HashMap<>();        map.put("SG", 0L);        map.put("MY", 1L);        map.put("TH", 2L);        map.put("ID", 3L);        map.put("PH", 4L);        map.put("VN", 5L);        map.put("PK", 6L);        map.put("BD", 6L);        map.put("MM", 7L);        map.put("LK", 7L);        return map.get(siteId);    }    func(#site_id#)]

    // Complete the taumBday function below.
    static long taumBday(int b, int w, int bc, int wc, int z) {
        long bcn = bc;
        long wcn = wc;
        if (bc != wc) {
            if ((bc - wc) > z) {
                bcn = (bc - wc) > z ? wc + z : bc;
            } else if ((wc - bc) > z) {
                wcn = (wc - bc) > z ? bc + z : wc;
            }
        }
        long br = b * bcn;
        long wr = w * wcn;

        return br + wr;
    }

    public static List stringToList(String str) {
        List<String> list = new ArrayList<>();
        //if (StringUtil.isNotBlank(str)) {
        String[] configServersArr = str.split(",");
        for (String configServer : configServersArr) {
            list.add(configServer);
        }
        //}
        return list;
    }

    final static Map<Status, HashSet<Status>> VALID_STATUS_MAP = new HashMap<>();

    private static void addStatus(Status fromStatus, Status toStatus) {
        ;
        HashSet<Status> set = new HashSet<>();
        set.add(toStatus);
        HashSet<Status> statusSet = VALID_STATUS_MAP.putIfAbsent(fromStatus, set);
        if (statusSet != null) {
            statusSet.add(toStatus);
            VALID_STATUS_MAP.put(fromStatus, statusSet);
        }

    }

    public static void main(String[] args) {
        System.out.println(Status.NEW.hashCode());
        System.out.println(Status.READY_TO_SEND.hashCode());
        System.out.println(Status.SENDING.hashCode());


        addStatus(Status.NEW, Status.READY_TO_SEND);
        addStatus(Status.NEW, Status.READY_TO_SEND_FAILED);
        addStatus(Status.READY_TO_SEND, Status.SENDING);
        addStatus(Status.READY_TO_SEND, Status.SENDING_FAILED);
        addStatus(Status.SENDING, Status.SENT);
        addStatus(Status.SENDING, Status.SENT_FAILED);

        System.out.println(VALID_STATUS_MAP.get(Status.NEW));

    }


}


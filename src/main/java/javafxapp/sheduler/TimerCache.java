package javafxapp.sheduler;

import javafxapp.adapter.domain.Adapter;

import java.util.HashMap;

public class TimerCache {

    private static TimerCache timerCache;

    private HashMap<String, TimerRequests> requestsToSend;

    private TimerCache(){
        requestsToSend = new HashMap<String, TimerRequests>();
    }

    public static TimerCache getInstance() {
        if (timerCache == null) timerCache = new TimerCache();
        return timerCache;
    }

    public synchronized void addRequest(Adapter adapter){
        TimerRequests timerRequests = new TimerRequests();
        timerRequests.setRequestXml(adapter.getRequestXml());
        timerRequests.setSmevAddress(adapter.getAdapterDetails().getSmevAddress());
        timerRequests.setAdapterId(adapter.getId210fz());
        timerRequests.setFoiv(adapter.getAdapterDetails().getFoiv());
        requestsToSend.put(String.valueOf(adapter.getId()), timerRequests);

    }

    public synchronized void deleteRequest(String idRequest){
        requestsToSend.remove(idRequest);
    }

    public synchronized void deleteRequests(){
        requestsToSend.clear();
    }

    public HashMap<String, TimerRequests> requestsList(){
        return requestsToSend;
    }


}

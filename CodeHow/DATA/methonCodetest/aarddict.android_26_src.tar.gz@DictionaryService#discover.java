public class test94 {
public List<File> discover() {
                sendBroadcast(new Intent(DISCOVERY_STARTED));
                Thread.yield();
        File scanRoot = new File ("/");
        List<File> result = new ArrayList<File>();
        result.addAll(scanDir(scanRoot));
        Intent intent = new Intent(DISCOVERY_FINISHED);
        intent.putExtra("count", result.size());
        sendBroadcast(intent);
        Thread.yield();
        return result;
    }

}
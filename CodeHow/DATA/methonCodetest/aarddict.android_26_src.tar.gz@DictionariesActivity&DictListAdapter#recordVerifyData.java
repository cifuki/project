public class test86 {
private void recordVerifyData(UUID uuid, boolean ok) {
            VerifyRecord record = new VerifyRecord();
            record.uuid = uuid;
            record.ok = ok;
            record.date = new Date();
            verifyData.put(record.uuid, record);
            try {
                saveVerifyData();
            } catch (Exception e) {
                Log.e(TAG, "Failed to save verify data", e);
            }
            updateView();
        }

}
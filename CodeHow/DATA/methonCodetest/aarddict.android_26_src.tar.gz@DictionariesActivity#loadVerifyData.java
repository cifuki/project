public class test66 {
@SuppressWarnings("unchecked")
    void loadVerifyData() throws IOException, ClassNotFoundException {
        File verifyDir = getDir("verify", 0);
        File verifyFile = new File(verifyDir, "verifydata");
        if (verifyFile.exists()) {
            FileInputStream fin = new FileInputStream(verifyFile);
            ObjectInputStream oin = new ObjectInputStream(fin);
            verifyData = (Map<UUID, VerifyRecord>) oin.readObject();
        }
    }

}
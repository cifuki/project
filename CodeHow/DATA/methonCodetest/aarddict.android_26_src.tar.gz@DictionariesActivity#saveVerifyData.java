public class test73 {
void saveVerifyData() throws IOException {
        File verifyDir = getDir("verify", 0);
        File verifyFile = new File(verifyDir, "verifydata");
        FileOutputStream fout = new FileOutputStream(verifyFile);
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(verifyData);
    }

}
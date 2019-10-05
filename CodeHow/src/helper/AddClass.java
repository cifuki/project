package helper;

import java.io.*;



public class AddClass {
    public static BufferedReader bufread;
    //ָ���ļ�·��������
   // private static String path ;
    //private static String readStr ="";

    public AddClass(String path1,String name) throws IOException {
    	String path=path1;
    	String b;
    	b=AddClass.readTxtFile(path);
    	AddClass.writeTxtFile(path,"abc",b);
    	AddClass.replaceTxtByStr(path,"abc", "public class "+name+" {");
    	AddClass.replaceTxtByStr(path,"abc", "}");
    }

    /**
     * �����ı��ļ�.
     * @throws IOException 
     * 
     */
    public static void creatTxtFile(String path) throws IOException{
    	File filename = new File(path);
        if (!filename.exists()) {
            filename.createNewFile();
            System.err.println(filename + "�Ѵ�����");
        }
    }
    
    /**
     * ��ȡ�ı��ļ�.
     * 
     */
    public static String readTxtFile(String path){
    	File filename = new File(path);
        String read;
        String readStr="";
        FileReader fileread;
        try {
            fileread = new FileReader(filename);
            bufread = new BufferedReader(fileread);
            try {
                while ((read = bufread.readLine()) != null) {
                    readStr = readStr + read+ "\r\n";
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return readStr;
    }
    
    /**
     * д�ļ�.
     * 
     */
    public static void writeTxtFile(String path,String newStr,String readStr) throws IOException{
        //�ȶ�ȡԭ���ļ����ݣ�Ȼ�����д�����
    	File filename = new File(path);
        String filein = newStr + "\r\n" + readStr + "\r\n" + newStr;
        RandomAccessFile mm = null;
        try {
            mm = new RandomAccessFile(filename, "rw");
            mm.writeBytes(filein);
        } catch (IOException e1) {
            // TODO �Զ����� catch ��
            e1.printStackTrace();
        } finally {
            if (mm != null) {
                try {
                    mm.close();
                } catch (IOException e2) {
                    // TODO �Զ����� catch ��
                    e2.printStackTrace();
                }
            }
        }
    }
    
    /**
     * ���ļ���ָ�����ݵĵ�һ���滻Ϊ��������.
     * 
     * @param oldStr
     *            ��������
     * @param replaceStr
     *            �滻����
     */
    public static void replaceTxtByStr(String path,String oldStr,String replaceStr) {
        String temp = "";
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();

            // �������ǰ�������
            for (int j = 1; (temp = br.readLine()) != null
                    && !temp.equals(oldStr); j++) {
                buf = buf.append(temp);
                buf = buf.append(System.getProperty("line.separator"));
            }

            // �����ݲ���
            buf = buf.append(replaceStr);

            // ������к��������
            while ((temp = br.readLine()) != null) {
                buf = buf.append(System.getProperty("line.separator"));
                buf = buf.append(temp);
            }

            br.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * main��������
     * @param s
     * @throws IOException
     */
    public static void main(String[] s) throws IOException {
    	String path = ".\\DATA\\methonCodetest";
    	File file=new File(path);
   	 if(file.exists()) {
   		 File[] sf=file.listFiles();
   		 int i=0;
   		 for(File filech:sf) {
   			 i++;
   			//UpdataFileType a=new UpdataFileType(ast.Main.path,"java","txt");
   			new AddClass(filech.getPath(),"test"+i);
   			//UpdataFileType b=new UpdataFileType(ast.Main.path,"txt","java");
   			 }
   		 }

    }
}
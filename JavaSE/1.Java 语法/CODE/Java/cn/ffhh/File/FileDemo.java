package cn.ffhh.File;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther FrSilence
 * @date 2019-09-23 15:45
 * Description：文件展示demo
 */
public class FileDemo {
    private String path;
    private File sysFile;
    private String header;

    public FileDemo(String path) {
        this.path = path;
    }
    public void showFilePath(){
        try{
            this.sysFile = new File(path);
        }catch (Exception e){
            System.out.println("所提供的的目录不合法，提供准确的文件目录");
        }
        this.header = "";
        listAll(sysFile);
    }
    private void listAll(File file){
        this.header = this.header+"--";
        if(file.isFile()){
            System.out.println(fileInfo(file));
        }else{
            System.out.println(fileInfo(file));
            File[] listFiles = file.listFiles();
            for(File fileNext:listFiles){
                listAll(fileNext);
            }
        }
        this.header = this.header.substring(0,this.header.length()-2);
    }
    private String fileInfo(File file){
        StringBuffer info = new StringBuffer();
        info.append(this.header);
        info.append(file.getName()+"--");
        info.append((file.canRead()?"可读":"不可读")+"--");
        info.append((file.canWrite()?"可写":"不可写")+"--");
        info.append((file.isFile()?"最后修改时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified()))+"--":""));
        info.append((file.isFile()?"文件大小："+file.length()+"B"+"--":""));
        return info.substring(0,info.length()-2);
    }
}

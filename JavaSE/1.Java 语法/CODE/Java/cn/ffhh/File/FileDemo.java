package cn.ffhh.File;

import java.io.File;

/**
 * @auther FrSilence
 * @date 2019-09-23 15:45
 * Description：文件展示demo
 */
public class FileDemo {
    private String path;
    private File sysFile;

    public FileDemo(String path) {
        this.path = path;
    }
    public void showFilePath(){
        try{
            this.sysFile = new File(path);
        }catch (Exception e){
            System.out.println("所提供的的目录不合法，提供准确的文件目录");
        }
        if(sysFile.isFile()){
            System.out.println(sysFile.getName());
        }else{
            System.out.println(sysFile.getName());
        }
    }
}

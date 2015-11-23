package ar.com.apply.dev.app;

import java.io.File;



public class DirSize {
    public Long UseSpace = new Long(0);
    public int FileNum = 0;
    
    public Long DirSizeA(File Dir){
        File[] ListFiles = Dir.listFiles();

        int DirLength = ListFiles.length;
        for(int x = 0;x < DirLength;x ++){
            if(ListFiles[x].isFile()){
                UseSpace += (ListFiles[x].length());
                FileNum ++;
            }else{
                DirSizeA(ListFiles[x]);
            }
        }
        return UseSpace;

    }

	
	

}

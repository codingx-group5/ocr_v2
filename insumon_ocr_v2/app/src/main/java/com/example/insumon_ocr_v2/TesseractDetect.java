package com.example.insumon_ocr_v2;

//import org.bytedeco.leptonica.PIX;
//import org.bytedeco.tesseract.TessBaseAPI;
import android.content.res.AssetManager;
import android.graphics.Bitmap;

import com.googlecode.tesseract.android.TessBaseAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TesseractDetect {

    private String datapath = "";

    private AssetManager asset;

    private TessBaseAPI mTess;

//    private File fileDir;

    public TesseractDetect(AssetManager assetPath, File fil){
        String language = "letsgodigital";

        asset = assetPath;
//        fileDir = fil;

        datapath = fil + "/tesseract/";
        mTess = new TessBaseAPI();
        checkFile(new File(datapath + "/tessdata/"));
        mTess.init(datapath, language);
        mTess.setPageSegMode(TessBaseAPI.PageSegMode.PSM_SINGLE_LINE);
    }

    public String detectFromBitmap(Bitmap bitImg){
        String OCRresult = null;
        mTess.setImage(bitImg);
        OCRresult = mTess.getUTF8Text();
        OCRresult=OCRresult.replaceAll(",","");
        OCRresult=OCRresult.replaceAll("-","");
        OCRresult=OCRresult.replaceAll(" ","");
        if(OCRresult.length()==5){
            OCRresult=OCRresult. substring( 1, 4);
        }
        if(OCRresult.length()==4 && OCRresult.charAt(0)=='1'){
            OCRresult=OCRresult. substring( 1, 4);
        }
        if(OCRresult.length()==4 && OCRresult.charAt(3)=='1'){
            OCRresult=OCRresult. substring( 0, 3);
        }

//        OCRresult=OCRresult.replaceAll(".","");
//        int white=OCRresult.indexOf(" ");
//        if(white!=-1){
//            OCRresult=OCRresult. substring( white+1,  white+4);
//        }


        return OCRresult;
    }


    private void checkFile(File dir) {
        if (!dir.exists()&& dir.mkdirs()){
            this.copyFiles();
        }
        if(dir.exists()) {
//            String datafilepath = datapath+ "/tessdata/eng.traineddata";
            String datafilepath = datapath+ "/tessdata/letsgodigital.traineddata";
            File datafile = new File(datafilepath);

            if (!datafile.exists()) {
                copyFiles();
            }
        }
    }

    private void copyFiles() {
        try {
            String filepath = datapath + "/tessdata/letsgodigital.traineddata";


            InputStream instream = asset.open("tessdata/letsgodigital.traineddata");
            OutputStream outstream = new FileOutputStream(filepath);

            byte[] buffer = new byte[1024];
            int read;
            while ((read = instream.read(buffer)) != -1) {
                outstream.write(buffer, 0, read);
            }


            outstream.flush();
            outstream.close();
            instream.close();

            File file = new File(filepath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

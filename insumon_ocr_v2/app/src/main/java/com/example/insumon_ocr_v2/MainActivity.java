package com.example.insumon_ocr_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;


import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.bytedeco.javacpp.FlyCapture2;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.AndroidFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;
import com.googlecode.tesseract.android.TessBaseAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public opencv_core.Mat roi;
    //public Mat roi;
    public ImageView imageView;
    public TextView result;


    Bitmap bitmap;
    Bitmap bitmap_after;
    opencv_core.Mat Mat_after;


    int b = 1351;
    int c = 15;

    public AndroidFrameConverter converterToBitmap;
    public OpenCVFrameConverter.ToIplImage converterToIplImage;
    public OpenCVFrameConverter.ToMat converterToMat;

    public Process poss;
    public ImgConvertor conver = new ImgConvertor();
    public TesseractDetect Tess;

    private AssetManager assetManager;
    private File file;

    private ImageView imgCapture;

    private static final int Image_Capture_Code = 1;
//    public String datapath = getFilesDir()+ "/tesseract/";




    ///////





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        assetManager = getAssets();
        file = getFilesDir();

        Tess = new TesseractDetect(assetManager,file);



        imageView = (ImageView) findViewById(R.id.imgV);

        result = (TextView) findViewById(R.id.result);

//        Bitmap bit = conver.imagev2Bitmap(imageView);
//
//        roi = conver.imagev2Mat(imageView);
//
//        poss = new Process(roi);
//
//        poss.compress(roi.cols()/2,roi.rows()/2);
//        //poss.process(b,c);
//
//        poss.process(b,c);
//
//        //bitmap = poss.getBitmap();
//
//        imageView.setImageBitmap(poss.getBitmap());
//
//        String output = Tess.detectFromBitmap(poss.getBitmap());
//        result.setText(output);


//        checkFile(new File(datapath + "tessdata/"), "letsgodigital");


    }


}




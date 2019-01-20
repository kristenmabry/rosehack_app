package com.example.sugarcalculator;

import android.content.Context;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.media.ImageReader;
import android.support.v7.app.AppCompatActivity;
import android.view.TextureView;
import android.widget.Button;

public class Capture extends AppCompatActivity {

    private Button btnCapture;
    private TextureView textureView;

    private String cameraId;
    private CameraDevice cameraDevice;
    private CameraCaptureSession cameraCaptureSession;
    private CaptureRequest.Builder captureRequestBuilder;
    private ImageReader imageReader;

    CameraManager cameraManager = Context.getSystemService(Context.CAMERA_SERVICE);


}

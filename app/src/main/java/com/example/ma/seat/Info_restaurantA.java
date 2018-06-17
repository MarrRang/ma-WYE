package com.example.ma.seat;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Info_restaurantA extends AppCompatActivity {

    private static final int PICK_FROM_ALBUM = 1;
    private static final int PICK_FROM_CAMERA = 0;
    private static final int CROP_FROM_IMAGE = 2;

    private ImageView iv_UserPhoto;
    private Uri mImageCaptureUri;
    private Uri mImageAlbumUri;
    private String absoultePath;
    private View info_restaurant_img1_header;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_restaurant);

        //ViewPager
        ViewPager vp = (ViewPager)findViewById(R.id.info_img_pager);
        vp.setAdapter(new CustomAdapter(getSupportFragmentManager()));


        //TapHost

        TabHost host=(TabHost)findViewById(R.id.host);
        host.setup();


        TabHost.TabSpec spec=host.newTabSpec("tab1");
        spec.setIndicator(null, ResourcesCompat.getDrawable(getResources(),R.drawable.info_img_savein,null));
        spec.setContent(R.id.tab_content1);
        host.addTab(spec);

        spec=host.newTabSpec("tab2");
        spec.setIndicator(null, ResourcesCompat.getDrawable(getResources(),R.drawable.info_img_review,null));
        spec.setContent(R.id.tab_content2);
        host.addTab(spec);

        spec=host.newTabSpec("tab3");
        spec.setIndicator(null, ResourcesCompat.getDrawable(getResources(),R.drawable.lml,null));
        spec.setContent(R.id.tab_content3);
        host.addTab(spec);
        /*
        info_restaurant_img1_header = getLayoutInflater().inflate(R.layout.info_restaurant_img1,null,false);
        iv_UserPhoto = (ImageView)info_restaurant_img1_header.findViewById(R.id.info_img_1);
        */


        Button btn_setImg = (Button)findViewById(R.id.info_Btn_setImg);
        Button btn_follow = (Button)findViewById(R.id.info_Btn_Follow);
        Button btn_option = (Button)findViewById(R.id.info_Btn_Option);

        //btn_setImg.setOnClickListener(this);
    }
/*
    public void doTakePhotoAction(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        String url = "tmp_" + String.valueOf(System.currentTimeMillis()) + ".jpg";
        mImageCaptureUri =  Uri.fromFile(new File(Environment.getExternalStorageDirectory(),url));

        intent.putExtra(MediaStore.EXTRA_OUTPUT,mImageCaptureUri);
        startActivityForResult(intent, PICK_FROM_CAMERA);
    }

    public void doTakeAlbumAction(){
        //앨범호출
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        //startActivityForResult(intent,PICK_FROM_ALBUM);
        CropImage.activity(mImageCaptureUri).start(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK)
            return;

        switch (requestCode) {
            case CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE: {
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                if (resultCode == RESULT_OK) {
                    iv_UserPhoto.setImageURI(result.getUri());
                    adapter.notifyDataSetChanged();
                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    Exception error = result.getError();
                }

                break;
            }

            case PICK_FROM_ALBUM: {
                mImageCaptureUri= data.getData();

            }

            case PICK_FROM_CAMERA: {
                //CropImage.activity(mImageCaptureUri).start(this);
                /*
                Intent intent = new Intent("com.android.camera.action.CROP");
                intent.setDataAndType(mImageCaptureUri, "image/*");

                intent.putExtra("crop","true");
                intent.putExtra("outputX", vp.getWidth());
                intent.putExtra("outputY", vp.getHeight());
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);

                intent.putExtra("scale", true);
                intent.putExtra("return-data", true);
                startActivityForResult(intent, CROP_FROM_IMAGE);

                break;
            }
            /*case CROP_FROM_IMAGE: {
                if (resultCode != RESULT_OK) {
                    return;
                }

                final Bundle extras = data.getExtras();

                String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/MySeat/" + System.currentTimeMillis() + ".jpg";

                if (extras != null) {
                    Bitmap photo = extras.getParcelable("data");
                    iv_UserPhoto.setImageBitmap(photo);

                    storeCropImage(photo, filePath);
                    absoultePath = filePath;
                    break;
                }

                File f = new File(mImageCaptureUri.getPath());
                if (f.exists()) {
                    f.delete();
                }
            }

        }

    }

*/
    public void onClick(View v){
        /*
        if(v.getId()==R.id.info_img_setBtn) {
            DialogInterface.OnClickListener cameraListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                        doTakePhotoAction();
                }
            };
            DialogInterface.OnClickListener albumListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                        doTakeAlbumAction();
                }
            };
            DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            };

            new AlertDialog.Builder(this).setTitle("업로드 할 이미지").setPositiveButton("사진촬영",cameraListener).setNeutralButton("앨범선택",albumListener).setNegativeButton("취소",cancelListener).show();

        }*/
    }




/*
private void storeCropImage(Bitmap bitmap, String filePath) {
    String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/MySeat";
    File directory_MySeat = new File(dirPath);

    if (!directory_MySeat.exists())
        directory_MySeat.mkdir();

    File copyFile = new File(filePath);
    BufferedOutputStream out = null;

    try {
        copyFile.createNewFile();
        out = new BufferedOutputStream(new FileOutputStream(copyFile));
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);

        sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(copyFile)));

        out.flush();
        out.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
*/
}

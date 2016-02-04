package space.kiya.flashlightsoul;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.TransitionDrawable;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

import java.io.IOException;
/**
 * Created by kiya on 16-2-3.
 */
public class Flashlight extends BaseActivity{

    @Override public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        mImageViewFlashlight.setTag(false);

        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);

        LayoutParams layoutParams = mImageViewFlashlightController.getLayoutParams();
        layoutParams.height = point.y * 3/4;
        layoutParams.width = point.x / 3;

        mImageViewFlashlightController.setLayoutParams(layoutParams);
    }

    @Override protected void onPause() {
        super.onPause();
        if ((Boolean) mImageViewFlashlight.getTag()) {
            closeFlashlight();
        }
    }

    public void onclick_flashlight(View view){
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)){
            Toast.makeText(this,"您的设备不支持闪光灯",Toast.LENGTH_SHORT).show();
            return;
        }
        if (mImageViewFlashlight == null){
            Toast.makeText(this,"kong!",Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this,mImageViewFlashlight.getTag().toString(),Toast.LENGTH_SHORT).show();
        if (!(Boolean) mImageViewFlashlight.getTag()){
            openFLashlight();
        }else {
            closeFlashlight();
        }
    }


    protected void openFLashlight(){
        TransitionDrawable transitionDrawable = (TransitionDrawable) mImageViewFlashlight.getDrawable();
        transitionDrawable.startTransition(200);
        mImageViewFlashlight.setTag(true);

        try {
            mCamera = Camera.open();
            int textureId = 0;
            mCamera.setPreviewTexture(new SurfaceTexture(textureId));
            mCamera.startPreview();

            mParameters = mCamera.getParameters();
            mParameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            mCamera.setParameters(mParameters);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void closeFlashlight(){
        TransitionDrawable transitionDrawable = (TransitionDrawable) mImageViewFlashlight.getDrawable();
        if (!(Boolean) mImageViewFlashlight.getTag()){
            transitionDrawable.startTransition(200);
            mImageViewFlashlight.setTag(false);

            if (mCamera != null){
                mParameters = mCamera.getParameters();
                mParameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                mCamera.setParameters(mParameters);
                mCamera.stopPreview();
                mCamera.release();
                mCamera = null;
            }
        }
    }
}





















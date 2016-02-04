package space.kiya.flashlightsoul;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;
/**
 * Created by kiya on 16-2-3.
 */
public class Flashlight extends BaseActivity{

    @Override public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);

        LayoutParams layoutParams = mFlashlightController.getLayoutParams();
        layoutParams.height = point.y * 3/4;
        layoutParams.width = point.x / 3;

        mFlashlightController.setLayoutParams(layoutParams);
    }

    public void onclick_flashlight(View view){
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)){
            Toast.makeText(this,"您的设备不支持闪光灯",Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this,"您的设备支持闪光灯!",Toast.LENGTH_SHORT).show();
    }
}

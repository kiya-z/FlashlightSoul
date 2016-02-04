package space.kiya.flashlightsoul;
import android.app.Activity;
import android.os.Bundle;
import android.hardware.Camera;
import android.widget.ImageView;
/**
 * Created by kiya on 16-2-3.
 */
public class BaseActivity extends Activity {

    protected ImageView mImageViewFlashlight;
    protected ImageView mImageViewFlashlightController;
    protected Camera mCamera;
    protected Camera.Parameters mParameters;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageViewFlashlight = (ImageView) findViewById(R.id.flashlight);
        mImageViewFlashlightController = (ImageView) findViewById(R.id.flashlight_controller);
    }
}


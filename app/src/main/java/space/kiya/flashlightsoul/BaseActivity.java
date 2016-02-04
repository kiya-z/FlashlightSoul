package space.kiya.flashlightsoul;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
/**
 * Created by kiya on 16-2-3.
 */
public class BaseActivity extends Activity {

    protected ImageView mFlashlight;
    protected ImageView mFlashlightController;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mFlashlight = (ImageView) findViewById(R.id.flashlight);
            mFlashlightController = (ImageView) findViewById(R.id.flashlight_controller);
        }
}


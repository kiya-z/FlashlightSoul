package space.kiya.flashlightsoul;
import android.app.Activity;
import android.os.Bundle;
/**
 * Created by kiya on 16-2-3.
 */
public class BaseActivity extends Activity {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
}


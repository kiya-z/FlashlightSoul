package space.kiya.flashlightsoul;
import android.graphics.Point;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ViewGroup.LayoutParams;
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
}

package co.zaven.digitalimageprocessing.activities;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.zaven.digitalimageprocessing.R;
import co.zaven.digitalimageprocessing.helpers.ActivityHelper;

public class ProcessingOptionsActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processing_options);
        ButterKnife.bind(this);
        ActivityHelper.setupToolbar(this, toolbar);

        Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                getResources().getResourcePackageName(R.drawable.sun_mountain) + '/' +
                getResources().getResourceTypeName(R.drawable.sun_mountain) + '/' +
                getResources().getResourceEntryName(R.drawable.sun_mountain));

        bundle = new Bundle();
        bundle.putParcelable(KEY_BITMAP, uri);
    }

    @OnClick({R.id.histogram})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.histogram:
                ActivityHelper.startActivity(this, HistogramActivity.class, bundle);
                break;
        }
    }

}

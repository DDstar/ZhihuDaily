package org.ddstar.zhihudaily.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.socks.library.KLog;

import org.ddstar.zhihudaily.R;
import org.ddstar.zhihudaily.datamodel.BeanStart;
import org.ddstar.zhihudaily.netmodel.RxRequest;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

public class WelcomeActivity extends AppCompatActivity {

    @BindView(R.id.simpleView)
    SimpleDraweeView simpleView;
    @BindView(R.id.tv_author)
    TextView tvAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        RxRequest.getStartImage(new Subscriber<BeanStart>() {
            @Override
            public void onCompleted() {
                KLog.e("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                KLog.e("onError" + e.toString());
            }

            @Override
            public void onNext(BeanStart beanStart) {
                tvAuthor.setText(beanStart.getText());
                simpleView.setImageURI(beanStart.getImg());
            }
        });
    }
}

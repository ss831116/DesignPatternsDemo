package bernie.com.builddemoapplication;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends BaseActivity implements Presenter<UserBean>, View.OnClickListener {
    private GoogleApiClient client;
    UserBean userBean;
    TextView userText;
    Button likeButton;
    TextView likeText;
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences =  SingleUserBeanSP.getSingleUserBeanSP(getApplicationContext());
        editor = sharedPreferences.edit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        userBean = new UserBean.Builder().setAge(18)
                .setName("Bernie")
                .setHeight((float) 175.0)
                .setBodyWeight((float) 80.0)
                .build();
        userText = (TextView) findViewById(R.id.userText);
        likeButton = (Button) findViewById(R.id.likeButton);
        likeText = (TextView) findViewById(R.id.likeText);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void displayUI() {
        userText.setText(userBean.getAge() + "\n" +
                userBean.getName() + "\n" +
                userBean.getBodyWeight() + "\n" +
                userBean.getHeight());
        likeButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page")
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    @Override
    public void like(UserBean userBean) {
        likeText.setText(userBean.getName() + "\n"
                + "likeCount = " + userBean.getLikeCount());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.likeButton:
                new UserBeanPresenter(userBean, this, sharedPreferences,editor);
                break;
        }
    }
}

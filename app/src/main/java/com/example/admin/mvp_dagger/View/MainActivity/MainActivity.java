package com.example.admin.mvp_dagger.View.MainActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.admin.mvp_dagger.R;
;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View
{
    MainActivityPresenter presenter;
    private static final String TAG = "MainPresenterTag";
    @Inject
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DaggerMainActivityComponent.create().inject(this);
        tv = (TextView) findViewById(R.id.TV);
//        presenter = new MainActivityPresenter();
        presenter.setContext(this);
        presenter.attachView(this);

    }

    public void doMagic(View view)
    {
        presenter.savePerson("John Doe");
        presenter.getPerson();

        switch (view.getId()){
            case R.id.btnSavePerson:
                presenter.savePerson("Sam Adams");
                tv.setText("Sam Adams");
                break;
            case R.id.btnGetPerson:
                Log.d(TAG, presenter.getPerson());
                tv.setText("Person");
                break;

    }
    }

    @Override
    public void Showerror(String s) {

    }

    @Override
    public void isPersonSaved(boolean isSaved) {
        Log.d("TAG ", "isPersonSaved: " + isSaved + "\n");
    }

    @Override
    public void sendPerson(String person) {
        Log.d(TAG, "sendPerson: " + person);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.removeView();
    }
}

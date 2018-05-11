package in.mynewcar.notificationpage.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.mynewcar.notificationpage.R;
import in.mynewcar.notificationpage.fragments.NotificationFragment;
import in.mynewcar.notificationpage.models.Notification;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static com.android.volley.Request.Method.POST;


public class NotificationActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Notification> allNotificationList = new ArrayList<>();
    private List<Notification> updateNotificationList = new ArrayList<>();
    private List<Notification> offerNotificationList = new ArrayList<>();
    private ViewPagerAdapter adapter;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(getApplicationContext().getResources().getDrawable(R.drawable.ic_back,getTheme()));
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        getNotifications();
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NotificationFragment(allNotificationList), "ALL");
        adapter.addFragment(new NotificationFragment(updateNotificationList), "UPDATES");
        adapter.addFragment(new NotificationFragment(offerNotificationList), "OFFERS");
        viewPager.setAdapter(adapter);


    }


    public void getNotifications(){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        final HashMap<String,String> params = new HashMap<>();
        params.put("owner_id","");
        params.put("user_id","");
        //TODO: Add params here
        StringRequest request = new StringRequest(POST, "http://images.mynewcar.in/MNC-TESTDRIVE/api_2/show_notification", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray allArray = jsonObject.getJSONArray("all");
                    JSONArray updateArray = jsonObject.getJSONArray("update");
                    JSONArray offerArray = jsonObject.getJSONArray("offer");
                    for(int i=0;i<allArray.length();i++){
                        //TODO: get the content of notification and pass it in the constructor below

                        Notification notification = new Notification("","","","","");
                        allNotificationList.add(notification);
                    }
                    for(int i=0;i<updateArray.length();i++){
                        //TODO: get the content of notification and pass it in the constructor below

                        Notification notification = new Notification("","","","","");
                        updateNotificationList.add(notification);
                    }
                    for(int i=0;i<offerArray.length();i++){
                        //TODO: get the content of notification and pass it in the constructor below

                        Notification notification = new Notification("","","","","");
                        offerNotificationList.add(notification);
                    }
                }catch(JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //TODO: Handle errors
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        queue.add(request);

    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}


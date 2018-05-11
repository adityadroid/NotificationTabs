package in.mynewcar.notificationpage.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.mynewcar.notificationpage.R;
import in.mynewcar.notificationpage.adapters.NotificationAdapter;
import in.mynewcar.notificationpage.models.Notification;

import static com.android.volley.Request.Method.POST;


public class NotificationFragment extends Fragment{

    List<Notification> notificationList = new ArrayList<>();
    public NotificationFragment(){}
    @SuppressLint("ValidFragment")
    public NotificationFragment(List<Notification> notificationList) {
    this.notificationList = notificationList;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        ShimmerRecyclerView notificationRecyclerView;
        notificationRecyclerView = view.findViewById(R.id.notificationRecyclerView);
        NotificationAdapter notificationAdapter = new NotificationAdapter(notificationList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        notificationRecyclerView.setLayoutManager(linearLayoutManager);
        notificationRecyclerView.setHasFixedSize(true);
        notificationRecyclerView.setAdapter(notificationAdapter);


        return view;
    }


}

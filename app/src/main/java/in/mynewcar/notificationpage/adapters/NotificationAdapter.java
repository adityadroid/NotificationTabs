package in.mynewcar.notificationpage.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import in.mynewcar.notificationpage.R;
import in.mynewcar.notificationpage.models.Notification;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {
    List<Notification> notificationList;
    public NotificationAdapter(List<Notification> notificationList){
        // Have some data here
        this.notificationList = notificationList;

    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView, previewTextView, knowmoreTextView, dateTextView;
        ImageView notificationImageView;

        public NotificationViewHolder(View view) {
            super(view);
            titleTextView = view.findViewById(R.id.notificationTitleTextView);
            previewTextView = view.findViewById(R.id.notificationPreviewTextView);
            knowmoreTextView = view.findViewById(R.id.knowMoreTextView);
            notificationImageView = view.findViewById(R.id.notificationImageView);
            dateTextView = view.findViewById(R.id.dateTextView);

        }
    }
    @Override
    public NotificationAdapter.NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_notification_list, parent, false);

        return new NotificationAdapter.NotificationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NotificationAdapter.NotificationViewHolder holder, int position) {
            //TODO: set the data here
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }
}



package com.example.vipin.mvvm_vip.adapter;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.example.vipin.mvvm_vip.model.Notification_;


import java.util.List;

public class NotificationListBinding {

    @BindingAdapter("bind:dataListNew")
    public static void setNotificationDataList(RecyclerView recyclerView, List<Notification_> datalist) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();

        if (adapter != null && adapter instanceof NotificationAdapter) {
            ((NotificationAdapter) adapter).setNotificationDataList(datalist);
        } else {
            throw new IllegalStateException("RecyclerView either has no adapter set or the "
                    + "adapter isn't of type MovieAdapter");
        }
    }
}

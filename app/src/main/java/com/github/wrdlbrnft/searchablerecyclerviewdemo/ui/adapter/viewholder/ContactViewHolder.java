package com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.wrdlbrnft.searchablerecyclerviewdemo.R;
import com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.adapter.models.MainExampleModel;

public class ContactViewHolder extends BaseViewHolder {

    private TextView contactName;
    private TextView contactType;

    public ContactViewHolder(View itemView) {
        super(itemView);

        contactName = (TextView) itemView.findViewById(R.id.contactname);
        contactType = (TextView) itemView.findViewById(R.id.contacttype);
    }

    public void bind(MainExampleModel model) {
        contactName.setText(model.getContactName());
        contactType.setText(model.getContactType());
    }
}

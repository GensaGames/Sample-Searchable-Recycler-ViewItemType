package com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.wrdlbrnft.searchablerecyclerviewdemo.R;
import com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.adapter.models.MainExampleModel;

/**
 * Created by Genka on 12.07.2016.
 * GensaGames
 */
public class ContactLogViewHolder extends BaseViewHolder {

    private TextView contactName;
    private TextView contactType;
    private TextView specialLog;

    public ContactLogViewHolder(View itemView) {
        super(itemView);

        contactName = (TextView) itemView.findViewById(R.id.contactname);
        contactType = (TextView) itemView.findViewById(R.id.contacttype);
        specialLog = (TextView) itemView.findViewById(R.id.textView);
    }

    public void bind(MainExampleModel model) {
        contactName.setText(model.getContactName());
        contactType.setText(model.getContactType());
        specialLog.setText(model.getSpecialLog());
    }
}

package com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.wrdlbrnft.searchablerecyclerviewdemo.R;
import com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.adapter.models.MainExampleModel;
import com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.adapter.viewholder.ContactLogViewHolder;
import com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.adapter.viewholder.ContactViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    public static final int CONTACT = 0;
    public static final int CONTACT_LOG = 1;

    private final LayoutInflater mInflater;
    private final List<MainExampleModel> mModels;
    private boolean inSearchState;

    public ExampleAdapter(Context context, List<MainExampleModel> models) {
        mInflater = LayoutInflater.from(context);
        mModels = new ArrayList<>(models);
    }

    public void setInSearchState(boolean inSearchState) {
        this.inSearchState = inSearchState;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (viewType == CONTACT) {
            v = mInflater.inflate(R.layout.item_contact, parent, false);
            return new ContactViewHolder(v);
        } else if (viewType == CONTACT_LOG) {
            v = mInflater.inflate(R.layout.item_contact_log, parent, false);
            return new ContactLogViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final MainExampleModel model = mModels.get(position);
        if (holder.getItemViewType() == CONTACT) {
            ((ContactViewHolder) holder).bind(model);
        }
        if (holder.getItemViewType() == CONTACT_LOG) {
            ((ContactLogViewHolder) holder).bind(model);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (inSearchState) {
            return CONTACT_LOG;
        }
        return CONTACT;
    }

    @Override
    public int getItemCount() {
        return mModels.size();
    }

    /**
     * ===========================================================
     * Other methods!
     * ===========================================================
     */

    public void animateTo(List<MainExampleModel> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    private void applyAndAnimateRemovals(List<MainExampleModel> newModels) {
        for (int i = mModels.size() - 1; i >= 0; i--) {
            final MainExampleModel model = mModels.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<MainExampleModel> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final MainExampleModel model = newModels.get(i);
            if (!mModels.contains(model)) {
                addItem(i, model);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<MainExampleModel> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final MainExampleModel model = newModels.get(toPosition);
            final int fromPosition = mModels.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public MainExampleModel removeItem(int position) {
        final MainExampleModel model = mModels.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    public void addItem(int position, MainExampleModel model) {
        mModels.add(position, model);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final MainExampleModel model = mModels.remove(fromPosition);
        mModels.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
}

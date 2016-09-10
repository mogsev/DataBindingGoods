package com.mogsev.application.databindinggoods.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mogsev.application.databindinggoods.BR;
import com.mogsev.application.databindinggoods.R;
import com.mogsev.application.databindinggoods.demo.Demo;
import com.mogsev.application.databindinggoods.fragment.GoodsFragment;
import com.mogsev.application.databindinggoods.model.Goods;

import java.util.List;

public class RVGoodsAdapter extends RecyclerView.Adapter<RVGoodsAdapter.ViewHolder> {
    private static final String TAG = "RVGoodsAdapter";

    private GoodsFragment fragment;
    public final ObservableArrayList<Goods> list = new ObservableArrayList<Goods>();
    public final ObservableInt listEmpty = new ObservableInt(View.VISIBLE);

    public RVGoodsAdapter() {

    }

    public RVGoodsAdapter(@NonNull GoodsFragment fragment) {
        this.fragment = fragment;
        list.addAll(Demo.getListGoods());
        notifyListChange();
    }

    public RVGoodsAdapter(@NonNull List<Goods> list, @NonNull GoodsFragment fragment) {
        this.list.addAll(list);
        this.fragment = fragment;
        notifyListChange();
    }

    @Override
    public RVGoodsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_goods, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RVGoodsAdapter.ViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder");
        final Goods goods = list.get(position);
        goods.setPos(position);
        holder.getBinding().setVariable(BR.goods, goods);
        holder.getBinding().setVariable(BR.adapter, this);
        holder.getBinding().setVariable(BR.fragment, fragment);
        holder.getBinding().executePendingBindings();
    }

    public int getItemCount() {
        return list.size();
    }

    public void removeAt(Goods goods) {
        Log.i(TAG, "removeAT");
        list.remove(goods.getPos());
        notifyItemRemoved(goods.getPos());
        notifyItemRangeChanged(0, list.size(), goods);
        notifyListChange();

    }

    public ObservableArrayList<Goods> getList() {
        return list;
    }

    public ObservableInt getListEmpty() {
        return listEmpty;
    }

    private void notifyListChange() {
        listEmpty.set(list.isEmpty() ? View.VISIBLE : View.GONE);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }

    public boolean onRemove(@NonNull final Goods goods) {
        Log.i(TAG, "onRemove");
        removeAt(goods);
        return true;
    }

}

package cc.solart.dragdroplistview.sample.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import cc.solart.dragdrop.IDragEntity;
import cc.solart.dragdrop.adapter.AbsTileAdapter;
import cc.solart.dragdroplistview.sample.R;
import cc.solart.dragdroplistview.sample.TileView;

public class SimpleTileAdapter extends AbsTileAdapter {
    private TileView.OnSelectedListener mListener;
    public SimpleTileAdapter(Context context, DragDropListener dragDropListener, TileView.OnSelectedListener listener) {
        super(context, dragDropListener);
        mListener = listener;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TileView tileView = null;

        if (convertView != null && convertView instanceof TileView) {
            tileView = (TileView) convertView;
        }

        if (tileView == null) {
            tileView = (TileView) View.inflate(mContext,
                    R.layout.simple_tile_view, null);
        }

        tileView.setListener(mListener);

        tileView.renderData(getItem(position));


        return tileView;
    }

    @Override
    protected IDragEntity getDragEntity(View view) {
        return ((TileView)view).getDragEntity();
    }
}

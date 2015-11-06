package list.nordicloop.com.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RowsAdapter extends ArrayAdapter<RowModel> {
    private IRowSelectedListener mListener;
    private Context mContext;

    /**
     *  Constructor of {@link RowsAdapter}.
     * @param context the application context.
     * @param rows the array of the {@RowModel} objects.
     */
    public RowsAdapter(Context context, List<RowModel> rows) {
        super(context, 0, rows);
        mContext = context;
    }

    /**
     * Sets the {@link IRowSelectedListener} listener;
     * @param listener
     */
    public void setRowSelectedListener(IRowSelectedListener listener){
        mListener = listener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RowViewHolder viewHolder;

        // Object item based on the position.
        RowModel row = getItem(position);

        if (convertView == null){

            // Inflating the layout.
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.custom_cell, parent, false);

            // Setting up the ViewHolder.
            viewHolder = new RowViewHolder();
            viewHolder.mTitle = (TextView) convertView.findViewById(R.id.title);
            viewHolder.mSubTitle = (TextView) convertView.findViewById(R.id.subtitle);
            viewHolder.mIcon = (ImageView) convertView.findViewById(R.id.icon);

            // store the holder with the view.
            convertView.setTag(viewHolder);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RowViewHolder holder = (RowViewHolder) v.getTag();
                    if (mListener != null) {
                       mListener.onRowSelected(getItem(holder.mPosition), holder.mPosition);
                    }
                }
            });
        } else {
            // Recycling the view received in {@param convertView}
            viewHolder = (RowViewHolder) convertView.getTag();
        }

        if (row != null) {
            viewHolder.mTitle.setText(row.getTitle());
            viewHolder.mSubTitle.setText(row.getSubTitle());
            viewHolder.mIcon.setImageResource(row.getIcon());
            viewHolder.mPosition = position;
        }

        return convertView;
    }
}
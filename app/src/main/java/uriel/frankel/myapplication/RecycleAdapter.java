package uriel.frankel.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecycleViewHolder> {
    private List<RowData> items;

    public RecycleAdapter(List<RowData> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new RecycleViewHolder(view, items.get(i));
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder recycleViewHolder, int i) {
        RowData actualData = items.get(i);
        recycleViewHolder.textView.setText(actualData.text);
        recycleViewHolder.item = actualData;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void RemoveItem(RowData item) {
        items.remove(item);
        this.notifyDataSetChanged();
    }

    class RecycleViewHolder extends RecyclerView.ViewHolder {
        //Some textViews
        public RowData item;
        public TextView textView;

        public RecycleViewHolder(@NonNull View itemView, final RowData item) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            this.item = item;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RemoveItem(RecycleViewHolder.this.item);
                }
            });
        }
    }

}
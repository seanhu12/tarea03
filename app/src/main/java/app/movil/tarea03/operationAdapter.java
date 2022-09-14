package app.movil.tarea03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;



public class operationAdapter extends BaseAdapter {

    Context context;
    int operations[];
    String[] nameoperation;
    LayoutInflater inflter;

    public operationAdapter(Context applicationContext, int[] operations, String[] nameoperations) {
        this.context = applicationContext;
        this.operations = operations;
        this.nameoperation = nameoperations;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return operations.length;
    }

    @Override
    public Object getItem(int i) {
        return operations[i];
    }


    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.item_operations, null);
        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        TextView names = (TextView) view.findViewById(R.id.textView);
        icon.setImageResource(operations[i]);
        names.setText(nameoperation[i]);
        return view;
    }
}

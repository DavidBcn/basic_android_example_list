package list.nordicloop.com.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListViewActivity extends AppCompatActivity implements IRowSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);

        List<RowModel> rows = new ArrayList<>();
        for (int i=0; i<200; i++){
            rows.add(getRandomRowModel());
        }

        RowsAdapter rowsAdapter = new RowsAdapter(getApplicationContext(), rows);
        rowsAdapter.setRowSelectedListener(this);

        listView.setAdapter(rowsAdapter);
    }

    /**
     * It returns a mocked {@link RowModel} object.
     */
    private static RowModel getRandomRowModel() {
        Random rn = new Random();
        int randomPosition = rn.nextInt(SampleData.names.length);
        int randomPosition2 = rn.nextInt(SampleData.names.length);
        return new RowModel(SampleData.names[randomPosition],SampleData.names[randomPosition2], SampleData.idResources[randomPosition]);
    }

    @Override
    public void onRowSelected(RowModel rowModel, int position) {
        Toast.makeText(getApplicationContext(),"Row " + position + " selected (" + rowModel.toString() +")", Toast.LENGTH_SHORT).show();
    }
}

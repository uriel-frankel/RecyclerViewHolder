package uriel.frankel.myapplication

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        val list = ArrayList<RowData>()
        for(i in 0..1000){
            val rowData = RowData()
            rowData.text = "item number $i"
            list.add(rowData)
        }
        val adapter = RecycleAdapter(list)
        recycler.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}

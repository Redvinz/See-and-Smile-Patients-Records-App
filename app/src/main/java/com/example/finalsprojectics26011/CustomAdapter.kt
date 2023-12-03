package com.example.finalsprojectics26011

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalsprojectics26011.CustomAdapter.MyViewHolder

class CustomAdapter internal constructor(
    var activity: Activity,
    var context: Context,
    var patient_name: ArrayList<String>,
    var patient_address: ArrayList<String>,
    var patient_age: ArrayList<String>,
    var patient_contact: ArrayList<String>,
    var patient_appointment: ArrayList<String>,
    var patient_od: ArrayList<String>,
    var patient_os: ArrayList<String>,
    var patient_add: ArrayList<String>,
    var patient_pd: ArrayList<String>,
    var patient_frame: ArrayList<String>,
    var patient_lens: ArrayList<String>,
    var patient_laboratory: ArrayList<String>,
    var patient_price: ArrayList<String>
) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    var position = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.my_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        this.position = position
        holder.tvName.text = patient_name[position].toString()
        holder.tvAddress.text = patient_address[position].toString()
        holder.tvAge.text = patient_age[position].toString()
        holder.mainLayout.setOnClickListener {
            val intent = Intent(context, UpdateActivity::class.java)
            intent.putExtra("name", patient_name[position].toString())
            intent.putExtra("address", patient_address[position].toString())
            intent.putExtra("age", patient_age[position].toString())
            intent.putExtra("contact", patient_contact[position].toString())
            intent.putExtra("appointment", patient_appointment[position].toString())
            intent.putExtra("od", patient_od[position].toString())
            intent.putExtra("os", patient_os[position].toString())
            intent.putExtra("add", patient_add[position].toString())
            intent.putExtra("pd", patient_pd[position].toString())
            intent.putExtra("frame", patient_frame[position].toString())
            intent.putExtra("lens", patient_lens[position].toString())
            intent.putExtra("laboratory", patient_laboratory[position].toString())
            intent.putExtra("price", patient_price[position].toString())
            activity.startActivityForResult(intent, 1)
        }
    }

    override fun getItemCount(): Int {
        return patient_name.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView
        var tvAge: TextView
        var tvAddress: TextView
        var mainLayout: LinearLayout

        init {
            tvName = itemView.findViewById(R.id.tvName)
            tvAge = itemView.findViewById(R.id.tvAge)
            tvAddress = itemView.findViewById(R.id.tvAddress)
            mainLayout = itemView.findViewById(R.id.mainLayout)
        }
    }
}
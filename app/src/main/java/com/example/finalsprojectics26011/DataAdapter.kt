// DataAdapter.kt
package com.example.finalsprojectics26011

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter internal constructor(
    var activity: Activity,
    var context: Context,
    var patient_name: ArrayList<String>,
    var patient_address: ArrayList<String>,
    var patient_age: ArrayList<String>,
    // ... other data fields
) : RecyclerView.Adapter<DataAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.my_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.text = patient_name[position].toString()
        holder.tvAddress.text = patient_address[position].toString()
        holder.tvAge.text = patient_age[position].toString()

        holder.mainLayout.setOnClickListener {
            // Show the dialog when an item is clicked
            showItemDialog(position)
        }
    }

    private fun showItemDialog(position: Int) {
        // Create a custom dialog using your layout
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_data, null)
        val dialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .create()

        // Find and set values for TextViews in the dialog
        val tvNameDialog = dialogView.findViewById<TextView>(R.id.tvName)
        val tvAddressDialog = dialogView.findViewById<TextView>(R.id.tvAddress)
        val tvAgeDialog = dialogView.findViewById<TextView>(R.id.tvAge)

        // Set values based on the clicked item
        tvNameDialog.text = "${patient_name[position]}"
        tvAddressDialog.text = "${patient_address[position]}"
        tvAgeDialog.text = "${patient_age[position]}"

        // Add other TextViews...

        // Show the custom dialog
        dialog.show()
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

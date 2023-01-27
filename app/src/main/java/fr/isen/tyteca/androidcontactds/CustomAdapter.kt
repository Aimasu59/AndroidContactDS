package fr.isen.tyteca.androidcontactds


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

internal class CustomAdapter(private var listContact: ArrayList<Results>, val onItemClickListener: (Results) -> Unit) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    internal class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTextView: TextView = view.findViewById(R.id.itemTextView)
        var mailTextView: TextView = view.findViewById(R.id.mailTextView)
        var addresTextView: TextView = view.findViewById(R.id.addresTextView)
        var imageContact: ImageView = view.findViewById(R.id.imageContact)
        var mainLayout : View = view.findViewById(R.id.mainLayout)


    }



    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.cellule, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listContact.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listContact[position]
        holder.itemTextView.text = item.name?.first +" "+ item.name?.last
        holder.mailTextView.text = item?.email
        holder.addresTextView.text= item.location?.street?.number.toString() + " " + item.location?.street?.name + " " + item.location?.state + " " + item.location?.city
        holder.itemTextView.setOnClickListener {
            onItemClickListener(item)
        }

        if (item.picture?.large!!.isNotEmpty()) {
            Picasso.get().load(item.picture?.large).into(holder.imageContact)
        }
    }
    fun refreshList(contactFromAPI: ArrayList<Results>){
        listContact = contactFromAPI
        notifyDataSetChanged()
    }
}
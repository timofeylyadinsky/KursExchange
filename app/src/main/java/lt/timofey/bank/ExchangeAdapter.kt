package lt.timofey.bank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ExchangeAdapter(val plist: List<Exchange>, val mactivity: MainActivity): RecyclerView.Adapter<ExchangeAdapter.ExchangeViewHolder>() {

    class ExchangeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangeViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            var holder: ExchangeAdapter.ExchangeViewHolder //= PersonViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
            holder = ExchangeViewHolder(inflater.inflate(R.layout.bank_item, parent, false))

            holder.itemView.setOnClickListener{
                mactivity.itemClick(holder.adapterPosition)
            }
            /*holder.itemView.setOnLongClickListener {
                mactivity.removeItem(holder.adapterPosition)
                return@setOnLongClickListener true
            }*/

            return holder
        }

        override fun onBindViewHolder(holder: ExchangeViewHolder, position: Int) {
            val filialID = holder.itemView.findViewById<TextView>(R.id.filialId)
            val city = holder.itemView.findViewById<TextView>(R.id.city)
            var street = holder.itemView.findViewById<TextView>(R.id.street)
            val usdIn = holder.itemView.findViewById<TextView>(R.id.usdIn)
            val usdOut = holder.itemView.findViewById<TextView>(R.id.usdOut)
            var eurIn = holder.itemView.findViewById<TextView>(R.id.euroIn)
            var eurOut = holder.itemView.findViewById<TextView>(R.id.euroOut)



            filialID.text = plist[position].filial_id
            city.text = plist[position].name
            street.text = plist[position].street_type + plist[position].street + " " + plist[position].home_number
            usdIn.text = plist[position].USD_in
            usdOut.text = plist[position].USD_out
            eurIn.text = plist[position].EUR_in
            eurOut.text = plist[position].EUR_out
        }

        override fun getItemCount(): Int {
            return plist.count()
        }
}

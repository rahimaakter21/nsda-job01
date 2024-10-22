package com.example.job_01.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.job_01.Products
import com.example.job_01.R


class ProductAdapter (private val products: List<Products>):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

 inner class  ProductViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

      val productImg = itemView.findViewById<ImageView>(R.id.images)
     val productTitle = itemView.findViewById<TextView>(R.id.title)
     val productName= itemView.findViewById<TextView>(R.id.nameTV)
     val productPrice= itemView.findViewById<TextView>(R.id.priceTV)
     val productDescription= itemView.findViewById<TextView>(R.id.descriptionTV)

     fun bind(products: Products){

          productTitle.text = products.title
          productName.text = products.name
          productPrice.text = "Price : ${products.price}$"
         productDescription.text = products.description
         Glide.with(itemView).load(products.images[0]).into(productImg)
     }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list,parent,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }
}
package com.example.shopeasy.userpage;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopeasy.APIClientString;
import com.example.shopeasy.ApiClient;
import com.example.shopeasy.R;
import com.example.shopeasy.UserPage;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductAdaptar extends RecyclerView.Adapter<ProductAdaptar.ProductAdaptarVH> {

    private List<UserLoginResp> productListItems;
    private UserPage context;
    private clickedItem clickedItem;

    public ProductAdaptar(clickedItem clickedItem, UserPage activity) {
        this.clickedItem = clickedItem;
        this.context= activity;
    }

    public void setData(List<UserLoginResp> productListItems) {
        this.productListItems = productListItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductAdaptarVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductAdaptar.ProductAdaptarVH(LayoutInflater.
                from(context).inflate(R.layout.row_products,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdaptarVH holder, int position) {
        UserLoginResp userLoginResp = productListItems.get(position);
        String pName = userLoginResp.getProductName();
        String pQuan = userLoginResp.getQuantity();
        String pPrice = userLoginResp.getProductPrice();
        String pBarcode = userLoginResp.getProductID();
        String userID = userLoginResp.getUserID();

        holder.pName.setText(pName);
        holder.pQuan.setText(pQuan);
        holder.pPrice.setText(pPrice);
        holder.delProdcut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delProduct(userID,pBarcode);
            }
        });
        holder.moreDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedItem.clickedProduct(userLoginResp);
            }
        });

    }
    public interface clickedItem{
        public void clickedProduct(UserLoginResp userLoginResp);
    }

    public void delProduct(String userID, String pBarcode){
        Call<String> res = APIClientString.getUserPageService().deleteProduct(pBarcode,userID);
        res.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    Toast.makeText(context, response.body().toString(), Toast.LENGTH_SHORT).show();
                    context.getAllProducts(userID);
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                    Log.e("deletefailed",""+t);
            }
        });
    }

    @Override
    public int getItemCount() {
            return productListItems.size();
    }

    public static class ProductAdaptarVH extends RecyclerView.ViewHolder {

        TextView pName;
        TextView pQuan;
        TextView pPrice;
        Button delProdcut;
        Button moreDetails;

        public ProductAdaptarVH(@NonNull View itemView) {
            super(itemView);
             pName=itemView.findViewById(R.id.pName);
             pQuan=itemView.findViewById(R.id.pQuantity);
             pPrice=itemView.findViewById(R.id.pPrice);
             delProdcut=itemView.findViewById(R.id.delProduct);
             moreDetails=itemView.findViewById(R.id.moreDetails);
        }
    }
}

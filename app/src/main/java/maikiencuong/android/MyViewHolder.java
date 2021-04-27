package maikiencuong.android;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tvName, tvPrice, tvQuantity;
    public ImageView imageView;

    private ImageButton btnCong, btnTru;

    private ItemClickListenner itemClickListenner;

    public void setItemClickListenner(ItemClickListenner itemClickListenner) {
        this.itemClickListenner = itemClickListenner;
    }

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);
        tvName = itemView.findViewById(R.id.tvName);
        tvPrice = itemView.findViewById(R.id.tvPrice);
        imageView = itemView.findViewById(R.id.img);

        btnCong = itemView.findViewById(R.id.btnCong);
        btnTru = itemView.findViewById(R.id.btnTru);
        tvQuantity = itemView.findViewById(R.id.tvQuantity);

        if (btnCong != null) {
            btnCong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int quantity = Integer.parseInt(tvQuantity.getText().toString());
                    tvQuantity.setText("" + (++quantity));
                }
            });
        }
        if (btnTru != null) {
            btnTru.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int quantity = Integer.parseInt(tvQuantity.getText().toString());

                    if (quantity > 0) tvQuantity.setText("" + (--quantity));
                }
            });
        }

    }

    @Override
    public void onClick(View view) {
        itemClickListenner.onClick(view, getAdapterPosition(), false);
    }

}

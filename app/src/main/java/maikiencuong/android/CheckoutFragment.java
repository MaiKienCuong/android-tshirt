package maikiencuong.android;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CheckoutFragment extends Fragment {

    private ArrayList<Product> products;
    private RecyclerView recyclerView;
    private ProductAdapter adapter;

    private Button btnTru, btnCong;
    private TextView tvQuantity;
    private int quantity = 1;

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public CheckoutFragment() {
    }

    public static CheckoutFragment newInstance(ArrayList<Product> products) {
        CheckoutFragment fragment = new CheckoutFragment();
        Bundle args = new Bundle();
        args.putSerializable("products", products);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            products = (ArrayList<Product>) getArguments().getSerializable("products");
        }
        if (products == null)
            products = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkout, container, false);
        recyclerView = view.findViewById(R.id.recyclerView2);
        adapter = new ProductAdapter(products, view.getContext(), R.layout.item_checkout);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 1));

//        btnCong = inflater.inflate(R.layout.item_checkout, container, false).findViewById(R.id.btnCong);
//        btnTru = inflater.inflate(R.layout.item_checkout, container, false).findViewById(R.id.btnTru);
//        tvQuantity = inflater.inflate(R.layout.item_checkout, container, false).findViewById(R.id.tvQuantity);
//
//        btnCong.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    quantity = Integer.parseInt(tvQuantity.getText().toString());
//                    tvQuantity.setText("" + (++quantity));
//                } catch (Exception e) {
//                }
//            }
//        });
//        btnTru.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    quantity = Integer.parseInt(tvQuantity.getText().toString());
//                    if (quantity > 0)
//                        tvQuantity.setText("" + (--quantity));
//                } catch (Exception e) {
//                }
//            }
//        });


        return view;
    }
}
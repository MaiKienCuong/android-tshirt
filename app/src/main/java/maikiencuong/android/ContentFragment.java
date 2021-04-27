package maikiencuong.android;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ContentFragment extends Fragment {

    private ArrayList<Product> products;
    private RecyclerView recyclerView;
    private ProductAdapter adapter;

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public ContentFragment() {
    }

    public static ContentFragment newInstance(ArrayList<Product> products) {
        ContentFragment fragment = new ContentFragment();
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
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        adapter = new ProductAdapter(products, view.getContext(), R.layout.item_main);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 2));

        return view;
    }
}
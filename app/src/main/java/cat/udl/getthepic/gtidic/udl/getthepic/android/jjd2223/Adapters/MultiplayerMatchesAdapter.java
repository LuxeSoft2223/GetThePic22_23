package cat.udl.getthepic.gtidic.udl.getthepic.android.jjd2223.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cat.udl.getthepic.gtidic.udl.getthepic.android.jjd2223.Models.MultiplayerMatch;
import cat.udl.getthepic.gtidic.udl.getthepic.android.jjd2223.helpers.MultiplayMatchItemListener;
import cat.udl.getthepic.gtidic.udl.getthepic.getthepic.jjd2223.R;

public class MultiplayerMatchesAdapter extends RecyclerView.Adapter<MultiplayerMatchViewHolder> {

    private List<MultiplayerMatch> llista;
    private MultiplayMatchItemListener listener;

    public MultiplayerMatchesAdapter(List<MultiplayerMatch> llista, MultiplayMatchItemListener listener){
        this.llista = llista;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MultiplayerMatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View v = li.inflate(R.layout.multiplayer_rv_item, parent, false);
        return new MultiplayerMatchViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MultiplayerMatchViewHolder holder, int position) {
        MultiplayerMatch mm = llista.get(position);
        holder.render(mm);
    }

    @Override
    public int getItemCount() {
        return llista.size();
    }
}

package com.filipkesteli.recyclertviewsqlite;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by fkesteli on 23.6.2016..
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView tvIme;
    public TextView tvPrezime;

    public MyViewHolder(View itemView) {
        super(itemView);
        initCardWidgets();
    }

    private void initCardWidgets() {
        tvIme = (TextView) itemView.findViewById(R.id.tvIme);
        tvPrezime = (TextView) itemView.findViewById(R.id.tvPrezime);
    }

    public TextView getTvIme() {
        return tvIme;
    }

    public void setTvIme(TextView tvIme) {
        this.tvIme = tvIme;
    }

    public TextView getTvPrezime() {
        return tvPrezime;
    }

    public void setTvPrezime(TextView tvPrezime) {
        this.tvPrezime = tvPrezime;
    }

}

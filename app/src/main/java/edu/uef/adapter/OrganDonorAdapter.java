package edu.uef.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.uef.organ_donor_management.R;
import edu.uef.entity.OrganDonor;

public class OrganDonorAdapter extends BaseAdapter {
    private List<OrganDonor> organDonorList;
    private Context context;
    private int layout;
    public OrganDonorAdapter(Context context, List<OrganDonor> donorList){
        this.context=context;
        this.organDonorList= donorList;
        this.layout= layout;
    }
    @Override
    public int getCount() {
        return organDonorList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public void updateAdapter(ArrayList<OrganDonor> ds) {
        this.organDonorList = ds;
        notifyDataSetChanged();
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.list_view_item_organ_donor,null);
            viewHolder.tvFirstName =view.findViewById(R.id.textViewFirstNameOrganDonor);
            viewHolder.tvLastName =view.findViewById(R.id.textViewLastNameOrganDonor);
            viewHolder.tvGender =view.findViewById(R.id.textViewGenderOrganDonor);
            viewHolder.tvBirthday =view.findViewById(R.id.textViewBirthdayOrganDonor);
            viewHolder.tvAddress =view.findViewById(R.id.textViewAddressOrganDonor);
            viewHolder.tvOrganDonation =view.findViewById(R.id.textViewOrganDonation);
            viewHolder.ivGioiTinh= view.findViewById(R.id.imageViewGender);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        OrganDonor od =organDonorList.get(i);
        viewHolder.tvFirstName.setText("First Name: "+od.getFirstName());
        viewHolder.tvLastName.setText("Last Name: "+od.getLastName());
        if(od.isGender()==0){
            viewHolder.ivGioiTinh.setImageResource(R.drawable.male);
        }
        else{
            viewHolder.ivGioiTinh.setImageResource(R.drawable.female);
        }
        viewHolder.tvBirthday.setText("Birthday: "+od.getBirthday());
        viewHolder.tvAddress.setText("Address: "+od.getAddress());
        viewHolder.tvOrganDonation.setText("Organ Donation: "+od.getVisceras());

        return view;
    }
    class ViewHolder{
        ImageView ivGioiTinh;
        TextView tvFirstName, tvLastName ,tvGender,tvBirthday,tvAddress,tvOrganDonation;
    }
}

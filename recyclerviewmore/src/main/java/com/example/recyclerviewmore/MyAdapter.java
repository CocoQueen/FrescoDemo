package com.example.recyclerviewmore;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by coco on 2017/9/18.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<String> list;

    private static final int TYPE_1 = 1;
    private static final int TYPE_2 = 2;
    private static final int TYPE_3 = 3;

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return TYPE_1;
        if (position == 1)
            return TYPE_2;
        else
            return TYPE_3;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == TYPE_1) {
            View view = View.inflate(context, R.layout.item1, null);
            return new MyViewHolder(view);
        } else if (i == TYPE_2) {
            View view2 = View.inflate(context, R.layout.item2, null);
            return new MyViewHolder2(view2);
        } else {
            View view3 = View.inflate(context, R.layout.item3, null);
            return new MyViewHolder3(view3);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MyViewHolder) {
            HashMap<String, String> url_maps = new HashMap<String, String>();
            url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
            url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
            url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
            url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");


                DefaultSliderView textSliderView = new DefaultSliderView(context);
                textSliderView .setScaleType(BaseSliderView.ScaleType.Fit);//图片填充类型

                ((MyViewHolder) viewHolder).mSlider.addSlider(textSliderView);


                //修改轮播动画
                ((MyViewHolder) viewHolder).mSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
                ((MyViewHolder) viewHolder).mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
                ((MyViewHolder) viewHolder).mSlider.setCustomAnimation(new DescriptionAnimation());
                ((MyViewHolder) viewHolder).mSlider.setDuration(3000);
        }
        if (viewHolder instanceof MyViewHolder2) {
//            Glide.with(context).load( "http://tvfiles.alphacoders.com/100/hdclearart-10.png").into(((MyViewHolder2) viewHolder).mImg);
            ((MyViewHolder2) viewHolder).mImg.setImageResource(R.mipmap.ic_launcher_round);
        }
        if (viewHolder instanceof MyViewHolder3) {
            ((MyViewHolder3) viewHolder).mTv3.setText(list.get(i));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        SliderLayout mSlider;

        public MyViewHolder(View itemView) {
            super(itemView);
            mSlider = (SliderLayout) itemView.findViewById(R.id.slider);
        }
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder {
        ImageView mImg;

        public MyViewHolder2(View itemView) {
            super(itemView);
            mImg = (ImageView) itemView.findViewById(R.id.mImg);
        }
    }

    class MyViewHolder3 extends RecyclerView.ViewHolder {

        TextView mTv3;

        public MyViewHolder3(View itemView) {
            super(itemView);
            mTv3 = (TextView) itemView.findViewById(R.id.mTv3);
        }
    }
}

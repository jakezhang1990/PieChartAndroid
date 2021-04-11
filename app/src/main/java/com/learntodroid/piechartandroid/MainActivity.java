package com.learntodroid.piechartandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieChart = findViewById(R.id.activity_main_piechart);
        setupPieChart();
        loadPieChartData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadPieChartData2();
            }
        },5000);*/
    }

    private void setupPieChart() {
        pieChart.setExtraOffsets(0f,45f,0f,45f);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelTextSize(12);
        pieChart.setEntryLabelColor(Color.RED);

        pieChart.setDrawHoleEnabled(false);

        pieChart.setRotationAngle(0); //设置初始旋转角为0度

        // 触摸旋转
        pieChart.setRotationEnabled(false);

        /*pieChart.setCenterText("Spending by Category");
        pieChart.setCenterTextSize(24);*/


        pieChart.getDescription().setEnabled(true);

        /*Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(true);*/

        Legend legend = pieChart.getLegend();
        //设置比例块换行...
        legend.setWordWrapEnabled(true);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);//图例水平居中
//        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);  //设置图例水平显示
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM); //底部
        legend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);
//        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT); //左侧对其
        legend.setTextColor(Color.RED); //图例文字的颜色
        legend.setFormSize(15f);
        legend.setXEntrySpace(12f);
        legend.setTextSize(14f);  //图例文字的大小
    }

    private void loadPieChartData() {
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(0.2f, "Food & Dining"));
        entries.add(new PieEntry(0.15f, "Medical"));
        entries.add(new PieEntry(0.10f, "Entertainment"));
        entries.add(new PieEntry(0.25f, "Electricity and Gas"));
        entries.add(new PieEntry(0.3f, "Housing"));
//        float value = pieChart.isUsePercentValuesEnabled() ? entry.getY() / yValueSum * 100f : entry.getY();

        ArrayList<Integer> colors = new ArrayList<>();
        for (int color: ColorTemplate.MATERIAL_COLORS) {
            colors.add(color);
        }

        for (int color: ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(color);
        }

        PieDataSet dataSet = new PieDataSet(entries, "Expense Category");
        dataSet.setColors(colors);
        dataSet.setSliceSpace(3f);

        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(pieChart));
//        data.setValueFormatter(new );
        data.setValueTextSize(20f);
        data.setValueTextColor(Color.YELLOW);

        pieChart.setDrawEntryLabels(true);//只显示百分比不显示文字



        pieChart.highlightValues(null);// 撤销所有的亮点
        pieChart.setData(data);
        pieChart.invalidate();

/*

        pieData.setDrawValues(true);//饼状图上显示值
        dataSet.setValueLinePart1Length(0.3f);//设置连接线的长度
//x,y值在圆外显示(在圆外才会有连接线)
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
//数据连接线距图形片内部边界的距离，为百分数(0~100f)
        dataSet.setValueLinePart1OffsetPercentage(0f);
//设置x,y在圆外显示的值为透明(transparent = 0x00000000)
        pieData.setValueTextColor(transparent);
*/


        dataSet.setValueLinePart1OffsetPercentage(60.0f);
        dataSet.setValueLinePart1Length(0.8f);
        dataSet.setValueLinePart2Length(0.9f);
//        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setValueTextColor(getResources().getColor(R.color.colorPrimary));

//文字在饼图外面显示
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        pieChart.animateY(1400, Easing.EaseInOutQuad);
    }

    private void loadPieChartData2() {
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(0.5f, "aaa"));
        entries.add(new PieEntry(0.5f, "bbb"));

        ArrayList<Integer> colors = new ArrayList<>();
        for (int color: ColorTemplate.MATERIAL_COLORS) {
            colors.add(color);
        }

        for (int color: ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(color);
        }

        PieDataSet dataSet = new PieDataSet(entries, "Expense Category");
        dataSet.setColors(colors);
        dataSet.setSliceSpace(3f);

        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);
        pieChart.invalidate();

        pieChart.animateY(1000, Easing.EaseInOutQuad);
    }
}
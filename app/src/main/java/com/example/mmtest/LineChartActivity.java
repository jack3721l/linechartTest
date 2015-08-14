package com.example.mmtest;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.example.mmtest.gesture.ContainerScrollType;
import com.example.mmtest.gesture.ZoomType;
import com.example.mmtest.model.Axis;
import com.example.mmtest.model.Line;
import com.example.mmtest.model.LineChartData;
import com.example.mmtest.model.PointValue;
import com.example.mmtest.util.Utils;
import com.example.mmtest.view.LineChartView;

public class LineChartActivity extends ActionBarActivity {
	private RelativeLayout layout = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		layout = (RelativeLayout) findViewById(R.id.rootview);
		LineChartView lineChartView = new LineChartView(this);
		lineChartView.setLineChartData(generateLineChartData());
		lineChartView.setZoomType(ZoomType.HORIZONTAL);

		/** Note: Chart is within ViewPager so enable container scroll mode. **/
		lineChartView.setContainerScrollEnabled(false,
				ContainerScrollType.HORIZONTAL);

		layout.addView(lineChartView);
	}

	private LineChartData generateLineChartData() {
		int numValues = 10;

		List<PointValue> values = new ArrayList<PointValue>();
		for (int i = 0; i < numValues; ++i) {
			values.add(new PointValue(i, (float) Math.random() * 100f));
		}

		Line line = new Line(values);
		line.setColor(Utils.COLOR_GREEN);
		line.setFilled(true);
		List<Line> lines = new ArrayList<Line>();
		lines.add(line);

		LineChartData data = new LineChartData(lines);
		data.setAxisXBottom(new Axis().setName("Axis X").setHasLines(true));
		data.setAxisYRight(new Axis().setHasLines(true));
		return data;

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

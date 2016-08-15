using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Forms.DataVisualization.Charting;
namespace danciben
{
    public partial class Form10 : Form
    {
        public Form10()
        {
            InitializeComponent();
        }

        private void Form10_Load(object sender, EventArgs e)
        {
            ////////////////////ChartArea1属性设置///////////////////////////
            //设置网格的颜色
            chart1.ChartAreas["ChartArea1"].AxisX.MajorGrid.LineColor = Color.LightGray;
            chart1.ChartAreas["ChartArea1"].AxisY.MajorGrid.LineColor = Color.LightGray;
            //设置坐标轴名称
            chart1.ChartAreas["ChartArea1"].AxisX.Title = "随机数";
            chart1.ChartAreas["ChartArea1"].AxisY.Title = "数值";
            //启用3D显示
            chart1.ChartAreas["ChartArea1"].Area3DStyle.Enable3D = false;

            //////////////////////Series属性设置///////////////////////////
            //设置显示类型-线型
            chart1.Series["随机数"].ChartType = SeriesChartType.Line;
            //设置坐标轴Value显示类型
            chart1.Series["随机数"].XValueType = ChartValueType.Time;
            //是否显示标签的数值
            chart1.Series["随机数"].IsValueShownAsLabel = true;

            //设置标记图案
            chart1.Series["随机数"].MarkerStyle = MarkerStyle.Circle;
            //设置图案颜色
            chart1.Series["随机数"].Color = Color.Green;
            //设置图案的宽度
            chart1.Series["随机数"].BorderWidth = 3;

            //添加随机数
            Random rd = new Random();
            for (int i = 1; i < 20; i++)
            {
                chart1.Series["随机数"].Points.AddXY(i, rd.Next(100));
            }
        }
    }
}

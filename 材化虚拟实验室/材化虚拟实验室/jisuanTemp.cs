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

namespace 材化虚拟实验室
{
    public partial class jisuanTemp : Form
    {
        public jisuanTemp()
        {
            InitializeComponent();
        }
        public int time = 0;
        public string[] seriesName_x;
        public int seriesCount_x;
        public string[,] storedata_x;
        public double[] XData_x;

        private void jisuanTemp_SizeChanged(object sender, EventArgs e)
        {
            if (Form2.JTPF.WindowState == FormWindowState.Maximized)
            {
                Form1.f2.splitContainer1.Panel2.Controls.Clear();
                Form2.JTPF.TopLevel = false;
                Form2.JTPF.Height = Form1.f2.splitContainer1.Panel2.Height;
                Form2.JTPF.Width = Form1.f2.splitContainer1.Panel2.Width;

                Form2.JTPF.Location = new Point(0, 0);
                Form1.f2.splitContainer1.Panel2.Controls.Add(Form2.JTPF);
            }
            if (Form2.JTPF.WindowState == FormWindowState.Minimized)
            {
               
                Form2.JTPF.TopLevel = false;
                Form2.tpF.splitContainer2.Panel1.Controls.Add(Form2.JTPF);
                Form2.JTPF.Height = Form2.tpF.splitContainer2.Panel1.Height;
                Form2.JTPF.Width = Form2.tpF.splitContainer2.Panel1.Width;
                Form2.JTPF.Show();
                  
                Form2.tpF.TopLevel = false;
                Form2.tpF.Height = Form1.f2.splitContainer1.Panel2.Height;
                Form2.tpF.Width = Form1.f2.splitContainer1.Panel2.Width;
                Form2.tpF.Location = new Point(0, 0);
                Form1.f2.splitContainer1.Panel2.Controls.Add(Form2.tpF);

            }
        }
        public void chartplan(int times)
        {
            /*jisuan*/
            for (int i = 0; i < seriesCount_x; i++)
            {
                chart1.Series[i].ChartType = SeriesChartType.Line;
                chart1.Series[i].MarkerStyle = MarkerStyle.Circle;
                chart1.Series[i].Points.AddXY(XData_x[time], storedata_x[time, i]);

            }
        }

        private void jisuanTemp_Load(object sender, EventArgs e)
        {
            timer2.Start();
            Form2.XSf.timer2.Enabled = false;
            Form2.ZTf.timer2.Enabled = false;
            chart1.ChartAreas["ChartArea1"].AxisX.Title = "时间";
            chart1.ChartAreas["ChartArea1"].AxisY.Title = "温度";
            chart1.ChartAreas["ChartArea1"].Area3DStyle.Enable3D = false;
        }
        private const int CP_NOCLOSE_BUTTON = 0x200;
        protected override CreateParams CreateParams
        {
            get
            {
                CreateParams myCp = base.CreateParams;
                myCp.ClassStyle = myCp.ClassStyle | CP_NOCLOSE_BUTTON;
                return myCp;
            }
        }
        private void timer1_Tick(object sender, EventArgs e)
        {
            chartplan(time);
            time++;

            //   MessageBox.Show(textBox1.Text);
            if (XData_x[time] == 0)
            {
                this.timer1.Stop();
                Form2.tpF.timer1.Stop();
            }
        }

        private void timer2_Tick(object sender, EventArgs e)
        {
            Point point = chart1.PointToClient(Control.MousePosition);
            Point mp = MousePosition;
            //Point tp = mp - chart1.Location;
            //int x = mp.X - chart1.Location.X;
            // int y = mp.Y - chart1.Location.Y;

            if (0 < point.X && point.X < Form2.JTPF.chart1.Width && 0 < point.Y && point.Y < Form2.JTPF.chart1.Height)
            {

                toolTip1.Active = true;
                double py = chart1.ChartAreas["ChartArea1"].AxisY.PixelPositionToValue(point.Y);
                double px = chart1.ChartAreas["ChartArea1"].AxisX.PixelPositionToValue(point.X);
                string yvalue = py.ToString("#.00");
                string xvalue = px.ToString("#.00");
                Form1.f2.ctF.textBox1.Text = "时间:" + xvalue.ToString() + "s";
                Form1.f2.ctF.textBox2.Text = "温度:" + yvalue.ToString();
                toolTip1.Show("温度：" + yvalue.ToString(), Form1.f2.ctF.textBox2, mp.X - 300, mp.Y - 100);
            }
            else
            {
                toolTip1.Active = false;

            }
        }
    }
}

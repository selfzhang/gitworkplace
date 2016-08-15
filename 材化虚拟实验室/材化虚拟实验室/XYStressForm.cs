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
    public partial class XYStressForm : Form
    {
        public XYStressForm()
        {
            InitializeComponent();
        }

        public int time = 0;

      /*  public string[] seriesName_y;
        public int seriesCount_y;
        public string[,] storedata_y;
        public double[] XData_y;*/
        private void XYStressForm_Load(object sender, EventArgs e)
        {
        /*    chart2.ChartAreas["ChartArea1"].AxisX.Title = "时间";
            chart2.ChartAreas["ChartArea1"].AxisY.Title = "应力";
            chart2.ChartAreas["ChartArea1"].Area3DStyle.Enable3D = false;*/
        }
        public void chartplan(int times)
        {
           
            /* y*/
          /*  for (int i = 0; i < seriesCount_y; i++)
            {
                chart2.Series[i].ChartType = SeriesChartType.Line;
                chart2.Series[i].MarkerStyle = MarkerStyle.Circle;
               
                chart2.Series[i].Points.AddXY(XData_y[time], storedata_y[time, i]);

            }*/

        }

        private void timer1_Tick(object sender, EventArgs e)
        {
         /*   chartplan(time);
            time++;

            //   MessageBox.Show(textBox1.Text);
            if (XData_y[time] == 0)
            {
                this.timer1.Stop();
            }*/

            string path = "d:\\data\\picture\\" + time.ToString() + ".jpg";
            this.pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;
            this.pictureBox1.Image = Image.FromFile(@path);
            this.pictureBox2.SizeMode = PictureBoxSizeMode.StretchImage;
            this.pictureBox2.Image = Image.FromFile(@path);

            // chartplan(time);

            time++;
        }
    }
}

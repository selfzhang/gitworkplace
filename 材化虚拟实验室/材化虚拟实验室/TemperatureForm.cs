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
    public partial class TemperatureForm : Form
    {
     //   public Series[] series;
        public string[] seriesName_j;
        public int seriesCount_j;
        public int time =0;
        public string[,] storedata_j ;
        public double[] XData_j;

        public string[] seriesName_c;
        public int seriesCount_c;
        public string[,] storedata_c;
        public double[] XData_c;

        public TemperatureForm()
        {
            InitializeComponent();
        }

        private void TemperatureForm_Load(object sender, EventArgs e)
        {
           
        }
        public void chartplan(int times)
        {
           
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            string path = "d:\\data\\picture\\" + time.ToString() + ".jpg";
            this.pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;
            this.pictureBox1.Image = Image.FromFile(@path);
           

           // chartplan(time);
           
            time++;
          
            //   MessageBox.Show(textBox1.Text);
            /*if (XData_j[time] == 0)
            {
                this.timer1.Stop();
            }*/

        }
       
    }
}

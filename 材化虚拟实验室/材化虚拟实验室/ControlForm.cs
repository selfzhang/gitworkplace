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
    public partial class ControlForm : Form
    {
        public ControlForm()
        {
            InitializeComponent();
        }
        public static string cailiao;
        public static string lingjian;
        public static string gongyi;
        public void setJisuanTemp(string cailiao,string lingjian,string gongyi)
        {
            Form2.JTPF.chart1.Series.Clear();
            string filename1 = "d:\\data\\" + cailiao + lingjian + gongyi + "计算.xls";
            excel Excel = new excel();
            Form2.JTPF.storedata_x = Excel.readData(filename1, Form2.JTPF.storedata_x);
            Form2.JTPF.XData_x = Excel.setX(filename1, Form2.JTPF.XData_x);
            Form2.JTPF.seriesName_x = Excel.setName(filename1, Form2.JTPF.seriesName_x);
            Form2.JTPF.seriesCount_x = Form2.JTPF.storedata_x.GetLength(1);
            for (int i = 0; i < Form2.JTPF.seriesCount_x; i++)
            {
                Form2.JTPF.chart1.Series.Add(Form2.JTPF.seriesName_x[i].ToString() + i);
            }
            /*  Form2.JTPF.time = 0;
              Form2.JTPF.timer1.Enabled = true;
              Form2.JTPF.timer1.Start();*/

        }
        public void setCeliangTemp(string cailiao, string lingjian, string gongyi)
        {

            Form2.CTPF.chart1.Series.Clear();
            string filename1 = "d:\\data\\" + cailiao + lingjian +gongyi + "测量.xls";
            excel Excel = new excel();
            Form2.CTPF.storedata_x = Excel.readData(filename1, Form2.CTPF.storedata_x);
            Form2.CTPF.XData_x = Excel.setX(filename1, Form2.CTPF.XData_x);
            Form2.CTPF.seriesName_x = Excel.setName(filename1, Form2.CTPF.seriesName_x);
            Form2.CTPF.seriesCount_x = Form2.CTPF.storedata_x.GetLength(1);
            for (int i = 0; i < Form2.CTPF.seriesCount_x; i++)
            {
                Form2.CTPF.chart1.Series.Add(Form2.CTPF.seriesName_x[i].ToString() + i);
            }
            /*  Form2.CTPF.time = 0;
              Form2.CTPF.timer1.Enabled = true;
              Form2.CTPF.timer1.Start();*/
        }
        /*  public void temperatureStart()
          {

              Form2.tpF.chart1.Series.Clear();
              Form2.tpF.chart2.Series.Clear();
              string filename1 = "\\data\\" + SchemeDesign.cailiao + SchemeDesign.lingjian + SchemeDesign.gongyi + "计算.xls";
              string filename2 = "\\data\\" + SchemeDesign.cailiao + SchemeDesign.lingjian + SchemeDesign.gongyi + "测量.xls";
              //   MessageBox.Show(filename1+"  "+filename1);
              excel Excel = new excel();
              Form2.tpF.storedata_j = Excel.readData(filename1, Form2.tpF.storedata_j);
              Form2.tpF.XData_j = Excel.setX(filename1, Form2.tpF.XData_j);
              Form2.tpF.seriesName_j = Excel.setName(filename1, Form2.tpF.seriesName_j);
              Form2.tpF.seriesCount_j = Form2.tpF.storedata_j.GetLength(1);
              for (int i = 0; i < Form2.tpF.seriesCount_j; i++)
              {
                  Form2.tpF.chart1.Series.Add(Form2.tpF.seriesName_j[i].ToString() + i);
              }

              Form2.tpF.storedata_c = Excel.readData(filename2, Form2.tpF.storedata_c);
              Form2.tpF.XData_c = Excel.setX(filename2, Form2.tpF.XData_c);
              Form2.tpF.seriesName_c = Excel.setName(filename2, Form2.tpF.seriesName_c);
              Form2.tpF.seriesCount_c = Form2.tpF.storedata_c.GetLength(1);
              for (int i = 0; i < Form2.tpF.seriesCount_c; i++)
              {
                  Form2.tpF.chart2.Series.Add(Form2.tpF.seriesName_c[i].ToString() + i);
              }


              Form2.tpF.time = 0;
              Form2.tpF.timer1.Enabled = true;
              Form2.tpF.timer1.Start();
          }*/
        public void setXstress(string cailiao, string lingjian, string gongyi)
        {

            Form2.XSf.chart1.Series.Clear();
            string filename1 = "d:\\data\\" + cailiao + lingjian + gongyi + "计算stress.xls";
            excel Excel = new excel();
            Form2.XSf.storedata_x = Excel.readData(filename1, Form2.XSf.storedata_x);
            Form2.XSf.XData_x = Excel.setX(filename1, Form2.XSf.XData_x);
            Form2.XSf.seriesName_x = Excel.setName(filename1, Form2.XSf.seriesName_x);
            Form2.XSf.seriesCount_x = Form2.XSf.storedata_x.GetLength(1);
            for (int i = 0; i < Form2.XSf.seriesCount_x; i++)
            {
                Form2.XSf.chart1.Series.Add(Form2.XSf.seriesName_x[i].ToString() + i);
            }
            /*   Form2.XSf.time = 0;
               Form2.XSf.timer1.Enabled = true;
               Form2.XSf.timer1.Start();*/
        }
        public void setYstress(string cailiao, string lingjian, string gongyi)
        {

            Form2.YSf.chart1.Series.Clear();
            string filename1 = "d:\\data\\" + cailiao + lingjian + gongyi + "计算stress.xls";
            excel Excel = new excel();
            Form2.YSf.storedata_x = Excel.readData(filename1, Form2.YSf.storedata_x);
            Form2.YSf.XData_x = Excel.setX(filename1, Form2.YSf.XData_x);
            Form2.YSf.seriesName_x = Excel.setName(filename1, Form2.YSf.seriesName_x);
            Form2.YSf.seriesCount_x = Form2.YSf.storedata_x.GetLength(1);
            for (int i = 0; i < Form2.YSf.seriesCount_x; i++)
            {
                Form2.YSf.chart1.Series.Add(Form2.YSf.seriesName_x[i].ToString() + i);
            }
            /*   Form2.YSf.time = 0;
               Form2.YSf.timer1.Enabled = true;
               Form2.YSf.timer1.Start();*/
        }

        /*  public void XYstressStart(){

           
              Form2.xysF.chart2.Series.Clear();
              string filename1 = "\\data\\" + SchemeDesign.cailiao + SchemeDesign.lingjian + SchemeDesign.gongyi + "计算stress.xls";
              string filename2 = "\\data\\" + SchemeDesign.cailiao + SchemeDesign.lingjian + SchemeDesign.gongyi + "计算stress.xls";
              excel Excel = new excel();
           
            

              Form2.xysF.storedata_y = Excel.readData(filename2, Form2.xysF.storedata_y);
              Form2.xysF.XData_y = Excel.setX(filename2, Form2.xysF.XData_y);
              Form2.xysF.seriesName_y = Excel.setName(filename2, Form2.xysF.seriesName_y);
              Form2.xysF.seriesCount_y = Form2.xysF.storedata_y.GetLength(1);
              for (int i = 0; i < Form2.xysF.seriesCount_y; i++)
              {
                  Form2.xysF.chart2.Series.Add(Form2.xysF.seriesName_y[i].ToString() + i);
              }


              Form2.xysF.time = 0;
              Form2.xysF.timer1.Enabled = true;
              Form2.xysF.timer1.Start();
        
        
          }*/

        public void setZstress(string cailiao, string lingjian, string gongyi)
        {
            Form2.ZTf.chart1.Series.Clear();
            string filename1 = "d:\\data\\" + cailiao + lingjian + gongyi + "计算stress.xls";
            excel Excel = new excel();
            Form2.ZTf.storedata_x = Excel.readData(filename1, Form2.ZTf.storedata_x);
            Form2.ZTf.XData_x = Excel.setX(filename1, Form2.ZTf.XData_x);
            Form2.ZTf.seriesName_x = Excel.setName(filename1, Form2.ZTf.seriesName_x);
            Form2.ZTf.seriesCount_x = Form2.ZTf.storedata_x.GetLength(1);
            for (int i = 0; i < Form2.ZTf.seriesCount_x; i++)
            {
                Form2.ZTf.chart1.Series.Add(Form2.ZTf.seriesName_x[i].ToString() + i);
            }
            /*   Form2.ZTf.time = 0;
               Form2.ZTf.timer1.Enabled = true;
               Form2.ZTf.timer1.Start();*/
        }
        public void setMissesStress(string cailiao, string lingjian, string gongyi)
        {

            Form2.MSf.chart1.Series.Clear();
            string filename1 = "d:\\data\\" + cailiao + lingjian + gongyi + "计算stress.xls";
            excel Excel = new excel();
            Form2.MSf.storedata_x = Excel.readData(filename1, Form2.MSf.storedata_x);
            Form2.MSf.XData_x = Excel.setX(filename1, Form2.MSf.XData_x);
            Form2.MSf.seriesName_x = Excel.setName(filename1, Form2.MSf.seriesName_x);
            Form2.MSf.seriesCount_x = Form2.MSf.storedata_x.GetLength(1);
            for (int i = 0; i < Form2.MSf.seriesCount_x; i++)
            {
                Form2.MSf.chart1.Series.Add(Form2.MSf.seriesName_x[i].ToString() + i);
            }
            /*    Form2.MSf.time = 0;
                Form2.MSf.timer1.Enabled = true;
                Form2.MSf.timer1.Start();*/

        }
        /*    public void ZMstressStart()
            {

                Form2.zesF.chart1.Series.Clear();
                Form2.zesF.chart2.Series.Clear();
                string filename1 = "\\data\\" + SchemeDesign.cailiao + SchemeDesign.lingjian + SchemeDesign.gongyi + "计算stress.xls";
                string filename2 = "\\data\\" + SchemeDesign.cailiao + SchemeDesign.lingjian + SchemeDesign.gongyi + "计算stress.xls";
                excel Excel = new excel();
                Form2.zesF.storedata_z = Excel.readData(filename1, Form2.zesF.storedata_z);
                Form2.zesF.XData_z = Excel.setX(filename1, Form2.zesF.XData_z);
                Form2.zesF.seriesName_z = Excel.setName(filename1, Form2.zesF.seriesName_z);
                Form2.zesF.seriesCount_z = Form2.zesF.storedata_z.GetLength(1);
                for (int i = 0; i < Form2.zesF.seriesCount_z; i++)
                {
                    Form2.zesF.chart1.Series.Add(Form2.zesF.seriesName_z[i].ToString() + i);
                }

                Form2.zesF.storedata_m = Excel.readData(filename2, Form2.zesF.storedata_m);
                Form2.zesF.XData_m = Excel.setX(filename2, Form2.zesF.XData_m);
                Form2.zesF.seriesName_m = Excel.setName(filename2, Form2.zesF.seriesName_m);
                Form2.zesF.seriesCount_m = Form2.zesF.storedata_m.GetLength(1);
                for (int i = 0; i < Form2.zesF.seriesCount_m; i++)
                {
                    Form2.zesF.chart2.Series.Add(Form2.zesF.seriesName_m[i].ToString() + i);
                }


                Form2.zesF.time = 0;
                Form2.zesF.timer1.Enabled = true;
                Form2.zesF.timer1.Start();


            }*/
        public void AllStart()
        {

            Form2.JTPF.time = 0;
          Form2.JTPF.timer1.Enabled = true;
            Form2.JTPF.timer1.Start();

            Form2.CTPF.time = 0;
            Form2.CTPF.timer1.Enabled = true;
            Form2.CTPF.timer1.Start();

            Form2.XSf.time = 0;
            Form2.XSf.timer1.Enabled = true;
            Form2.XSf.timer1.Start();

            Form2.YSf.time = 0;
            Form2.YSf.timer1.Enabled = true;
            Form2.YSf.timer1.Start();

            Form2.MSf.time = 0;
            Form2.MSf.timer1.Enabled = true;
            Form2.MSf.timer1.Start();

            Form2.ZTf.time = 0;
            Form2.ZTf.timer1.Enabled = true;
            Form2.ZTf.timer1.Start();

        }
        private void button7_Click(object sender, EventArgs e)
        {
        //    MessageBox.Show(cailiao+"  "+lingjian+"  "+gongyi);
            try
            {
                if (button7.Text.Equals("开始"))
                {
                    setXstress(cailiao,lingjian,gongyi);
                    setYstress(cailiao, lingjian, gongyi);
                   setJisuanTemp(cailiao, lingjian, gongyi);
                    setCeliangTemp(cailiao, lingjian, gongyi);
                    setMissesStress(cailiao, lingjian, gongyi);
                    setZstress(cailiao, lingjian, gongyi);
                   // MessageBox.Show("jisuan:"+Form2.JTPF.seriesCount_x+"  celiang:"+Form2.CTPF.seriesCount_x+"  zstress:"+Form2.ZTf.seriesCount_x+"  xstress:"+Form2.XSf.seriesCount_x);
                    AllStart();
                    Form2.tpF.timer1.Start();
                    Form2.xysF.timer1.Start();
                    Form2.zesF.timer1.Start();
                     //temperatureStart();
                    // XYstressStart();
                    //    ZMstressStart();
                    button7.Text = "重置";
                }
                else if (button7.Text.Equals("重置"))
                {
                    if (MessageBox.Show("确定提交吗？", "提示", MessageBoxButtons.YesNo) == DialogResult.Yes)
                    {
                        Form2.JTPF.timer1.Enabled = false;
                        Form2.CTPF.timer1.Enabled = false;
                        Form2.XSf.timer1.Enabled = false;
                        Form2.YSf.timer1.Enabled = false;
                        Form2.MSf.timer1.Enabled = false;
                        Form2.ZTf.timer1.Enabled = false;
                        Form2.tpF.timer1.Enabled = false;
                        Form2.xysF.timer1.Enabled = false;
                        Form2.zesF.timer1.Enabled = false;

                        Form2.CTPF.chart1.Series.Clear();
                        Form2.JTPF.chart1.Series.Clear();
                        Form2.XSf.chart1.Series.Clear();
                        Form2.YSf.chart1.Series.Clear();
                        Form2.ZTf.chart1.Series.Clear();
                        Form2.MSf.chart1.Series.Clear();
                        Form2.tpF.time = 0;
                        Form1.f2.splitContainer1.Panel2.Controls.Clear();
                        Form2.sdF.TopLevel = false;
                        Form2.sdF.Location = new Point(0, 0);
                        Form2.sdF.WindowState = FormWindowState.Maximized;//布满
                        Form1.f2.splitContainer1.Panel2.Controls.Add(Form2.sdF);
                        Form2.sdF.Show();
                        SchemeDesign.cailiao = null;
                        button7.Text = "开始";
                    }
                    else
                    {


                    }

                }
            }
            catch (Exception e1)
            {
                // MessageBox.Show(e1.Message);
                if (MessageBox.Show("请检查上一步的工艺卡片是否填写正确？", "提示", MessageBoxButtons.YesNo) == DialogResult.Yes)
                {
                    Form1.f2.splitContainer1.Panel2.Controls.Clear();
                    Form2.sdF.TopLevel = false;
                    Form2.sdF.Location = new Point(0, 0);
                    Form2.sdF.WindowState = FormWindowState.Maximized;//布满
                    Form1.f2.splitContainer1.Panel2.Controls.Add(Form2.sdF);
                    Form2.sdF.Show();
                }
            }
        }
        private void button8_Click(object sender, EventArgs e)
        {
            // Form2.tpF.timer1.Enabled = false;
            if (this.button8.Text.Equals("暂停"))
            {

                Form2.JTPF.timer1.Enabled = false;
                Form2.CTPF.timer1.Enabled = false;
                Form2.XSf.timer1.Enabled = false;
                Form2.YSf.timer1.Enabled = false;
                Form2.MSf.timer1.Enabled = false;
                Form2.ZTf.timer1.Enabled = false;
                Form2.tpF.timer1.Enabled = false;
                Form2.xysF.timer1.Enabled = false;
                Form2.zesF.timer1.Enabled = false;
                this.button8.Text = "继续";

            }
            else if (this.button8.Text.Equals("继续"))
            {
                Form2.tpF.timer1.Enabled = true;
                Form2.xysF.timer1.Enabled = true;
                Form2.zesF.timer1.Enabled = true;
                Form2.JTPF.timer1.Enabled = true;
                Form2.CTPF.timer1.Enabled = true;
                Form2.XSf.timer1.Enabled = true;
                Form2.YSf.timer1.Enabled = true;
                Form2.MSf.timer1.Enabled = true;
                Form2.ZTf.timer1.Enabled = true;
                this.button8.Text = "暂停";
            }
        }
        private void ControlForm_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            //*wenduchang*/
            Form2.JTPF.TopLevel = false;
            Form2.tpF.splitContainer2.Panel1.Controls.Add(Form2.JTPF);//jtp
            Form2.JTPF.Height = Form2.tpF.splitContainer2.Panel1.Height;
            Form2.JTPF.Width = Form2.tpF.splitContainer2.Panel1.Width;
            
            Form2.CTPF.TopLevel = false;
            Form2.tpF.splitContainer2.Panel2.Controls.Add(Form2.CTPF);//ctp
            Form2.CTPF.Height = Form2.tpF.splitContainer2.Panel2.Height;
            Form2.CTPF.Width = Form2.tpF.splitContainer2.Panel2.Width;
           
            Form1.f2.splitContainer1.Panel2.Controls.Clear();
            Form2.tpF.TopLevel = false;
            Form2.tpF.Height = Form1.f2.splitContainer1.Panel2.Height;
            Form2.tpF.Width = Form1.f2.splitContainer1.Panel2.Width;
            Form2.tpF.Location = new Point(0, 0);
            Form1.f2.splitContainer1.Panel2.Controls.Add(Form2.tpF);

         
            Form2.tpF.Show();
            Form2.CTPF.Show();
            Form2.JTPF.Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {/*xystress*/
            Form2.XSf.TopLevel = false;
            Form2.xysF.splitContainer2.Panel1.Controls.Add(Form2.XSf);
            Form2.XSf.Height = Form2.xysF.splitContainer2.Panel1.Height;
            Form2.XSf.Width = Form2.xysF.splitContainer2.Panel1.Width;
            Form2.XSf.Show();

            Form2.YSf.TopLevel = false;
            Form2.xysF.splitContainer3.Panel1.Controls.Add(Form2.YSf);
            Form2.YSf.Height = Form2.xysF.splitContainer3.Panel1.Height;
            Form2.YSf.Width = Form2.xysF.splitContainer3.Panel1.Width;
            Form2.YSf.Show();

            Form1.f2.splitContainer1.Panel2.Controls.Clear();
            Form2.xysF.TopLevel = false;
            Form2.xysF.Height = Form1.f2.splitContainer1.Panel2.Height;
            Form2.xysF.Width = Form1.f2.splitContainer1.Panel2.Width;
            Form2.xysF.Location = new Point(0, 0);
            Form1.f2.splitContainer1.Panel2.Controls.Add(Form2.xysF);

            Form2.xysF.chart2.Visible = false;

            Form2.xysF.Show();

        }

        private void button3_Click(object sender, EventArgs e)
        {
            Form2.ZTf.TopLevel = false;
            Form2.zesF.splitContainer2.Panel1.Controls.Add(Form2.ZTf);
            Form2.ZTf.Height = Form2.zesF.splitContainer2.Panel1.Height;
            Form2.ZTf.Width = Form2.zesF.splitContainer2.Panel1.Width;
            Form2.ZTf.Show();

            Form2.MSf.TopLevel = false;
            Form2.zesF.splitContainer3.Panel1.Controls.Add(Form2.MSf);
            Form2.MSf.Height = Form2.zesF.splitContainer3.Panel1.Height;
            Form2.MSf.Width = Form2.zesF.splitContainer3.Panel1.Width;
            Form2.MSf.Show();

            Form1.f2.splitContainer1.Panel2.Controls.Clear();
            Form2.zesF.TopLevel = false;
            Form2.zesF.Height = Form1.f2.splitContainer1.Panel2.Height;
            Form2.zesF.Width = Form1.f2.splitContainer1.Panel2.Width;
            Form2.zesF.Location = new Point(0, 0);
            Form1.f2.splitContainer1.Panel2.Controls.Add(Form2.zesF);

            Form2.zesF.chart1.Visible = false;
            Form2.zesF.chart2.Visible = false;

            Form2.zesF.Show();
        }

        private void button4_Click(object sender, EventArgs e)
        {/*canyuyingli*/

        }

        private void button5_Click(object sender, EventArgs e)
        {
            /*zuzhichang*/
        }

        private void button6_Click(object sender, EventArgs e)
        {
            /*shishibianhua*/
        }

        private void button9_Click(object sender, EventArgs e)
        {
            /*sezhou*/
        }
    }
}

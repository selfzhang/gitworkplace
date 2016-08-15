using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 材化虚拟实验室
{
    public partial class Form2 : Form
    {
        public viewForm vF = new viewForm();
        public static SchemeDesign sdF = new SchemeDesign();
        public MaterialForm mF = new MaterialForm();
        public textIntroduce tF = new textIntroduce();
        public gongJianForm gF = new gongJianForm();
        public tuzhiForm tzF = new tuzhiForm();
        public fangZhenForm fzF = new fangZhenForm();
        public static TemperatureForm tpF = new TemperatureForm();
        public static XYStressForm xysF = new XYStressForm();
        public static ZEquivalentStressForm zesF = new ZEquivalentStressForm();
        public ResidualStressForm rsF = new ResidualStressForm();
        public static zongheyshiForm zhyF = new zongheyshiForm();
        public zuzhiForm zzF = new zuzhiForm();
       
        public ControlForm ctF = new ControlForm();

        public static Xstress XSf = new Xstress();
        public static Ystress YSf = new Ystress();

        public static jisuanTemp JTPF = new jisuanTemp();
        public static celiangTepm CTPF = new celiangTepm();

        public static Zstress ZTf = new Zstress();
        public static MissesStress MSf = new MissesStress();
        public Form2()
        {
            InitializeComponent();
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            
            
        }

        private void treeView1_AfterSelect(object sender, TreeViewEventArgs e)
        {
            switch (this.treeView1.SelectedNode.Text)
            {
                case "热处理工艺演示":

                    vF.TopLevel = false;

                    vF.Width = this.splitContainer1.Panel2.Width;
                    vF.Height = this.splitContainer1.Panel2.Height;
                    vF.WindowState = FormWindowState.Maximized;//布满
                    vF.Location = new Point(0, 0);
                    this.splitContainer1.Panel2.Controls.Clear();
                    this.splitContainer1.Panel2.Controls.Add(vF);
                    vF.Show();
                    this.treeView1.SelectedNode = null;
                    break;

                case "工艺介绍":
                    this.splitContainer1.Panel2.Controls.Clear();
                    tF.TopLevel = false;
                    tF.Location = new Point(0, 0);
                    tF.Width = this.splitContainer1.Panel2.Width;
                    tF.Height = this.splitContainer1.Panel2.Height;
                    tF.WindowState = FormWindowState.Maximized;//布满

                    this.splitContainer1.Panel2.Controls.Add(tF);
                    tF.Show();
                    this.treeView1.SelectedNode = null;
                    break;

                case "方案设计":
                    this.splitContainer1.Panel2.Controls.Clear();
                    sdF.TopLevel = false;
                    sdF.Location = new Point(0, 0);

                    sdF.WindowState = FormWindowState.Maximized;//布满

                    this.splitContainer1.Panel2.Controls.Add(sdF);
                    sdF.Show();
                    this.treeView1.SelectedNode = null;
                    break;

                case "材料库":
                    mF.TopLevel = false;
                    mF.Height = this.splitContainer1.Panel2.Height;
                    mF.Location = new Point(0, 0);
                    this.mF.WindowState = FormWindowState.Normal;
                    this.splitContainer1.Panel2.Controls.Add(mF);
                    mF.Hide();
                    mF.Show();
                    this.treeView1.SelectedNode = null;
                    break;
                case "图纸库":
                    tzF.TopLevel = false;
                    tzF.Height = this.splitContainer1.Panel2.Height;
                    tzF.Location = new Point(0, 0);
                    this.tzF.WindowState = FormWindowState.Normal;
                    this.splitContainer1.Panel2.Controls.Add(tzF);
                    tzF.Hide();
                    tzF.Show();
                    this.treeView1.SelectedNode = null;
                    break;
                case "零件库":
                    gF.TopLevel = false;
                    gF.Height = this.splitContainer1.Panel2.Height;
                    gF.Location = new Point(0, 0);
                    Form2.sdF.WindowState = FormWindowState.Normal;
                    this.splitContainer1.Panel2.Controls.Add(gF);
                    gF.Hide();
                    gF.Show();
                    this.treeView1.SelectedNode = null;
                    break;
                case "工艺曲线":
                    this.splitContainer1.Panel2.Controls.Clear();
                    gongyiquxianForm wF = new gongyiquxianForm();
                    wF.TopLevel = false;
                    wF.Height = this.splitContainer1.Panel2.Height;
                    wF.Width = this.splitContainer1.Panel2.Width;
                    wF.Location = new Point(0, 0);
                    this.splitContainer1.Panel2.Controls.Add(wF);

                    wF.Hide();
                    wF.Show();
                    this.treeView1.SelectedNode = null;
                    break;
                case "实验过程":
                    ctF.Close();
                    ctF.Show();
                    this.splitContainer1.Panel2.Controls.Clear();
                    fzF.TopLevel = false;
                    fzF.Height = this.splitContainer1.Panel2.Height;
                    fzF.Width = this.splitContainer1.Panel2.Width;
                    fzF.Location = new Point(0, 0);
                    this.splitContainer1.Panel2.Controls.Add(fzF);
                    fzF.Hide();
                    fzF.Show();
                    this.treeView1.SelectedNode = null;
                    break;
                case "温度场":
                    JTPF.TopLevel = false;
                    tpF.splitContainer2.Panel1.Controls.Add(JTPF);
                    JTPF.Height = tpF.splitContainer2.Panel1.Height;
                    JTPF.Width = tpF.splitContainer2.Panel1.Width;
               
                    JTPF.Show();

                    CTPF.TopLevel = false;
                    tpF.splitContainer2.Panel2.Controls.Add(CTPF);
                    CTPF.Height = tpF.splitContainer2.Panel2.Height;
                    CTPF.Width = tpF.splitContainer2.Panel2.Width;
             
                    CTPF.Show();

                    

                    tpF.TopLevel = false;
                    tpF.Height = this.splitContainer1.Panel2.Height;
                    tpF.Width = this.splitContainer1.Panel2.Width;
                    tpF.Location = new Point(0, 0);
                    this.splitContainer1.Panel2.Controls.Add(tpF);
                    fzF.WindowState = FormWindowState.Normal;
                    tpF.Hide();
                    tpF.Show();
                    this.treeView1.SelectedNode = null;
                    break;
                case "X轴方向应力_Y轴方向应力":

                    XSf.TopLevel = false;
                    xysF.splitContainer2.Panel1.Controls.Add(XSf);
                    XSf.Height = xysF.splitContainer2.Panel1.Height;
                    XSf.Width = xysF.splitContainer2.Panel1.Width;
                    XSf.Show();

                    YSf.TopLevel = false;
                    xysF.splitContainer3.Panel1.Controls.Add(YSf);
                    YSf.Height = xysF.splitContainer3.Panel1.Height;
                    YSf.Width = xysF.splitContainer3.Panel1.Width;
                    YSf.Show();

                    xysF.chart2.Visible = false;
                    xysF.TopLevel = false;
                    xysF.Height = this.splitContainer1.Panel2.Height;
                    xysF.Width = this.splitContainer1.Panel2.Width;
                    xysF.Location = new Point(0, 0);
                    this.splitContainer1.Panel2.Controls.Add(xysF);
                    //  xysF.WindowState = FormWindowState.Normal;
                    xysF.Hide();
                    xysF.Show();
                    this.treeView1.SelectedNode = null;
                    break;

                case "Ｚ轴方向应力_Misses应力场":
                    ZTf.TopLevel = false;
                    zesF.splitContainer2.Panel1.Controls.Add(ZTf);
                    ZTf.Height = zesF.splitContainer2.Panel1.Height;
                    ZTf.Width = zesF.splitContainer2.Panel1.Width;
                    ZTf.Show();

                    MSf.TopLevel = false;
                    zesF.splitContainer3.Panel1.Controls.Add(MSf);
                    MSf.Height = zesF.splitContainer3.Panel1.Height;
                    MSf.Width = zesF.splitContainer3.Panel1.Width;
                    MSf.Show();

                    zesF.chart2.Visible = false;
                    zesF.chart1.Visible = false;
                    zesF.TopLevel = false;
                    zesF.Height = this.splitContainer1.Panel2.Height;
                    zesF.Width = this.splitContainer1.Panel2.Width;
                    zesF.Location = new Point(0, 0);
                    this.splitContainer1.Panel2.Controls.Add(zesF);
                    //  xysF.WindowState = FormWindowState.Normal;
                    zesF.Hide();
                    zesF.Show();
                    this.treeView1.SelectedNode = null;
                    break;
                case "残余应力分布云图":
                    rsF.TopLevel = false;
                    rsF.Height = this.splitContainer1.Panel2.Height;
                    rsF.Width = this.splitContainer1.Panel2.Width;
                    rsF.Location = new Point(0, 0);
                    this.splitContainer1.Panel2.Controls.Add(rsF);
                    //  xysF.WindowState = FormWindowState.Normal;
                    rsF.Hide();
                    rsF.Show();
                    this.treeView1.SelectedNode = null;
                    break;
                case "组织场":
                    zzF.TopLevel = false;
                    zzF.Height = this.splitContainer1.Panel2.Height;
                    zzF.Width = this.splitContainer1.Panel2.Width;
                    zzF.Location = new Point(0, 0);
                    this.splitContainer1.Panel2.Controls.Add(zzF);
                    //  xysF.WindowState = FormWindowState.Normal;
                    zzF.Hide();
                    zzF.Show();
                    this.treeView1.SelectedNode = null;
                    break;
                case "多场实时变化":                 
                    zhyF.TopLevel = false;
                    zhyF.Height = this.splitContainer1.Panel2.Height;
                    zhyF.Width = this.splitContainer1.Panel2.Width;
                    zhyF.Location = new Point(0, 0);
                    this.splitContainer1.Panel2.Controls.Add(zhyF);
                    //  xysF.WindowState = FormWindowState.Normal;
                    zhyF.Hide();
                    zhyF.Show();
                    this.treeView1.SelectedNode = null;
                    break;
            }



        }
       

    }
}

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
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        public static  Form2 f2 = new Form2();
        private void Form1_Load(object sender, EventArgs e)
        {
            Rectangle rect = new Rectangle();
            rect = Screen.GetWorkingArea(this);
            this.Height = rect.Height;
            this.Width = rect.Width;
         this.FormBorderStyle = FormBorderStyle.FixedDialog;//去除边框
        }

     

        private void button1_Click_1(object sender, EventArgs e)
        {

            this.Hide();
          
            f2.Show();
        }

      

      
    }
}
